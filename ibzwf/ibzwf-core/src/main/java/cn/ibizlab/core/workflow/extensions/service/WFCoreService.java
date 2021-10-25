package cn.ibizlab.core.workflow.extensions.service;

import cn.ibizlab.core.workflow.domain.*;
import cn.ibizlab.core.workflow.extensions.domain.FlowUser;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.core.workflow.mapper.WFCoreMapper;
import cn.ibizlab.core.workflow.service.IWFGroupService;
import cn.ibizlab.core.workflow.service.IWFProcessDefinitionService;
import cn.ibizlab.core.workflow.service.IWFUserService;
import cn.ibizlab.util.client.IBZRTProxyFeignClient;
import cn.ibizlab.util.client.IBZUAAFeignClient;
import cn.ibizlab.util.enums.ProcFunction;
import cn.ibizlab.util.enums.TaskType;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.RuleUtils;
import cn.ibizlab.util.security.AuthTokenUtil;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.RemoteService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.BpmnAutoLayout;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.*;
import org.flowable.common.engine.api.history.HistoricData;
import org.flowable.common.engine.api.identity.AuthenticationContext;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.common.engine.impl.identity.UserIdAuthenticationContext;
import org.flowable.editor.language.json.converter.BpmnJsonConverter;
import org.flowable.engine.*;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.history.ProcessInstanceHistoryLog;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Comment;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.api.DelegationState;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.service.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
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
import org.springframework.context.expression.MapAccessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
	protected ManagementService managementService;

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

	@Autowired
	private IBZRTProxyFeignClient rtProxy;

	private Map<String,List<Map<String,Object>>> taskMap = new ConcurrentHashMap<>();

	private final ExpressionParser parser = new SpelExpressionParser();

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

	public List<WFProcessDefinition> getDynamicWorkflow(String dynamic, String system,String appname,String entity) {
		return wfModelService.getDynamicWorkflow(dynamic,system,entity);
	}


	public List<WFProcessDefinition> getDynamicWorkflow(String system,String appname,String entity) {
		String dynaModelId = getDynaModelId(null,null);
		return StringUtils.isEmpty(dynaModelId)? new ArrayList<>() : wfModelService.getDynamicWorkflow(dynaModelId,system,entity);
	}


	private String getDynaModelId(String instTag , String instTag2){
		String orgId = null;
		String systemId = null;
		if(RequestContextHolder.getRequestAttributes()==null && !(RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes)){
			return null;
		}
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(requestAttributes!=null) {
			HttpServletRequest request = requestAttributes.getRequest();
			if(request!=null && !StringUtils.isEmpty(request.getHeader("srforgid"))){
				orgId= request.getHeader("srforgid");
			}
			if(request!=null && !StringUtils.isEmpty(request.getHeader("srfsystemid"))){
				systemId= request.getHeader("srfsystemid");
			}
		}
		if(StringUtils.isEmpty(orgId) || StringUtils.isEmpty(systemId)){
			throw new BadRequestAlertException("无法获取当前用户组织及系统信息","","");
		}
		String dynaModelId = null;
		if(StringUtils.isEmpty(instTag) && StringUtils.isEmpty(instTag2)){
			dynaModelId = rtProxy.getDynaModelId(orgId, systemId);
		}
		else{
			dynaModelId = rtProxy.getDynaModelId(instTag, instTag2, orgId, systemId);
		}
		if(StringUtils.isEmpty(dynaModelId)){
			throw new BadRequestAlertException("获取动态模型标识失败","","");
		}
		return dynaModelId;
	}


	public List<WFProcessDefinition> getDynamicWorkflow(String instTag,String instTag2, String system,String appname,String entity) {
		String dynaModelId = getDynaModelId(instTag, instTag2);
		return StringUtils.isEmpty(dynaModelId)? new ArrayList<>() : wfModelService.getDynamicWorkflow(dynaModelId,system,entity);
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

	public List<String> getDynaWorkflowKey(String dynainstid,String system,String appname,String entity) {
		List<String> definitionKeys=new ArrayList<>();
		for(WFProcessDefinition wfdef:wfModelService.getDynamicWorkflow(dynainstid,system,entity))
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

	/**
	 * 获取所有用户分页存储催办消息
	 * @return
	 */
	@Scheduled(fixedRate = 300000)
	public synchronized void getBacklogPageContent() {
		taskMap.clear();
		List<Map> taskList = wfCoreMapper.searchMyTaskByPage();
		for (Map map : taskList) {
			//根据用户id分类
			String templateCode = (String) map.get("UserId");
			if (StringUtils.isEmpty(templateCode)){
				continue;
			}
			if(!taskMap.containsKey(templateCode)){
				List<Map<String,Object>> listMap = new ArrayList<>();
				listMap.add(map);
				taskMap.put(templateCode, listMap);
			} else {
				List<Map<String,Object>> listMap = taskMap.get(templateCode);
				listMap.add(map);
				taskMap.put(templateCode, listMap);
			}
		}
	}

	/**
	 * 缓存某个用户分页催办消息
	 * @return
	 */
	public Page<WFTask> getTaskByPage(WFTaskSearchContext context) {
		if (ObjectUtils.isEmpty(context)) {
			throw new BadRequestAlertException("无效消息上下文", "WFCoreService", "getTaskByPage");
		}
		String toUserId = context.getSessioncontext().get("srfuserid") == null ? "" : context.getSessioncontext().get("srfuserid").toString();
		if(StringUtils.isEmpty(toUserId)){
			throw new BadRequestAlertException("无法获取当前用户", "WFCoreService", "getTaskByPage");
		}
		if (!taskMap.containsKey(toUserId)) {
			return Page.empty();
		} else {

			com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>();
			int current = context.getPages().getCurrent() < 0 ? 0 : (int) context.getPages().getCurrent();
			int size = context.getPages().getCurrent() < 0 ? 0 : (int) context.getPages().getSize();
			List<WFTask> pageList = new ArrayList<>();

			// 用户ID传入，获取任务组
			List<Map<String,Object>> msgBodyList = taskMap.get(toUserId);
			List<WFTask> wfTaskList = new ArrayList<>();
			for (Map<String,Object> map : msgBodyList) {
				WFTask task = JSONObject.parseObject(JSONObject.toJSONString(map), WFTask.class);
				wfTaskList.add(task);
			}

			//计算当前页第一条数据的下标
			int currId = context.getPages().getCurrent() > 1 ? (current - 1) * size : 0;
			for (int i = 0; i < size && i < msgBodyList.size() - currId; i++) {
				pageList.add(wfTaskList.get(currId + i));
			}
			pages.setSize(size);
			pages.setCurrent(current);
			pages.setTotal(taskMap.get(toUserId).size());
			pages.setRecords(pageList);


			return new PageImpl<>(pages.getRecords(), context.getPageable(), pages.getTotal());
		}
	}

	public List<WFTaskWay> getWFLinkByStep(String system,String appname,
										   String entity, String processDefinitionKey,String taskDefinitionKey) {
		List<WFTaskWay> taskWays=new ArrayList<>();
		if((!StringUtils.isEmpty(processDefinitionKey))&&(!StringUtils.isEmpty(taskDefinitionKey))) {
			UserTask userTask = wfModelService.getModelStepByKey(processDefinitionKey).get(taskDefinitionKey);
			//设置流程表单
			setProcessForm(userTask);
			if(userTask!=null&&userTask.getOutgoingFlows()!=null) {
				for(SequenceFlow sequenceFlow:userTask.getOutgoingFlows()) {
					WFTaskWay way=new WFTaskWay();
					way.setSequenceflowid(sequenceFlow.getId());
					way.setSequenceflowname(sequenceFlow.getName());
					way.setProcessdefinitionkey(processDefinitionKey);
					way.setTaskdefinitionkey(taskDefinitionKey);
					//设置流程交互表单
					setTaskWayForm(sequenceFlow,way);
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

	public Map<String, Map<String,Object>> getDynaBusinessKeys(String system, String appname, String entity,  String instTag , String instTag2, String userId , TaskType type) {
		Map<String, Map<String,Object>> businessKeys = new HashMap<>();
		Page<WFTask> tasks;
		if(StringUtils.isEmpty(userId))
			userId=AuthenticationUser.getAuthenticationUser().getUserid();

		String dynaModelId = getDynaModelId(instTag,instTag2);
		if(StringUtils.isEmpty(userId) && StringUtils.isEmpty(dynaModelId))
			return businessKeys;

		WFTaskSearchContext context =new WFTaskSearchContext();
		List<String> keys = this.getDynaWorkflowKey(dynaModelId,system,appname,entity);
		if(ObjectUtils.isEmpty(keys)){
			return businessKeys;
		}
		context.setSize(Integer.MAX_VALUE);
		context.getSearchCond().in("DefinitionKey",keys);
		if(TaskType.READ == type)
			tasks = searchMyUnreadTask(context);
		else if(TaskType.DONE == type)
			tasks = searchMyDoneTask(context);
		else if(TaskType.FINISH == type)
			tasks = searchMyFinishTask(context);
		else if(TaskType.ALL==type)
			tasks = searchMyAllTask(context);
		else
			tasks = searchMyTask(context);
		if(!ObjectUtils.isEmpty(tasks)){
			for(WFTask task:tasks.getContent()) {
				Object key=task.getProcessinstancebusinesskey();
				if(key!=null) {
					String str=key.toString();
					if(str.indexOf(":k-")>0)
						str=str.split(":k-")[1];
					Map<String,Object> params = new HashMap();
					params.put("srfprocessdefinitionkey",task.getProcessdefinitionkey());
					params.put("srftaskdefinitionkey",task.getTaskdefinitionkey());
					params.put("srftaskid",task.getId());
					businessKeys.put(str,params);
				}
			}
		}
		return businessKeys;
	}

	private Page<WFTask> searchMyAllTask(WFTaskSearchContext context) {
		context.setSort("createtime,desc");
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages = wfCoreMapper.searchMyAllTask(context.getPages(),context,context.getSearchCond());
		return new PageImpl<WFTask>(pages.getRecords(),context.getPageable(),pages.getTotal());
	}

	private Page<WFTask> searchMyUnreadTask(WFTaskSearchContext context) {
		context.setSort("createtime,desc");
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages=wfCoreMapper.searchUnReadTask(context.getPages(),context,context.getSelectCond());
		return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
	}

	private Page<WFTask> searchMyDoneTask(WFTaskSearchContext context) {
		context.setSort("createtime,desc");
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages=wfCoreMapper.searchMyDoneTask(context.getPages(),context,context.getSelectCond());
		return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
	}

	private Page<WFTask> searchMyFinishTask(WFTaskSearchContext context) {
		context.setSort("createtime,desc");
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages=wfCoreMapper.searchMyFinishTask(context.getPages(),context,context.getSelectCond());
		return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
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
			//设置流程表单
			setProcessForm(userTask);
			if(userTask!=null&&userTask.getOutgoingFlows()!=null) {
				//加签逻辑
				String procFuncs = getParam(userTask,"form","procfunc");
				if(DelegationState.PENDING == task.getDelegationState() && userId.equals(task.getAssignee())
						&& !StringUtils.isEmpty(procFuncs) && procFuncs.contains(ProcFunction.ADDSTEPBEFORE.value)){
					WFTaskWay way = getFuncWay(task,ProcFunction.FINISH.value);
					if(way!=null)
						taskWays.add(way);
					return taskWays;
				}
				//流程辅助功能
				List<WFTaskWay> functions = getProcessFunc(task,userTask);
				if (functions.size() > 0) {
					taskWays.addAll(functions);
				}
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
					//设置流程交互表单
					setTaskWayForm(sequenceFlow,way);
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
			//设置流程表单
			setProcessForm(userTask);
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
					//设置流程交互表单
					setTaskWayForm(sequenceFlow,way);
					taskWays.add(way);
				}
			}
		}
		return taskWays;
	}

	/**
	 * 流程辅助功能
	 * @param userTask
	 * @return
	 */
	private List<WFTaskWay> getProcessFunc(Task task , UserTask userTask) {
		List<WFTaskWay> taskWays = new ArrayList<>();
		String procFuncs = getParam(userTask,"form","procfunc");
		if(!StringUtils.isEmpty(procFuncs)){
			for(String func : procFuncs.split(";")){
				WFTaskWay taskWay = getFuncWay(task,func);
				if(taskWay!=null)
					taskWays.add(taskWay);
			}
		}
		return taskWays;
	}

	/**
	 * 流程辅助功能连接（通过type区分预定义行为与标准行为）
	 * @param funcType
	 * @return
	 */
	public WFTaskWay getFuncWay(Task task , String funcType){
		WFTaskWay way = null;
		try {
			if(!StringUtils.isEmpty(funcType)){
				ProcFunction function = ProcFunction.valueOf(funcType.toUpperCase());
				if(function!=null){
					if(function == ProcFunction.ADDSTEPAFTER){
						function = ProcFunction.TRANSFER;
					}
					way = new WFTaskWay();
					way.set("type",function.value);
					way.setSequenceflowname(function.text);
					way.setTaskid(task.getId());
					way.setTaskdefinitionkey(task.getTaskDefinitionKey());
				}
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
		return way;
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

		WFProcessInstance instance = new WFProcessInstance();
		Task curTask = taskService.createTaskQuery().taskId(taskId).singleResult();

		//加签任务处理
		if (curTask != null && DelegationState.PENDING == curTask.getDelegationState()) {
			if(userId.equals(curTask.getAssignee())){
				taskService.resolveTask(taskId);
				//saveTask(curTask);
			}
			else{
				throw new BadRequestAlertException("当前任务正在加签中","","");
			}
		}
		else{
			//常规任务处理
			taskService.complete(taskId, variables, transientVariables);
			instance.setBusinesskey(processInstanceBusinessKey);
		}
		return instance;
	}

	public WFProcessInstance getWFHistory(String system,String appname,
										  String entity,String businessKey,String processInstanceId)
	{
		WFProcessInstance wfProcessInstance=new WFProcessInstance();
		String processInstanceBusinessKey=system+":"+entity+":k-"+businessKey;
		Set<String> processInstanceIds=new HashSet<>();
		Set<String> processDefinitionIds=new HashSet<>();
		if(StringUtils.isEmpty(processInstanceId))
		{
			List<HistoricProcessInstance> instances=historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(processInstanceBusinessKey).orderByProcessInstanceStartTime().asc().list();
			if(instances.size()==0)
				return wfProcessInstance;
			for(HistoricProcessInstance instance:instances)
			{
				processInstanceIds.add(instance.getId());
				processDefinitionIds.add(instance.getProcessDefinitionId());
			}
		}
		else {
			runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).list().forEach(item ->{
				processDefinitionIds.add(item.getProcessDefinitionId());
			});
			processInstanceIds.add(processInstanceId);
		}

		Map<String,WFProcessNode> nodes=new LinkedHashMap<>();

		for(String id:processDefinitionIds) {
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
		if(!StringUtils.isEmpty(processInstanceId)){
			wfProcessInstance.set("userTasks",filterTaskMap(nodes,processInstanceId));
		}else {
			for (String id : processInstanceIds) {
				wfProcessInstance.set("userTasks",filterTaskMap(nodes,id));
			}
		}
		if(!StringUtils.isEmpty(wfProcessInstance.getStartuserid()))
		{
			wfProcessInstance.setStartusername(wfUserMap.get(wfProcessInstance.getStartuserid()).getDisplayname());
		}
		wfProcessInstance.setBusinesskey(businessKey);

		return wfProcessInstance;

	}

	/**
	 * 过滤空的task，并按照开始日期进行排序
	 * @param map
	 */
	public LinkedHashMap filterTaskMap(Map<String,WFProcessNode> map,String processInstanceId){
		List<HistoricTaskInstance> history = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).orderByHistoricTaskInstanceEndTime().asc().list();
		LinkedHashMap<String,WFProcessNode> filterMap = new LinkedHashMap<>();
		if(history.size()>0){
			history.forEach(historyTask -> {
				WFProcessNode value = map.get(historyTask.getTaskDefinitionKey());
				if (ObjectUtils.isEmpty(value) || filterMap.containsKey(historyTask.getTaskDefinitionKey())) {
					return;
				}
				if (ObjectUtils.isEmpty(value.getExtensionparams().get("identitylinks")) && ObjectUtils.isEmpty(value.getExtensionparams().get("comments"))) {
					return;
				}
				filterMap.put(historyTask.getTaskDefinitionKey(), value);
			});
			if(filterMap.size() > 0){
				return filterMap;
			}
		}
		return (LinkedHashMap) map;
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
			String dynainstid = getDynainstId();
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
				String processDefinitionKey;
				if(!StringUtils.isEmpty(dynainstid))
					processDefinitionKey="dyna-"+dynainstid+"-"+system+"-"+booking+"-"+params[1];
				else if (!StringUtils.isEmpty(bpmnFileName) && bpmnFileName.contains(":") && bpmnFileName.split(":").length==2)
					processDefinitionKey="dyna-"+bpmnFileName.split(":")[1]+"-"+system+"-"+booking+"-"+params[1];
				else
					processDefinitionKey=system+"-"+booking+"-"+params[1];

				WFProcessDefinition old = new WFProcessDefinition();
				old.setDefinitionkey(processDefinitionKey);
				if(iwfProcessDefinitionService.checkKey(old)){
					old = iwfProcessDefinitionService.get(processDefinitionKey);
				}
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
					if (delegateExecution == null) {
						userData2="";
					} else {
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

	/**
	 * 获取工作流角色成员
	 * @param groupIds
	 * @param delegateExecution
	 * @return
	 */
	public Set<WFMember> getGroupUsers2(String groupIds, DelegateExecution delegateExecution)
	{
		Set <String> orgList =new HashSet<>();
		Set <String> deptList = new HashSet<>();
		Set <WFMember> memberList = new HashSet<>();
		Object activedata=delegateExecution.getVariable("activedata");
		if(delegateExecution == null || activedata == null){
			throw new BadRequestAlertException("获取业务数据失败","","");
		}
		if(StringUtils.isEmpty(groupIds))
			throw new BadRequestAlertException("当前步骤未配置用户组","","");

		String[] groups=groupIds.split(",");
		for(String groupId:groups)
		{
			String userData="";
			String userData2="";
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
				for(String field : userData2.split(";")){
					Object fieldvalue = null;
					if(field.indexOf("srf")==0)
					{
						FlowUser curUser=FlowUser.getCurUser();
						if(curUser!=null&&curUser.getUser()!=null){
							fieldvalue=curUser.getUser().getSessionParams().get(field);
						}
					}
					else {
						if(activedata instanceof Map) {
							fieldvalue = ((Map) activedata).get(field);
						}
					}
					if(fieldvalue!=null){
						if("org".equals(userData)){
							orgList.addAll(Arrays.asList(String.valueOf(fieldvalue).split(",")));
						}
						else if("dept".equals(userData)){
							deptList.addAll(Arrays.asList(String.valueOf(fieldvalue).split(",")));
						}
					}
				}
			}
			WFGroup group=iwfGroupService.get(groupId);
			List<WFMember> list=group.getWfmember();
			if (list!=null)
			{
				for(WFMember member : list)
				{
					String orgId = member.getOrgid();
					String deptId = member.getMdeptid();
					if(ObjectUtils.isEmpty(orgList) && ObjectUtils.isEmpty(deptList)){
						memberList.add(member);
					}
					else{
						if((!ObjectUtils.isEmpty(orgId) && orgList.contains(orgId)) || (!ObjectUtils.isEmpty(deptId) && deptList.contains(deptId))){
							memberList.add(member);
						}
					}
				}
			}
		}
		return memberList;
	}

	/**
	 * 后加签 （转办-工作转移）
	 * @param system
	 * @param appname
	 * @param entity
	 * @param businessKey
	 * @param taskId
	 * @param taskWay
	 */
	public boolean beforeSign(String system, String appname,
							  String entity, String businessKey, String taskId, WFTaskWay taskWay) {
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if (StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("未传入当前用户", entity, businessKey);

		Map activedata;
		if(taskWay.get("activedata")!=null && taskWay.get("activedata") instanceof Map)
			activedata=(Map)taskWay.get("activedata");
		else
			activedata=new LinkedHashMap();
		Object signUser = activedata.get("srfwfannotator");
		if (ObjectUtils.isEmpty(signUser)) {
			throw new BadRequestAlertException("未传入加签用户", entity, businessKey);
		}
		Task curTask = taskService.createTaskQuery().taskId(taskId).singleResult();
		if (curTask == null) {
			throw new BadRequestAlertException(String.format("未能获取到[%s]运行任务", curTask.getId()), "", "");
		}
		if (DelegationState.PENDING != curTask.getDelegationState()) {
			taskService.delegateTask(taskId, String.valueOf(signUser));
			//saveTask(curTask);
		} else {
			throw new BadRequestAlertException(String.format("任务正在加签中，无法进行二次加签", curTask.getId()), "", "");
		}
		return true;
	}

	/**
	 * 后加签 （转办）
	 * @param system
	 * @param appname
	 * @param entity
	 * @param businessKey
	 * @param taskId
	 * @param taskWay
	 */
	public boolean afterSign(String system,String appname,
							 String entity,String businessKey,String taskId,WFTaskWay taskWay){
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if (StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("未传入当前用户", entity, businessKey);
		Map activedata;
		if(taskWay.get("activedata")!=null && taskWay.get("activedata") instanceof Map)
			activedata=(Map)taskWay.get("activedata");
		else
			activedata=new LinkedHashMap();
		Object signUser = activedata.get("srfwftransferor");
		if (ObjectUtils.isEmpty(signUser)) {
			throw new BadRequestAlertException("未传入转办用户", entity, businessKey);
		}
		Task curTask  = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(curTask == null){
			throw new BadRequestAlertException(String.format("未能获取到[%s]运行任务", taskId),"","");
		}

		//转办任务
		taskService.deleteUserIdentityLink(curTask.getId(),userId,"candidate");
		taskService.addUserIdentityLink(curTask.getId(), (String) signUser,"candidate");

		//saveTask(curTask);
		return true;
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

	/**
	 * 设置流程表单
	 *
	 * @param sequenceFlow
	 * @param way
	 */
	private void setTaskWayForm(SequenceFlow sequenceFlow, WFTaskWay way) {
		Map<String,String> attributes = getAllParam(sequenceFlow,"form");
		if (!ObjectUtils.isEmpty(attributes)) {
			for (Map.Entry<String,String> entry : attributes.entrySet()) {
				way.set(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 将流程表单设置到请求头中
	 *
	 * @param userTask
	 */
	private void setProcessForm(UserTask userTask) {
		Object objReq = RequestContextHolder.currentRequestAttributes();
		if (!ObjectUtils.isEmpty(objReq) && objReq instanceof ServletRequestAttributes) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest req = attr.getRequest();
			Map<String,String> attributes = getAllParam(userTask,"form");
			if (!ObjectUtils.isEmpty(attributes)) {
				for (Map.Entry<String,String> entry : attributes.entrySet()) {
					req.setAttribute(entry.getKey(), entry.getValue());
				}
			}
		}
	}

	/**
	 * 获取流程节点指定参数
	 * @param element
	 * @param property
	 * @param attribute
	 * @return
	 */
	public String getParam(FlowElement element, String property, String attribute) {
		List<ExtensionElement> formProps = element.getExtensionElements().get(property);
		if (formProps == null) {
			return null;
		}
		for (ExtensionElement prop : formProps) {
			if (prop.getAttributes() == null)
				return null;
			Map<String, List<ExtensionAttribute>> attributes = prop.getAttributes();
			if (attributes.containsKey(attribute)) {
				return ObjectUtils.isEmpty(attributes.get(attribute)) ? null : String.valueOf(attributes.get(attribute).get(0).getValue());
			}
		}
		return null;
	}
	/**
	 * 清除link已读完的task
	 * @param element
	 * @param property
	 * @param attribute
	 * @return
	 */
	public String removeTask(FlowElement element, String property, String attribute) {
		List<ExtensionElement> formProps = element.getExtensionElements().get(property);
		if (formProps == null) {
			return null;
		}
		for (ExtensionElement prop : formProps) {
			if (prop.getAttributes() == null)
				return null;
			Map<String, List<ExtensionAttribute>> attributes = prop.getAttributes();
			if (attributes.containsKey(attribute)) {
				return ObjectUtils.isEmpty(attributes.get(attribute)) ? null : String.valueOf(attributes.get(attribute).get(0).getValue());
			}
		}
		return null;
	}

	/**
	 * 获取流程节点所有参数
	 * @param element
	 * @param property
	 * @return
	 */
	public Map<String, String> getAllParam(FlowElement element, String property) {
		Map<String, String> params = new HashMap();
		List<ExtensionElement> formProps = element.getExtensionElements().get(property);
		if (formProps == null) {
			return null;
		}
		for (ExtensionElement prop : formProps) {
			if (prop.getAttributes() == null)
				return null;
			Map<String, List<ExtensionAttribute>> attributes = prop.getAttributes();
			for (String attribute : attributes.keySet()) {
				if (!ObjectUtils.isEmpty(attributes.get(attribute))) {
					params.put(attribute, attributes.get(attribute).get(0).getValue());
				}
			}
		}
		return params;
	}

	/**
	 * 获取动态实例标识
	 * @return
	 */
	private String getDynainstId(){
		String dynainstid = null;
		if(RequestContextHolder.getRequestAttributes()==null && !(RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes)){
			return null;
		}
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if(requestAttributes!=null) {
			HttpServletRequest request = requestAttributes.getRequest();
			if(request!=null && !StringUtils.isEmpty(request.getHeader("dynainstid"))){
				dynainstid= request.getHeader("dynainstid");
			}
		}
		return dynainstid;
	}

	/**
	 * 判断是否退出会签
	 * @param execution
	 * @return
	 */
	public boolean accessCondition(DelegateExecution execution) {
		Object allRolesCnt = execution.getVariable("all_roles_cnt");
		Object completeRolesCnt = execution.getVariable("complete_roles_cnt");
		Object completeInstance = execution.getVariable("nrOfCompletedInstances");
		Object allInstance = execution.getVariable("nrOfInstances");
		Object sequenceFlowId = execution.getVariable("sequenceFlowId");
		String flowAccessCond = getNextCondition(execution, sequenceFlowId);   // role : any  || all
		if (!ObjectUtils.isEmpty(allInstance) && !ObjectUtils.isEmpty(completeInstance) && !ObjectUtils.isEmpty(flowAccessCond)) {
			if("ANY".equalsIgnoreCase(flowAccessCond)){
				return true;
			}
			else if ("ALL|ROLE:ANY".equalsIgnoreCase(flowAccessCond) && allRolesCnt == completeRolesCnt) {
				return true;
			}
			else{
				return (int) completeInstance / (int) allInstance == 1;
			}
		} else {
			return false;
		}
	}

	/**
	 * 获取连接线条件 （all/any/all|role:any）
	 *
	 * @param execution
	 * @param sequenceFlowId
	 * @return
	 */
	public String getNextCondition(DelegateExecution execution, Object sequenceFlowId) {
		if (!ObjectUtils.isEmpty(execution.getCurrentFlowElement()) && execution.getCurrentFlowElement() instanceof UserTask) {
			UserTask userTask = (UserTask) execution.getCurrentFlowElement();
			for (SequenceFlow flow : userTask.getOutgoingFlows()) {
				if (sequenceFlowId.equals(flow.getId())) {
					return getParam(flow, "form", "nextCondition");
				}
			}
		}
		return null;
	}

	/**
	 * 获取用户所属的工作流角色
	 * @param userId
	 * @param execution
	 * @return
	 */
	public Set<String> getRoleByUserId(String userId, DelegateExecution execution) {
		Set roles = new HashSet();
		if (!ObjectUtils.isEmpty(userId)) {
			String candidateUsers = getParam(execution.getCurrentFlowElement(),"form","candidateUsersList");
			if (!StringUtils.isEmpty(candidateUsers)) {
				LinkedHashMap executionMap = (LinkedHashMap) execution.getVariable("activedata");
				String[] groups = candidateUsers.split("\\|\\|");
				if (groups.length > 0) {
					for (String group : groups) {
						if (group.contains("activedata")) {
							for (String elUserId : group.split("\\|")) {
								ExpressionParser parser = new SpelExpressionParser();
								StandardEvaluationContext context = new StandardEvaluationContext();
								Expression exp = parser.parseExpression(elUserId);
								context.addPropertyAccessor(new MapAccessor());
								context.setVariable("activedata", executionMap);
								String processUserId = exp.getValue(context, String.class);
								if (!StringUtils.isEmpty(processUserId) && processUserId.contains(userId)) {
									roles.add(group);
								}
							}
						}
						if (group.contains("wfCoreService.getGroupUsers")) {
							String exp = group;
							EvaluationContext oldContext = new StandardEvaluationContext();
							oldContext.setVariable("wfCoreService", this);
							oldContext.setVariable("execution", execution);
							Expression oldExp = parser.parseExpression(exp);
							List<WFMember> users = oldExp.getValue(oldContext, List.class);
							if (!StringUtils.isEmpty(users)) {
								users.forEach(groupMember -> {
									if (!ObjectUtils.isEmpty(groupMember.getUserid()) && userId.equals(groupMember.getUserid())) {
										String roleId;
										if (!ObjectUtils.isEmpty(groupMember.getMdeptid())) {
											roleId = String.format("%s_%s", groupMember.getGroupid(), groupMember.getMdeptid());
										} else {
											roleId = groupMember.getGroupid();
										}
										roles.add(roleId);
									}
								});
							}
						}
					}
				}
			}
		}
		return roles;
	}

	/**
	 * 创建任务
	 * @param sourceTask
	 * @return
	 */
	public TaskEntity createTask(Task sourceTask) {
		TaskEntity task = null;
		if (sourceTask != null) {
			//1.生成子任务
			task = (TaskEntity) taskService.newTask();
			task.setParentTaskId(sourceTask.getId());
			task.setCategory(sourceTask.getCategory());
			task.setDescription(sourceTask.getDescription());
			task.setTenantId(sourceTask.getTenantId());
			task.setAssignee(sourceTask.getAssignee());
			task.setName(sourceTask.getName());
			task.setProcessDefinitionId(sourceTask.getProcessDefinitionId());
			task.setTaskDefinitionKey(sourceTask.getTaskDefinitionKey());
			task.setTaskDefinitionId(sourceTask.getTaskDefinitionId());
			task.setPriority(sourceTask.getPriority());
			task.setCreateTime(new Date());
		}
		return task;
	}

	/**
	 * 清除角色中其他成员待办任务
	 * @param userRoles
	 * @param execution
	 */
	public void deleteRoleTask(Set userRoles, DelegateExecution execution) {
		Object processInstanceId = execution.getProcessInstanceId();
		if(ObjectUtils.isEmpty(processInstanceId)){
			throw new BadRequestAlertException("无法获取流程实例","","");
		}
		Set<String> roleUserIds = getUsersByRole(userRoles,execution);
		if(roleUserIds.size()>0){
			Map param = new HashMap();
			param.put("userids",roleUserIds);
			param.put("processinstanceid",processInstanceId);
			List<Map> tasks = wfCoreMapper.searchUserTask(param);
			if(tasks.size()>0){
				for(Map task : tasks){
					Object executionId = task.get("execution");
					if(!StringUtils.isEmpty(executionId)){
						runtimeService.deleteMultiInstanceExecution(String.valueOf(executionId),false);
					}
				}
			}
		}
	}

	/**
	 * 获取角色成员
	 * @param roles
	 * @param execution
	 * @return
	 */
	public Set<String> getUsersByRole(Set roles, DelegateExecution execution) {
		Set userIds = new HashSet();
		if (!ObjectUtils.isEmpty(roles)) {
			String candidateUsers = getParam(execution.getCurrentFlowElement(),"form","candidateUsersList");
			if (!StringUtils.isEmpty(candidateUsers)) {
				LinkedHashMap executionMap = (LinkedHashMap) execution.getVariable("activedata");
				String[] groups = candidateUsers.split("\\|\\|");
				if (groups.length > 0) {
					for (String group : groups) {
						if (group.contains("activedata") && roles.contains(group)) {
							for (String elUserId : group.split("\\|")) {
								ExpressionParser parser = new SpelExpressionParser();
								StandardEvaluationContext context = new StandardEvaluationContext();
								Expression exp = parser.parseExpression(elUserId);
								context.addPropertyAccessor(new MapAccessor());
								context.setVariable("activedata", executionMap);
								String processUserId = exp.getValue(context, String.class);
								if (StringUtils.isEmpty(processUserId)) {
									userIds.add(processUserId);
								}
							}
						}
						if (group.contains("wfCoreService.getGroupUsers")) {
							EvaluationContext oldContext = new StandardEvaluationContext();
							oldContext.setVariable("wfCoreService", this);
							oldContext.setVariable("execution", execution);
							Expression oldExp = parser.parseExpression(group);
							List<WFMember> users = oldExp.getValue(oldContext, List.class);
							if (!StringUtils.isEmpty(users)) {
								users.forEach(groupMember -> {
									if (!ObjectUtils.isEmpty(groupMember.getUserid())) {
										String roleId;
										if (!ObjectUtils.isEmpty(groupMember.getMdeptid())) {
											roleId = String.format("%s_%s", groupMember.getGroupid(), groupMember.getMdeptid());
										} else {
											roleId = groupMember.getGroupid();
										}
										if (roles.contains(roleId)) {
											userIds.add(groupMember.getUserid());
										}
									}
								});
							}
						}
					}
				}
			}
		}
		return userIds;
	}

	/**
	 * 审批记录
	 * @param curTask
	 * @return
	 */
	private Task saveTask(Task curTask){
		String userId = "0100";
		if (StringUtils.isEmpty(userId))
			if (StringUtils.isEmpty(userId))
				throw new BadRequestAlertException("未传入当前用户", "", "");

		Task signTask = createTask(curTask);
		signTask.setParentTaskId(curTask.getId());
		taskService.saveTask(signTask);
		taskService.addUserIdentityLink(signTask.getId(), userId, "candidate");
		taskService.complete(signTask.getId());
		return signTask;
	}

	/**
	 * 标记任务为已读
	 * @param system
	 * @param appname
	 * @param entity
	 * @param businessKey
	 * @param taskId
	 * @param taskWay
	 */
	public boolean readTask(String system, String appname, String entity, String businessKey, String taskId, WFTaskWay taskWay) {
		String userId=AuthenticationUser.getAuthenticationUser().getUserid();
		if(StringUtils.isEmpty(userId))
			throw new BadRequestAlertException("未传入当前用户",entity,businessKey);
		if(StringUtils.isEmpty(taskId)){
			taskId=taskWay.getTaskid();
		}
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(ObjectUtils.isEmpty(task)){
			throw new BadRequestAlertException("未找到运行时任务","","");
		}
		List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(taskId);
		identityLinks.forEach(idl->{
			if(userId.equals(idl.getUserId())){
				completeSendCopyTask(identityLinks,task);
				Map map  =new HashMap();
				map.put("taskid",task.getId());
				map.put("userid",userId);
				wfCoreMapper.readTask(map);
				return ;
			}
		});
		return true;
	}

	/**
	 * 判断除了本身其他link是否已读
	 * @return
	 */
	public void completeSendCopyTask(List<IdentityLink> identityLinks,Task task){
		List<IdentityLink> unReadLinks = identityLinks.stream().filter(link -> StringUtils.isEmpty(link.getScopeType())).collect(Collectors.toList());
		String scopeType = task.getScopeType();
		if (!StringUtils.isEmpty(scopeType) && "sendcopy".equals(scopeType) && unReadLinks.size() == 1) {
			taskService.complete(task.getId());
		}
	}

	/**
	 * @param taskId 当前taskId
	 * @param delegateUser 被委托人
	 * @return
	 */
	public boolean delegateTask(String taskId,String delegateUser) {

		if (taskId != null) {
			// 委托人是当前用户
			String userId=AuthenticationUser.getAuthenticationUser().getUserid();
			taskService.setAssignee(taskId, userId);
			taskService.delegateTask(taskId,delegateUser);
			return true;
		}
		return false;
	}

	/**
	 * @param taskId 当前需要回退的节点
	 * @return 回退上一个节点
	 */
	public boolean sendBack(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String taskDefinitionKey = task.getTaskDefinitionKey();
		if (taskDefinitionKey == null) {
			log.debug("taskDefinitionKey不存在");
			return false;
		}
		String processInstanceId = task.getProcessInstanceId();
		if (processInstanceId == null) {
			log.debug("processInstanceId不存在");
			return false;
		}
		List<HistoricTaskInstance> history = historyService.createHistoricTaskInstanceQuery()
				.processInstanceId(processInstanceId)
				.orderByHistoricTaskInstanceEndTime()
				.desc()
				.list();
		if(history.size() > 0){
			HistoricTaskInstance sourceRef = history.get(0);
			// 执行回退
			runtimeService.createChangeActivityStateBuilder()
					.processInstanceId(processInstanceId)
					.moveActivityIdTo(taskDefinitionKey, sourceRef.getTaskDefinitionKey())
					.changeState();
		}
		return true;
	}

	/**
	 *  查询个人实体待办：使用表格查询模式，返回的待办数据中包含工作流信息，后续通过该信息跳转至对应审批页
	 * @param context
	 * @return
	 */
	public Map<String, Map<String, Object>> searchMyTask2(WFTaskSearchContext context) {
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> tasks = null;
		Map<String, Map<String, Object>> businessKeys = new HashMap<>();
		context.setSort("createtime,desc");

		String strTaskType = context.getSrfWF();
		if (strTaskType == null) {
			tasks = wfCoreMapper.searchMyTask(context.getPages(),context,context.getSelectCond());
		} else {
			 if (TaskType.TODO.name().equalsIgnoreCase(strTaskType)) {
				tasks = wfCoreMapper.searchMyTask(context.getPages(), context, context.getSelectCond());
			 } else if (TaskType.DONE.name().equalsIgnoreCase(strTaskType)) {
				tasks = wfCoreMapper.searchDoneTask(context.getPages(), context, context.getSelectCond());
			 } else if (TaskType.FINISH.name().equalsIgnoreCase(strTaskType)) {
				tasks = wfCoreMapper.searchFinishTask(context.getPages(), context, context.getSelectCond());
			 } else if (TaskType.ALL.name().equalsIgnoreCase(strTaskType)) {
				 tasks = wfCoreMapper.searchMyAllTask(context.getPages(), context, context.getSelectCond());
			 } else {
				 throw new BadRequestAlertException(String.format("未能识别的待办类型[%s]", strTaskType), "", "");
			 }
		}

		if (!ObjectUtils.isEmpty(tasks)) {
			for (WFTask task : tasks.getRecords()) {
				Object key = task.getProcessinstancebusinesskey();
				if (key != null) {
					String str = key.toString();
					if (str.indexOf(":k-") > 0) {
						str = str.split(":k-")[1];
					}
					Map<String, Object> params = new HashMap();
					params.put("srfprocessdefinitionkey", task.getProcessdefinitionkey());
					params.put("srftaskdefinitionkey", task.getTaskdefinitionkey());
					params.put("srftaskid", task.getId());
					businessKeys.put(str, params);
				}
			}
		}
		return businessKeys;
	}
}
