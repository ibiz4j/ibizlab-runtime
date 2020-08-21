package cn.ibizlab.core.workflow.extensions.service;

import cn.ibizlab.core.workflow.extensions.domain.FlowUser;
import cn.ibizlab.core.workflow.domain.*;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.core.workflow.mapper.WFCoreMapper;
import cn.ibizlab.core.workflow.service.IWFGroupService;
import cn.ibizlab.core.workflow.service.IWFProcessDefinitionService;
import cn.ibizlab.core.workflow.service.IWFUserService;
import cn.ibizlab.util.client.IBZUAAFeignClient;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.RuleUtils;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.RemoteService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.flowable.bpmn.BpmnAutoLayout;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.common.engine.api.history.HistoricData;
import org.flowable.common.engine.api.identity.AuthenticationContext;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.common.engine.impl.identity.UserIdAuthenticationContext;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.history.ProcessInstanceHistoryLog;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Comment;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.service.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.flowable.ui.common.security.SecurityUtils;
import org.flowable.ui.modeler.domain.AbstractModel;
import org.flowable.ui.modeler.domain.AppModelDefinition;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.model.AppDefinitionRepresentation;
import org.flowable.ui.modeler.model.AppDefinitionSaveRepresentation;
import org.flowable.ui.modeler.model.ModelKeyRepresentation;
import org.flowable.ui.modeler.model.ModelRepresentation;
import org.flowable.ui.modeler.serviceapi.AppDefinitionService;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.*;

@Service("wfCoreService")
@Slf4j
public class WFCoreService
{

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private WFModelService wfModelService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private IWFUserService iwfUserService;

	@Autowired
	protected AppDefinitionService appDefinitionService;

	@Autowired
	private IWFGroupService iwfGroupService;

	@Autowired
	private IWFProcessDefinitionService iwfProcessDefinitionService;

	@Autowired
	private AuthTokenUtil jwtTokenUtil;

	@Autowired
	private WFCoreMapper wfCoreMapper;

	@Autowired
	private IBZUAAFeignClient ibzuaaFeignClient;

	private AuthenticationContext createAuthenticationContext()
	{
        UserIdAuthenticationContext context=new UserIdAuthenticationContext();
		AuthenticationUser user=AuthenticationUser.getAuthenticationUser();
        FlowUser principal=new FlowUser();
        principal.setUser(user);
        String token="";
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(requestAttributes!=null) {
			HttpServletRequest request = requestAttributes.getRequest();
			Object tk=request.getHeader("Authorization");
			if(tk!=null)
				token=tk.toString();
		}
		if(StringUtils.isEmpty(token))
		{
			token="Bearer "+jwtTokenUtil.generateToken(user);
		}

        principal.setToken(token);
        context.setPrincipal((Principal) principal);
		return context;
	}



	public List<WFProcessDefinition> getWorkflow(String system,String appname,String entity) {
		return wfModelService.getWorkflow(system,entity);
	}

	public List<String> getWorkflowKey(String system,String appname,String entity) {
		List<String> definitionKeys=new ArrayList<>();
		for(WFProcessDefinition wfdef:wfModelService.getWorkflow(system,entity))
			definitionKeys.add(wfdef.getDefinitionkey());
		return definitionKeys;
	}

	public List<WFProcessNode> getWFStep(String system,String appname, String entity) {
		List<WFProcessNode> rt=new ArrayList<>();
		for(WFProcessDefinition wfdef:wfModelService.getWorkflow(system,entity)) {
			LinkedHashMap<String,UserTask> userTasks = wfModelService.getModelStepByKey(wfdef.getDefinitionkey());
			for(UserTask userTask:userTasks.values()) {
				WFProcessNode node=new WFProcessNode();
				node.setUsertaskid(userTask.getId());
				node.setUsertaskname(userTask.getName());
				node.setProcessdefinitionkey(wfdef.getDefinitionkey());
				node.setProcessdefinitionname(wfdef.getDefinitionname());
				rt.add(node);
			}
		}
		return rt;
	}

	public List<WFProcessNode> getWFStep2(String system,String appname, String entity) {
		WFTaskSearchContext context = new WFTaskSearchContext();
		context.setSize(1000);
		context.setN_definitionkey_leftlike(system+"-"+entity);
		return wfCoreMapper.searchMyTaskCnt(context,context.getSearchCond());
	}


	public Map<String,Long> getWFStepCnt(String system,String appname, String entity,String processDefinitionKey,String wfstepcode)
	{
		Map<String,Long> wfStepCnt = new LinkedHashMap<String,Long>();
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			return wfStepCnt;

		//runtimeService.createNativeProcessInstanceQuery().
		TaskQuery query=taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		if(!StringUtils.isEmpty(processDefinitionKey))
			query.processDefinitionKey(processDefinitionKey);
		else {
			query.processDefinitionKeyIn(this.getWorkflowKey(system,appname,entity));
		}
		if(!StringUtils.isEmpty(wfstepcode)) {
			if(wfstepcode.indexOf("tid-")!=0) {
				wfstepcode = "tid-" + wfstepcode + "-";
				query.taskDefinitionKeyLike(wfstepcode);
			}
			else
				query.taskDefinitionKey(wfstepcode);
		}
		Long total=query.count();
		if(total==0)
			return wfStepCnt;
		if(!StringUtils.isEmpty(wfstepcode)) {
			List<Task> list=query.listPage(0,1);
			if(list.size()>0)
				wfStepCnt.put(list.get(0).getTaskDefinitionKey(),total);
			return wfStepCnt;
		}
		Long sumstep=0L;
		for(WFProcessNode node:this.getWFStep(system,appname,entity)){
			if((!StringUtils.isEmpty(processDefinitionKey))&&(!node.getProcessdefinitionkey().equals(processDefinitionKey)))
				continue;
			Long stepcnt=taskService.createTaskQuery().taskCandidateOrAssigned(userId).processDefinitionKey(node.getProcessdefinitionkey()).taskDefinitionKey(node.getUsertaskid()).count();
			if(stepcnt>0)
				wfStepCnt.put(node.getUsertaskid(),stepcnt);
			sumstep+=stepcnt;
			if(sumstep>=total)
				break;
		}
		return wfStepCnt;
	}

	public Page<WFTask> searchMyTask(WFTaskSearchContext context) {
		context.setSort("createtime,desc");
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages=wfCoreMapper.searchMyTask(context.getPages(),context,context.getSelectCond());
		return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
	}


	public List<WFTaskWay> getWFLinkByStep(String system,String appname,
									 String entity, String processDefinitionKey,String taskDefinitionKey) {
		List<WFTaskWay> taskWays=new ArrayList<>();

		if((!StringUtils.isEmpty(processDefinitionKey))&&(!StringUtils.isEmpty(taskDefinitionKey))) {
			UserTask userTask = wfModelService.getModelStepByKey(processDefinitionKey).get(taskDefinitionKey);
			if(userTask!=null&&userTask.getOutgoingFlows()!=null) {
				for(SequenceFlow sequenceFlow:userTask.getOutgoingFlows()) {
					WFTaskWay way=new WFTaskWay();
					way.setSequenceflowid(sequenceFlow.getId());
					way.setSequenceflowname(sequenceFlow.getName());
					way.setProcessdefinitionkey(processDefinitionKey);
					way.setTaskdefinitionkey(taskDefinitionKey);
					taskWays.add(way);
				}
			}
		}
		return taskWays;
	}

	public String getTaskUrl(String type,String processDefinitionKey,String processInstanceId,String businessKey,String taskDefinitionKey)
	{
		JSONObject app = ibzuaaFeignClient.getAppSwitcher("default",AuthenticationUser.getAuthenticationUser().getUserid());

		String[] arr = processDefinitionKey.split("-");
		String systemId = arr[0];
		String entity = arr[1];

		if(app!=null && app.containsKey("model"))
		{
			List<Map> array = app.getObject("model",ArrayList.class);
			int cnt=0;
			Map<String,String> serviceAddrs=new HashMap<>();
			String addr="";
			for(Map item:array) {
				if(item.get("systemId")!=null&&systemId.equalsIgnoreCase(item.get("systemId").toString())) {
					cnt++;
					if(!StringUtils.isEmpty(item.get("addr"))) {
						addr = item.get("addr").toString();
						if(!addr.endsWith("/"))
							addr+="/";
						if(!StringUtils.isEmpty(item.get("id")))
							serviceAddrs.put(item.get("id").toString(),addr);
					}
				}
			}
			if(cnt==1&&(!StringUtils.isEmpty(addr))) {
				addr+=String.format("#/appwfdataredirectview?srfappde=%1$s;srfappkey=%2$s;userTaskId=%3$s",entity,businessKey,taskDefinitionKey);
				return addr;
			}
			String serviceIds="";
			WFProcessDefinition definition = iwfProcessDefinitionService.get(processDefinitionKey);
			if((!StringUtils.isEmpty(type))&&type.toUpperCase().startsWith("mob"))
				serviceIds=definition.getMobileserviceids();
			else
				serviceIds=definition.getWebserviceids();
			if(!StringUtils.isEmpty(serviceIds)) {
				for(String serviceId:serviceIds.split(",")) {
					if(serviceAddrs.containsKey(serviceId)) {
						addr = serviceAddrs.get(serviceId);
						break;
					}
				}
				if(!StringUtils.isEmpty(addr)) {
					addr+=String.format("#/appwfdataredirectview?srfappde=%1$s;srfappkey=%2$s;userTaskId=%3$s",entity,businessKey,taskDefinitionKey);
					return addr;
				}
			}


		}
		return "";
	}

	public List<String> getBusinessKeys(String system,String appname, String entity,String processDefinitionKey,String taskDefinitionKey,String userId)
	{
		List<String> businessKeys = new ArrayList<>();
		String processInstanceBusinessKeyLike=system+":"+entity+":k-";
		if(StringUtils.isEmpty(userId))
			userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			return businessKeys;
		TaskQuery query=taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		if(!StringUtils.isEmpty(processDefinitionKey))
			query.processDefinitionKey(processDefinitionKey);
		else {
			query.processDefinitionKeyIn(this.getWorkflowKey(system,appname,entity));
		}
		if(!StringUtils.isEmpty(taskDefinitionKey))
			query.taskDefinitionKey(taskDefinitionKey);
		List<Task> tasks=query.listPage(0,500);
		for(Task task:tasks) {
			Object key=task.getCategory();
			if(key!=null) {
				String str=key.toString();
				if(str.indexOf(":k-")>0)
					str=str.split(":k-")[1];
				businessKeys.add(str);
			}
		}
		return businessKeys;
	}

	public WFProcessInstance wfStart(String system,String appname,
			String entity,String businessKey,WFProcessInstance instance) {
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("未传入当前用户",entity,businessKey);
		Integer version=1;
		String processDefinitionKey=instance.getProcessdefinitionkey();
		if(StringUtils.isEmpty(processDefinitionKey)){
			List<WFProcessDefinition> definitions=this.getWorkflow(system,appname,entity);
			if(definitions.size()==0)
				throw new BadRequestAlertException("未找到对应的工作流配置",entity,businessKey);
			processDefinitionKey=definitions.get(0).getDefinitionkey();
			version=definitions.get(0).getModelversion();
		}
		else {
			WFProcessDefinition definition =  iwfProcessDefinitionService.getById(processDefinitionKey);
			if(definition==null)
				throw new BadRequestAlertException("未找到对应的工作流配置",entity,businessKey);
			version=definition.getModelversion();
		}

		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;

		if(runtimeService.createProcessInstanceQuery().processDefinitionKey(processDefinitionKey).processInstanceBusinessKey(processInstanceBusinessKey).count()>0)
			throw new BadRequestAlertException("已经启动过流程，不能重复提交",entity,businessKey);
		Map<String, Object> variables = new LinkedHashMap<>();
		variables.put("businessKey",businessKey);
		variables.put("activedata",instance.get("activedata"));
		//variables.put("curuser",getCurUser());
		variables.put("cloud-serviceid",system+"-"+appname);
		variables.put("system",system);
		variables.put("appname",appname);
		variables.put("entitys",entity);
		variables.put("wfversion",version);
		//根据流程定义启动流程
		Authentication.setAuthenticatedUserId(userId);
        Authentication.setAuthenticationContext(createAuthenticationContext());
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey,processInstanceBusinessKey, variables);//流程定时标识、业务标识、变量
		instance.setBusinesskey(processInstanceBusinessKey);
		instance.setId(processInstance.getId());
		instance.setName(processInstance.getName());
		instance.setProcessdefinitionkey(processInstance.getProcessDefinitionKey());
		instance.setProcessdefinitionname(processInstance.getProcessDefinitionName());
		if(processInstance.getStartTime()!=null)
			instance.setStarttime(new Timestamp(processInstance.getStartTime().getTime()));
		instance.setStartuserid(processInstance.getStartUserId());
		return instance;
	}

	public List<WFTaskWay> getWFLink(String system,String appname,
			String entity, String businessKey,String taskDefinitionKey) {
		List<WFTaskWay> taskWays=new ArrayList<>();
		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			return taskWays;
		TaskQuery query=taskService.createTaskQuery().taskCandidateOrAssigned(userId).processInstanceBusinessKey(processInstanceBusinessKey);
		if(!StringUtils.isEmpty(taskDefinitionKey))
			query.taskDefinitionKey(taskDefinitionKey);
		List<Task> list=query.orderByTaskCreateTime().desc().listPage(0,1);
		if(list.size()==0)
			return taskWays;
		Task task=list.get(0);
		if((!StringUtils.isEmpty(task.getProcessDefinitionId()))&&(!StringUtils.isEmpty(task.getTaskDefinitionKey()))) {
			UserTask userTask = wfModelService.getModelStepById(task.getProcessDefinitionId()).get(task.getTaskDefinitionKey());
			if(userTask!=null&&userTask.getOutgoingFlows()!=null) {
				for(SequenceFlow sequenceFlow:userTask.getOutgoingFlows()) {
					WFTaskWay way=new WFTaskWay();
					way.setSequenceflowid(sequenceFlow.getId());
					way.setSequenceflowname(sequenceFlow.getName());
					if(task.getProcessDefinitionId().indexOf(":")>0)
						way.setProcessdefinitionkey(task.getProcessDefinitionId().split(":")[0]);
					way.setTaskid(task.getId());
					way.setProcessinstanceid(task.getProcessInstanceId());
					way.setTaskdefinitionkey(task.getTaskDefinitionKey());
					way.setProcessinstancebusinesskey(processInstanceBusinessKey);
					taskWays.add(way);
				}
			}
		}
		return taskWays;
	}

	public List<WFTaskWay> getTaskLink(String system,String appname, String entity, String businessKey,String taskId) {
		List<WFTaskWay> taskWays=new ArrayList<>();
		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			return taskWays;
		TaskQuery query=taskService.createTaskQuery().taskCandidateOrAssigned(userId).taskId(taskId);
		List<Task> list=query.orderByTaskCreateTime().desc().listPage(0,1);
		if(list.size()==0)
			return taskWays;
		Task task=list.get(0);
		if((!StringUtils.isEmpty(task.getProcessDefinitionId()))&&(!StringUtils.isEmpty(task.getTaskDefinitionKey()))) {
			UserTask userTask = wfModelService.getModelStepById(task.getProcessDefinitionId()).get(task.getTaskDefinitionKey());
			if(userTask!=null&&userTask.getOutgoingFlows()!=null) {
				for(SequenceFlow sequenceFlow:userTask.getOutgoingFlows()) {
					WFTaskWay way=new WFTaskWay();
					way.setSequenceflowid(sequenceFlow.getId());
					way.setSequenceflowname(sequenceFlow.getName());
					if(task.getProcessDefinitionId().indexOf(":")>0)
						way.setProcessdefinitionkey(task.getProcessDefinitionId().split(":")[0]);
					way.setTaskid(task.getId());
					way.setProcessinstanceid(task.getProcessInstanceId());
					way.setTaskdefinitionkey(task.getTaskDefinitionKey());
					way.setProcessinstancebusinesskey(processInstanceBusinessKey);
					taskWays.add(way);
				}
			}
		}
		return taskWays;
	}

	public WFProcessInstance wfsubmit(String system,String appname,
			String entity,String businessKey,String taskId,WFTaskWay taskWay) {

		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("未传入当前用户",entity,businessKey);
		if(StringUtils.isEmpty(taskId)){
			taskId=taskWay.getTaskid();
		}
		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;
		Map<String, Object> variables = new LinkedHashMap<>();
		variables.put("sequenceFlowId",taskWay.getSequenceflowid());
		variables.put("sequenceFlowName",taskWay.getSequenceflowname());
		variables.put("cloud-serviceid",system+"-"+appname);

		Map activedata=null;
		if(taskWay.get("activedata")!=null && taskWay.get("activedata") instanceof Map)
		{
			activedata=(Map)taskWay.get("activedata");
		}
		else
		{
			activedata=new LinkedHashMap();
		}
		Map<String, Object> transientVariables = new LinkedHashMap<>();
		transientVariables.put("activedata",activedata);
		//transientVariables.put("curuser",getCurUser());


		//根据流程定义启动流程
		Authentication.setAuthenticatedUserId(userId);
        Authentication.setAuthenticationContext(createAuthenticationContext());

		taskService.complete(taskId, variables,transientVariables);
		WFProcessInstance instance = new WFProcessInstance();
		instance.setBusinesskey(processInstanceBusinessKey);
		return instance;
	}

	public WFProcessInstance getWFHistory(String system,String appname,
										String entity,String businessKey,String processInstanceId)
	{
		WFProcessInstance wfProcessInstance=new WFProcessInstance();
		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;
		List<String> processInstanceIds=new ArrayList<>();
		if(StringUtils.isEmpty(processInstanceId))
		{
			List<HistoricProcessInstance> instances=historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(processInstanceBusinessKey).orderByProcessInstanceStartTime().asc().list();
			if(instances.size()==0)
				return wfProcessInstance;
			for(HistoricProcessInstance instance:instances)
			{
				processInstanceIds.add(instance.getId());
			}
		}
		else
			processInstanceIds.add(processInstanceId);

		Map<String,WFProcessNode> nodes=new LinkedHashMap<>();

		for(String id:processInstanceIds) {
			LinkedHashMap<String,UserTask> userTasks = wfModelService.getModelStepById(id);
			for(UserTask userTask:userTasks.values()) {
				if(!nodes.containsKey(userTask.getId())) {
					WFProcessNode node = new WFProcessNode();
					node.setUsertaskid(userTask.getId());
					node.setUsertaskname(userTask.getName());
					node.set("comments", new ArrayList<WFHistory>());
					node.set("identityLinks", new ArrayList<WFUser>());
					nodes.put(userTask.getId(), node);
				}
			}
		}


		List<Comment> comments = new ArrayList<>();
		Map<String,HistoricTaskInstanceEntity> tasks=new LinkedHashMap<>();
		Set<String> waitTaskId=new LinkedHashSet<>();

		Map<String,WFUser> wfUserMap = new HashMap<>();

		Timestamp endTime=null;
		for(String id:processInstanceIds) {
			ProcessInstanceHistoryLog processInstanceHistoryLog = historyService.createProcessInstanceHistoryLogQuery(id).includeTasks().includeActivities().includeComments().singleResult();
			if(!StringUtils.isEmpty(processInstanceHistoryLog.getStartUserId()))
			{
				WFUser user=new WFUser();
				user.setId(processInstanceHistoryLog.getStartUserId());
				wfUserMap.put(processInstanceHistoryLog.getStartUserId(),user);
			}
			if(StringUtils.isEmpty(wfProcessInstance.getId())) {
				wfProcessInstance.setId(processInstanceHistoryLog.getId());
				wfProcessInstance.setStarttime(new Timestamp(processInstanceHistoryLog.getStartTime().getTime()));
				wfProcessInstance.setBusinesskey(processInstanceHistoryLog.getBusinessKey());
				wfProcessInstance.setStartuserid(processInstanceHistoryLog.getStartUserId());
			}
			if(processInstanceHistoryLog.getEndTime()!=null)
			{
				if(endTime==null||processInstanceHistoryLog.getEndTime().getTime()>=endTime.getTime())
					endTime = (new Timestamp(processInstanceHistoryLog.getEndTime().getTime()));
			}
			List<HistoricData> historicData = processInstanceHistoryLog.getHistoricData();
			for (HistoricData data :historicData){
				if (data instanceof HistoricActivityInstance){
					HistoricActivityInstance hai= (HistoricActivityInstance) data;
					if(!hai.getActivityType().equals("userTask"))
						continue;
					if(!nodes.containsKey(hai.getActivityId()))
					{
						WFProcessNode node=new WFProcessNode();
						node.setUsertaskid(hai.getActivityId());
						node.setUsertaskname(hai.getActivityName());

						node.set("comments",new ArrayList<WFHistory>());
						node.set("identityLinks",new ArrayList<WFUser>());
						nodes.put(hai.getActivityId(),node);
					}
				}
				else if(data instanceof Comment)
				{
					Comment comment=(Comment)data;
					if(!StringUtils.isEmpty(comment.getUserId())){
						WFUser user=new WFUser();
						user.setId(comment.getUserId());
						wfUserMap.put(comment.getUserId(),user);
						comments.add(comment);
					}
				}
				else if(data instanceof HistoricTaskInstanceEntity)
				{
					HistoricTaskInstanceEntity historicTaskInstanceEntity= (HistoricTaskInstanceEntity) data;
					tasks.put(historicTaskInstanceEntity.getId(),historicTaskInstanceEntity);
					if(historicTaskInstanceEntity.getEndTime()==null)
						waitTaskId.add(historicTaskInstanceEntity.getId());
				}
			}
		}


		if(waitTaskId.size()>0){
			for(String taskid:waitTaskId) {
				List<IdentityLink> idlinks = taskService.getIdentityLinksForTask(taskid);
				for(IdentityLink idlink:idlinks)
				{
					WFUser user=new WFUser();
					user.setId(idlink.getUserId());
					wfUserMap.put(idlink.getUserId(),user);
					((ArrayList)nodes.get(tasks.get(taskid).getTaskDefinitionKey()).get("identityLinks")).add(user);
				}
			}
		}
		else
			wfProcessInstance.setEndtime(endTime);

		if(wfUserMap.size()>0)
			iwfUserService.listByIds(wfUserMap.keySet()).forEach(item ->wfUserMap.get(item.getId()).setDisplayname(item.getDisplayname()));

		for(Comment comment:comments)
		{
			if(tasks.containsKey(comment.getTaskId())&&(nodes.containsKey(tasks.get(comment.getTaskId()).getTaskDefinitionKey()))) {
				if(wfUserMap.containsKey(comment.getUserId())) {
					WFHistory history = new WFHistory();
					history.setId(comment.getId());
					history.setAuthor(comment.getUserId());
					history.setAuthorname(wfUserMap.get(comment.getUserId()).getDisplayname());
					history.setFullmessage(comment.getFullMessage());
					history.setTime(new Timestamp(comment.getTime().getTime()));
					history.setType(comment.getType());
					//history.setTaskid(comment.getTaskId());
					//history.setProcessinstanceid(comment.getProcessInstanceId());
					//history.setProcessinstancebusinesskey(businessKey);
					((ArrayList) nodes.get(tasks.get(comment.getTaskId()).getTaskDefinitionKey()).get("comments")).add(history);
				}
			}
		}
		wfProcessInstance.set("userTasks",nodes.values());

		if(!StringUtils.isEmpty(wfProcessInstance.getStartuserid()))
		{
			wfProcessInstance.setStartusername(wfUserMap.get(wfProcessInstance.getStartuserid()).getDisplayname());
		}
		wfProcessInstance.setBusinesskey(businessKey);

		return wfProcessInstance;

	}


	@Value("${ibiz.filePath:/app/file/}")
	private String fileRoot;

	protected BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
	protected BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();

	public synchronized boolean wfdeploybpmns(List bpmnfiles){
		if(bpmnfiles.size()>0){
			bpmnfiles.forEach(item->{
					Map<String,Object> bpmnfile= (Map) item;
					for (Map.Entry<String,Object> entry : bpmnfile.entrySet()) {
						InputStream in = null;
						try {
							in = new ByteArrayInputStream(String.valueOf(entry.getValue()).getBytes());
							wfdeploy(entry.getKey(), getBpmnFile(in),new WFREModel());
						} catch (Exception e) {}
						finally {
							if(in!=null) {
								try {
									in.close();
								} catch (IOException e) {}
							}
						}
					}
				}
			);
		}
		return true;
	}

	public synchronized boolean wfdeploy(File bpmnFile,WFREModel wfreModel)  {
		InputStream in =null;
		try {
			in=new FileInputStream(bpmnFile);
			return wfdeploy(bpmnFile.getName(),getBpmnFile(in),wfreModel);
		} catch (IOException e) {}
		finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
		}
		return false;
	}

	public synchronized boolean wfdeploy(String bpmnFileName , ByteArrayOutputStream bpmnFile , WFREModel wfreModel)
	{
		String deployInfo="";
		if(bpmnFile==null){
			log.error(String.format("解析失败，无法获取流程文件[%s]",bpmnFileName));
			deployInfo+=String.format("解析失败，无法获取流程文件[%s] \r\n",bpmnFileName);
			wfreModel.setName(deployInfo);
			return false;
		}
		if(!StringUtils.isEmpty(wfreModel.getName()))
			deployInfo=wfreModel.getName();
		XMLStreamReader reader = null;
		InputStream inputStream = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			inputStream=new ByteArrayInputStream(bpmnFile.toByteArray());
			reader = factory.createXMLStreamReader(inputStream);
			BpmnModel model = bpmnXMLConverter.convertToBpmnModel(reader);
			List<Process> processes = model.getProcesses();
			Process curProcess = null;
			if (CollectionUtils.isEmpty(processes)) {
				deployInfo+=bpmnFileName+"解析失败，没有找到流程配置信息"+"\r\n";
				wfreModel.setName(deployInfo);
				return false;
			}
			curProcess = model.getMainProcess();
			String bookings="";
			String refgroups="";
			if(!curProcess.getExtensionElements().containsKey("field"))
			{
				log.error(bpmnFileName+"没有实体订阅");
				deployInfo+=bpmnFileName+"解析失败，没有实体订阅配置"+"\r\n";
				wfreModel.setName(deployInfo);
				return false;
			}
			Map<String,String> bookingapps = new HashMap<String,String>();
			Map<String,String> bookingmobs = new HashMap<String,String>();
			for(ExtensionElement field:curProcess.getExtensionElements().get("field"))
			{
				if("bookings".equals(field.getAttributes().get("name").get(0).getValue()))
					bookings=field.getChildElements().get("string").get(0).getElementText();
				if("refgroups".equals(field.getAttributes().get("name").get(0).getValue()))
					refgroups=field.getChildElements().get("string").get(0).getElementText();

				if(field.getAttributes().get("name").get(0).getValue().startsWith("bookingapps_"))
				{
					String bookingapp=field.getChildElements().get("string").get(0).getElementText();
					if(!StringUtils.isEmpty(bookingapp))
					{
						String[] arr=field.getAttributes().get("name").get(0).getValue().split("_");
						if(arr.length>1)
							bookingapps.put(arr[1],bookingapp);
					}
				}

				if(field.getAttributes().get("name").get(0).getValue().startsWith("bookingmobs_"))
				{
					String bookingmob=field.getChildElements().get("string").get(0).getElementText();
					if(!StringUtils.isEmpty(bookingmob))
					{
						String[] arr=field.getAttributes().get("name").get(0).getValue().split("_");
						if(arr.length>1)
							bookingmobs.put(arr[1],bookingmob);
					}
				}
			}
			if(StringUtils.isEmpty(bookings))
			{
				log.error(bpmnFileName+"没有实体订阅");
				deployInfo+=bpmnFileName+"解析失败，没有实体订阅配置"+"\r\n";
				wfreModel.setName(deployInfo);
				return false;
			}
			if(!StringUtils.isEmpty(refgroups))
			{
				List<WFGroup> listGroup=new ArrayList<>();
				for(String refgroup:refgroups.split(","))
				{
					String[] groupParam=refgroup.split("[\\|]");
					if(groupParam.length==3)
					{
						WFGroup wfGroup=new WFGroup();
						wfGroup.setId(groupParam[0]);
						wfGroup.setName(groupParam[1]);
						wfGroup.setGroupscope(groupParam[2]);
						listGroup.add(wfGroup);
					}
				}
				if(listGroup.size()>0)
					iwfGroupService.saveBatch(listGroup);
			}



			String[] params=curProcess.getId().split("-");
			if(params.length!=2)
			{
				log.error(bpmnFileName+"没有系统名称");
				deployInfo+=bpmnFileName+"解析失败，没有发布系统配置"+"\r\n";
				wfreModel.setName(deployInfo);
				return false;
			}
			String system=params[0];
			Integer version= Integer.parseInt(params[1].substring(params[1].lastIndexOf("v")+1));

			ModelKeyRepresentation appKeyInfo = modelService.validateModelKey(null,AbstractModel.MODEL_TYPE_APP,system);
			if(!appKeyInfo.isKeyAlreadyExists())
			{
				ModelRepresentation modelRepresentation=new ModelRepresentation();
				modelRepresentation.setKey(system);
				modelRepresentation.setName(system);
				modelRepresentation.setModelType(AbstractModel.MODEL_TYPE_APP);
				String json = modelService.createModelJson(modelRepresentation);
				appKeyInfo.setId(modelService.createModel(modelRepresentation, json, SecurityUtils.getCurrentUserObject()).getId());
			}

			AppDefinitionRepresentation appModel=appDefinitionService.getAppDefinition(appKeyInfo.getId());


			inputStream=new ByteArrayInputStream(bpmnFile.toByteArray());
			boolean bchange=false;
			for(String booking:bookings.split(","))
			{
				String processDefinitionKey=system+"-"+booking+"-"+params[1];
				WFProcessDefinition old=iwfProcessDefinitionService.get(processDefinitionKey);
				WFProcessDefinition wfProcessDefinition=new WFProcessDefinition();
				wfProcessDefinition.setDefinitionkey(processDefinitionKey);
				wfProcessDefinition.setDeploykey(processDefinitionKey);
				wfProcessDefinition.setPssystemid(system);
				wfProcessDefinition.setModelenable(1);
				wfProcessDefinition.setModelversion(version);
				wfProcessDefinition.setDefinitionname(curProcess.getName());
				if(bookingapps.containsKey(booking))
				{
					String[] arr = bookingapps.get(booking).split(",");
					String serviceIds = "";
					for(String str:arr)
					{
						if(StringUtils.isEmpty(str))
							continue;
						if(!StringUtils.isEmpty(serviceIds))
							serviceIds+=",";
						serviceIds=serviceIds+system+"-"+str;
					}
					wfProcessDefinition.setWebserviceids(serviceIds);
				}
				if(bookingmobs.containsKey(booking))
				{
					String[] arr = bookingmobs.get(booking).split(",");
					String serviceIds = "";
					for(String str:arr)
					{
						if(StringUtils.isEmpty(str))
							continue;
						if(!StringUtils.isEmpty(serviceIds))
							serviceIds+=",";
						serviceIds=serviceIds+system+"-"+str;
					}
					wfProcessDefinition.setMobileserviceids(serviceIds);
				}

				OutputStream out =null;
				InputStream is = null;
				XMLStreamReader reader2 = null;
				InputStream inputStream2 = null;
				String bmpmfileId="";
				String fileFullPath ="";
				BpmnModel entitymodel=null;
				try {
					inputStream2=new ByteArrayInputStream(bpmnFile.toByteArray());
					reader2 = factory.createXMLStreamReader(inputStream2);
					entitymodel=bpmnXMLConverter.convertToBpmnModel(reader2);
					entitymodel.getMainProcess().setId(processDefinitionKey);
					BpmnAutoLayout bpmnLayout = new BpmnAutoLayout(entitymodel);
					bpmnLayout.execute();
					byte[] bs= bpmnXMLConverter.convertToXML(entitymodel);
					bmpmfileId=DigestUtils.md5DigestAsHex(bs);
					if(bmpmfileId.equals(old.getMd5check()))
					{
						log.warn("部署流程没有变化，忽略 name:" + curProcess.getName() + " key " + processDefinitionKey + " deploy " + bmpmfileId);
						deployInfo+=curProcess.getName()+" key:" + processDefinitionKey +"，流程配置没有变化，忽略发布"+"\r\n";
						wfreModel.setName(deployInfo);
						continue;
					}
					fileFullPath = this.fileRoot+"ibizutil"+File.separator+bmpmfileId+File.separator+processDefinitionKey+".bpmn20.xml";
					is = new ByteArrayInputStream(bs);
					File file = new File(fileFullPath);
					File parent = new File(file.getParent());
					if(!parent.exists())
						parent.mkdirs();
					out= new FileOutputStream(fileFullPath);
					byte[] buff = new byte[1024];
					int len = 0;
					while((len=is.read(buff))!=-1){
						out.write(buff, 0, len);
					}
				}
				catch(Exception ex){}
				finally {
					try {
						if(reader2!=null)
							reader2.close();
					} catch (Exception e) {
					}
					try
					{
						if(is!=null)
						is.close();
					}catch (Exception exis){}
					try
					{
						if(out!=null)
							out.close();
					}catch (Exception exis){}
				}


				ObjectNode modelNode = bpmnJsonConverter.convertToJson(entitymodel);
				ModelRepresentation demodel = new ModelRepresentation();
				demodel.setKey(processDefinitionKey);
				demodel.setName(curProcess.getName());
				demodel.setDescription(curProcess.getDocumentation());
				demodel.setModelType(AbstractModel.MODEL_TYPE_BPMN);
				ModelKeyRepresentation modelKeyInfo = modelService.validateModelKey(null,AbstractModel.MODEL_TYPE_BPMN,processDefinitionKey);
				Model newModel=null;
				if(!modelKeyInfo.isKeyAlreadyExists())
					newModel = modelService.createModel(demodel, modelNode.toString(), SecurityUtils.getCurrentUserObject());
				else
					newModel = modelService.saveModel(modelKeyInfo.getId(),curProcess.getName(),processDefinitionKey,curProcess.getDocumentation(),
							modelNode.toString(),true,"",SecurityUtils.getCurrentUserObject());

				boolean replace=false;
				if(appModel.getDefinition()!=null&&appModel.getDefinition().getModels()!=null)
				{
					for(AppModelDefinition appdef :appModel.getDefinition().getModels())
					{
						if(appdef.getId().equals(newModel.getId()))
						{
							appdef.setName(newModel.getName());
							appdef.setVersion(newModel.getVersion());
							appdef.setLastUpdated(newModel.getLastUpdated());
							appdef.setLastUpdatedBy(newModel.getLastUpdatedBy());
							appdef.setDescription(newModel.getDescription());
							replace=true;
							bchange=true;
						}
					}
				}
				if(!replace)
				{
					AppModelDefinition appdef = new AppModelDefinition();
					appdef.setId(newModel.getId());
					appdef.setName(newModel.getName());
					appdef.setVersion(newModel.getVersion());
					appdef.setCreatedBy(newModel.getCreatedBy());
					appdef.setModelType(newModel.getModelType());
					appdef.setLastUpdated(newModel.getLastUpdated());
					appdef.setLastUpdatedBy(newModel.getLastUpdatedBy());
					appdef.setDescription(newModel.getDescription());
					if(appModel.getDefinition()!=null&&appModel.getDefinition().getModels()==null)
						appModel.getDefinition().setModels(new ArrayList<>());
					appModel.getDefinition().getModels().add(appdef);
					bchange=true;
				}


				inputStream=new FileInputStream(new File(fileFullPath));
				DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name(curProcess.getName()).key(processDefinitionKey)
						.addInputStream(fileFullPath,inputStream);
				Deployment deployment= deploymentBuilder.deploy();

				wfProcessDefinition.setBpmnfile("[{\"id\":\""+bmpmfileId+"\",\"name\":\""+processDefinitionKey+".bpmn20.xml\"}]");
				wfProcessDefinition.setMd5check(bmpmfileId);
				iwfProcessDefinitionService.save(wfProcessDefinition);

				log.warn("部署流程 name:"+curProcess.getName()+" key "+deployment.getKey() + " deploy "+deployment);
				deployInfo+=curProcess.getName()+" key:" + processDefinitionKey +"，部署成功"+"\r\n";
				wfreModel.setName(deployInfo);
			}
			if(bchange)
			{
				AppDefinitionSaveRepresentation savemodel=new AppDefinitionSaveRepresentation();
				savemodel.setPublish(false);
				savemodel.setAppDefinition(appModel);
				appDefinitionService.updateAppDefinition(appModel.getId(), savemodel);
			}
			return true;
		}
		catch (Exception e){
			log.error(bpmnFileName+"BPMN模型创建流程异常",e);
			deployInfo+=bpmnFileName+"BPMN模型创建流程异常"+"\r\n";
			wfreModel.setName(deployInfo);
			return false;
		}
		finally {
			try {
				reader.close();
			} catch (Exception e) {
			}
		}

	}

	@Autowired
	private RemoteService remoteService;


	public void execute(DelegateExecution delegateExecution,Object activedata) throws Exception {
		if(delegateExecution.getCurrentFlowElement() instanceof ServiceTask && activedata instanceof Map)
		{
			ServiceTask task=(ServiceTask)delegateExecution.getCurrentFlowElement();
			//HashMap curUser=(HashMap)delegateExecution.getVariable("curuser");
            FlowUser curUser=FlowUser.getCurUser();
			String businessKey=(String)delegateExecution.getVariable("businessKey");
			String cloudServiceId=(String)delegateExecution.getVariable("cloud-serviceid");
			Map entity=(Map) activedata;
			String serviceEntity="";
			String serviceDEAction="";

			for(FieldExtension fieldExtension : task.getFieldExtensions())
			{
				if("service-entity".equals(fieldExtension.getFieldName()))
				{
					serviceEntity=fieldExtension.getStringValue();
				}
				else if("service-deaction".equals(fieldExtension.getFieldName()))
				{
					serviceDEAction=fieldExtension.getStringValue();
				}
				else if(fieldExtension.getFieldName().startsWith("params-"))
				{
					String key=fieldExtension.getFieldName().split("-")[1];
					entity.put(key,fieldExtension.getStringValue());
				}
			}
			if(StringUtils.isEmpty(serviceEntity)||StringUtils.isEmpty(serviceDEAction))
				return;
			if(StringUtils.isEmpty(curUser.getToken()))
				return;
			String token=curUser.getToken();
			String path=serviceEntity;
			if(serviceDEAction.equalsIgnoreCase("create"))
				remoteService.getClient(cloudServiceId).post(path,token,entity);
			else if(serviceDEAction.equalsIgnoreCase("update"))
				remoteService.getClient(cloudServiceId).put(path+"/"+businessKey,token,entity);
			else if(serviceDEAction.equalsIgnoreCase("remove"))
				remoteService.getClient(cloudServiceId).delete(path+"/"+businessKey,token);
			else if(serviceDEAction.equalsIgnoreCase("save"))
				remoteService.getClient(cloudServiceId).post(path+"/save",token,entity);
			else if(serviceDEAction.equalsIgnoreCase("get"))
				remoteService.getClient(cloudServiceId).get(path+"/"+businessKey,token);
			else if(serviceDEAction.equalsIgnoreCase("getdraft")){}
			else if(serviceDEAction.equalsIgnoreCase("checkkey")){}
			else
				remoteService.getClient(cloudServiceId).post(path+"/"+businessKey+"/"+serviceDEAction,token,entity);
		}
	}

	public Timestamp getnow()
	{
		return new Timestamp(new java.util.Date().getTime());
	}

	public boolean test(Object finalObject,String option,Object exp)
	{
		return RuleUtils.test(finalObject,option,exp);
	}

	public String getGroupUsers(String groupIds, DelegateExecution delegateExecution)
	{
		String strUsers="";
		if(StringUtils.isEmpty(groupIds))
			return "";
		String[] groups=groupIds.split(",");
		for(String groupId:groups)
		{
			String userData="";
			String userData2="";
			String orgid="";
			String deptid="";
			if(groupId.indexOf("|")>0)
			{
				String[] arg=groupId.split("[|]");
				if(arg.length==3)
				{
					groupId=arg[0];
					if(arg[1]!=null)
						userData=arg[1].toLowerCase();
					if(arg[2]!=null)
						userData2=arg[2].toLowerCase();
				}
			}

			if((!StringUtils.isEmpty(userData))&&(!StringUtils.isEmpty(userData2)))
			{
				if(userData2.indexOf("srf")==0)
				{
					FlowUser curUser=FlowUser.getCurUser();
					if(curUser!=null&&curUser.getUser()!=null)
					{
						Object sessionValue=curUser.getUser().getSessionParams().get(userData2);
						if(sessionValue!=null)
							userData2=sessionValue.toString();
						else
							userData2="";
					}
					else
						userData2="";
				}
				else
				{
					Object activedata=delegateExecution.getVariable("activedata");
					if(activedata!=null&&activedata instanceof Map) {
						Map entity = (Map) activedata;
						if(entity.get(userData2)!=null)
							userData2=entity.get(userData2).toString();
						else
							userData2="";
					}
					else
						userData2="";
				}
				if(!StringUtils.isEmpty(userData2))
				{
					if(userData.indexOf("dept")>=0||userData.indexOf("orgsec")>=0)
						deptid=userData2;
					else if(userData.indexOf("org")>=0)
						orgid=userData2;
				}
			}




			WFGroup group=iwfGroupService.get(groupId);
			List<WFMember> list=group.getWfmember();
			if (list!=null)
			{
				for(WFMember member : list)
				{
					if((!StringUtils.isEmpty(deptid))&&(!deptid.equals(member.getMdeptid())))
						continue;
					if((!StringUtils.isEmpty(orgid))&&(!orgid.equals(member.getOrgid())))
						continue;

					if(!StringUtils.isEmpty(strUsers))
						strUsers+=",";
					strUsers+=member.getUserid();
				}
			}
		}

		return strUsers;
	}

	private  ByteArrayOutputStream getBpmnFile(InputStream input) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = input.read(buffer)) > -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			return baos;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
