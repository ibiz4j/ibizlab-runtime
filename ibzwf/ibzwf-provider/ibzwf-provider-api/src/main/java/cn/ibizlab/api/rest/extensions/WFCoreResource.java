package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.mapping.WFTaskMapping;
import cn.ibizlab.core.workflow.domain.*;
import cn.ibizlab.core.workflow.extensions.service.WFCoreService;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.util.enums.TaskType;
import cn.ibizlab.util.errors.BadRequestAlertException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = {"wfcore" })
@RestController("api-wfcore")
@RequestMapping("")
public class WFCoreResource
{
	/**
	 * 流程PC表单标记
	 */
	private static final  String formTag="process-form";
	/**
	 * 流程移动端表单标记
	 */
	private static final  String mobFormTag="process-mobform";

	@Autowired
	private WFCoreService wfCoreService;

	@Autowired
	@Lazy
	public WFTaskMapping wfTaskMapping;

	@ApiOperation(value = "getWFProcessDefinition", tags = {"WFProcessDefinition" },  notes = "根据系统实体查找当前适配的工作流模型")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions2")
	public ResponseEntity<List<WFProcessDefinition>> getDynaWorkflow(@PathVariable("system") String system,@PathVariable("appname") String appname,
																 @PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynamicWorkflow(system,appname,entity));
	}

	@ApiOperation(value = "getWFProcessDefinition", tags = {"WFProcessDefinition" },  notes = "根据动态实例查找当前适配的工作流模型")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{insttag}/{insttag2}/{entity}/process-definitions")
	public ResponseEntity<List<WFProcessDefinition>> getDynaWorkflow2(@PathVariable("system") String system ,@PathVariable("appname") String appname,@PathVariable("insttag") String instTag, @PathVariable("insttag2") String instTag2,
																	 @PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynamicWorkflow(instTag,instTag2,system,appname,entity));
	}



	@ApiOperation(value = "getWFProcessDefinition", tags = {"WFProcessDefinition" },  notes = "根据动态实例查找当前适配的工作流模型")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{dynainstid}/{entity}/process-definitions")
	public ResponseEntity<List<WFProcessDefinition>> getDynaWorkflow(@PathVariable("system") String system ,@PathVariable("appname") String appname,@PathVariable("dynainstid") String dynainstid,
																	 @PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynamicWorkflow(dynainstid,system,appname,entity));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据动态实例查询我的待办主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{insttag}/{insttag2}/{entity}/tasks")
	public ResponseEntity<Map<String,Map<String,Object>>> getTaskByUserId(@PathVariable("system") String system, @PathVariable("userId") String userId,
																					  @PathVariable("entity") String entity, @PathVariable("insttag") String instTag , @PathVariable("insttag2") String instTag2) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynaBusinessKeys(system,"",entity,instTag,instTag2,userId, TaskType.WORK));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的待阅主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{insttag}/{insttag2}/{entity}/tasks/unread")
	public ResponseEntity<Map<String,Map<String,Object>>> getUnReadTaskByUserId(@PathVariable("system") String system, @PathVariable("userId") String userId,
																					  @PathVariable("entity") String entity, @PathVariable("insttag") String instTag , @PathVariable("insttag2") String instTag2) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynaBusinessKeys(system,"",entity,instTag,instTag2,userId, TaskType.READ));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的已办主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{insttag}/{insttag2}/{entity}/tasks/done")
	public ResponseEntity<Map<String,Map<String,Object>>> getDoneByUserId(@PathVariable("system") String system, @PathVariable("userId") String userId,
																					  @PathVariable("entity") String entity, @PathVariable("insttag") String instTag , @PathVariable("insttag2") String instTag2) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynaBusinessKeys(system,"",entity,instTag,instTag2,userId, TaskType.DONE));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的办结主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{insttag}/{insttag2}/{entity}/tasks/finish")
	public ResponseEntity<Map<String,Map<String,Object>>> getFinishByUserId(@PathVariable("system") String system, @PathVariable("userId") String userId,
																					  @PathVariable("entity") String entity, @PathVariable("insttag") String instTag , @PathVariable("insttag2") String instTag2) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynaBusinessKeys(system,"",entity,instTag,instTag2,userId, TaskType.FINISH));
	}
	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的办结主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{insttag}/{insttag2}/{entity}/tasks/all")
	public ResponseEntity<Map<String,Map<String,Object>>> getAllByUserId(@PathVariable("system") String system, @PathVariable("userId") String userId,
																		 @PathVariable("entity") String entity, @PathVariable("insttag") String instTag , @PathVariable("insttag2") String instTag2){
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getDynaBusinessKeys(system,"",entity,instTag,instTag2,userId,TaskType.ALL));
	}


	@ApiOperation(value = "标记任务已读", tags = {"工作流标记任务已读" },  notes = "标记任务已读")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/read")
	public ResponseEntity<Boolean> readTask(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											@RequestBody WFTaskWay taskWay) {
		return ResponseEntity.ok(wfCoreService.readTask(system,appname,entity,businessKey,taskId,taskWay));
	}

	@ApiOperation(value = "getWFProcessDefinition", tags = {"WFProcessDefinition" },  notes = "根据系统实体查找当前适配的工作流模型")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions")
	public ResponseEntity<List<WFProcessDefinition>> getworkflow(@PathVariable("system") String system,@PathVariable("appname") String appname,
																 @PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getWorkflow(system,appname,entity));
	}

	@ApiOperation(value = "getStepByEntity", tags = {"WFProcessNode" },  notes = "根据系统实体查找当前适配的工作流模型步骤")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions-nodes")
	public ResponseEntity<List<WFProcessNode>> getwfstep(@PathVariable("system") String system,@PathVariable("appname") String appname,
														 @PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getWFStep2(system,appname,entity));
	}

	//@PreAuthorize("hasPermission(#entity,'WFSTART',this.getEntity())")
	@ApiOperation(value = "wfstart", tags = {"WFProcessInstance" },  notes = "启动工作流")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/process-instances")
	public ResponseEntity<WFProcessInstance> wfstart(@PathVariable("system") String system,@PathVariable("appname") String appname,
													 @PathVariable("entity") String entity,
													 @PathVariable("businessKey") String businessKey,@RequestBody WFProcessInstance instance) {
		instance.setBusinesskey(businessKey);
		return ResponseEntity.ok(wfCoreService.wfStart(system,appname,entity,businessKey,instance));
	}

	@ApiOperation(value = "getWayByBusinessKey", tags = {"WFTaskWay" },  notes = "根据业务主键和当前步骤获取操作路径")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/{businessKey}/usertasks/{taskDefinitionKey}/ways")
	public ResponseEntity<List<WFTaskWay>> getwflink(@PathVariable("system") String system,@PathVariable("appname") String appname,
													 @PathVariable("entity") String entity,
													 @PathVariable("businessKey") String businessKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey) {
		List<WFTaskWay> taskWays=wfCoreService.getWFLink(system,appname,entity,businessKey,taskDefinitionKey);
		return ResponseEntity.status(HttpStatus.OK).headers(getHeader()).body(taskWays);
	}

	@ApiOperation(value = "getWayByProcessDefinitionKey", tags = {"WFStepWay" },  notes = "根据流程和当前步骤获取操作路径")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/ways")
	public ResponseEntity<List<WFTaskWay>> getWayByDefKey(@PathVariable("system") String system,@PathVariable("appname") String appname,
														  @PathVariable("entity") String entity,
														  @PathVariable("processDefinitionKey") String processDefinitionKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey) {
		List<WFTaskWay> taskWays=wfCoreService.getWFLinkByStep(system,appname,entity,processDefinitionKey,taskDefinitionKey);
		return ResponseEntity.status(HttpStatus.OK).headers(getHeader()).body(taskWays);
	}

	@ApiOperation(value = "getWayByTaskId", tags = {"WFTaskWay" },  notes = "根据业务主键和当前步骤获取操作路径")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/ways")
	public ResponseEntity<List<WFTaskWay>> getTasklink(@PathVariable("system") String system,@PathVariable("appname") String appname,
													   @PathVariable("entity") String entity,
													   @PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId) {
		List<WFTaskWay> taskWays=wfCoreService.getTaskLink(system,appname,entity,businessKey,taskId);
		return ResponseEntity.status(HttpStatus.OK).headers(getHeader()).body(taskWays);
	}

	@ApiOperation(value = "getWFHistory", tags = {"getWFHistory" },  notes = "根据业务主键获取审批意见记录")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/{businessKey}/process-instances/{processInstanceId}/history")
	public ResponseEntity<WFProcessInstance> getWFHistory(@PathVariable("system") String system,@PathVariable("appname") String appname,
														  @PathVariable("entity") String entity,
														  @PathVariable("businessKey") String businessKey,@PathVariable("processInstanceId") String processInstanceId) {
		if(StringUtils.isEmpty(processInstanceId)||"null".equals(processInstanceId)||"alls".equals(processInstanceId))
			processInstanceId="";
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getWFHistory(system,appname,entity,businessKey,processInstanceId));
	}

	//@PreAuthorize("hasPermission(#entity,'WFSTART',this.getEntity())")
	@ApiOperation(value = "wfsubmit", tags = {"Submit" },  notes = "工作流执行步骤")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}")
	public ResponseEntity<WFProcessInstance> wfsubmit(@PathVariable("system") String system,@PathVariable("appname") String appname,
													  @PathVariable("entity") String entity,
													  @PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
													  @RequestBody WFTaskWay taskWay) {
		WFProcessInstance instance = new WFProcessInstance();
		return ResponseEntity.ok(wfCoreService.wfsubmit(system,appname,entity,businessKey,taskId,taskWay));
	}

	@ApiOperation(value = "sendback", tags = {"sendback" },  notes = "流程步骤回退")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/sendback")
	public ResponseEntity<Boolean> sendback(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											@RequestBody WFTaskWay taskWay){
		return ResponseEntity.ok(wfCoreService.sendBack(system,appname,entity,businessKey,taskId,taskWay));
	}

//	@ApiOperation(value = "delegatetask", tags = {"delegatetask" },  notes = "委派任务")
//	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/{delegateuser}/delegate")
//	public ResponseEntity<Boolean> delegatetask(@PathVariable("taskId") String taskId,@PathVariable("delegateuser") String delegateuser){
//		return ResponseEntity.ok(wfCoreService.delegateTask(taskId,delegateuser));
//	}

	//@PreAuthorize("hasPermission(#entity,'WFSTART',this.getEntity())")
	@ApiOperation(value = "wfsubmitbatch", tags = {"SubmitBatch" },  notes = "批量工作流执行步骤")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/ways/{sequenceFlowId}/submit")
	public ResponseEntity<Boolean> wfsubmit(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("processDefinitionKey") String processDefinitionKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey,
											@PathVariable("sequenceFlowId") String sequenceFlowId,
											@RequestBody List<Map> businessList) {
		WFProcessInstance instance = new WFProcessInstance();

		businessList.forEach(business -> {
			if(business.get("srfkey")==null)
				return;
			String businessKey = business.get("srfkey").toString();
			wfCoreService.getWFLink(system,appname,entity,businessKey,taskDefinitionKey).forEach(way ->{
				if(way.getSequenceflowid().equals(sequenceFlowId))
				{
					way.set("activedata",business);
					wfCoreService.wfsubmit(system,appname,entity,businessKey,way.getTaskid(),way);
				}
			});
		});

		return ResponseEntity.ok(true);
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的待办主键清单")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/tasks")
	public ResponseEntity<List<String>> getbusinesskeys(@PathVariable("system") String system,@PathVariable("appname") String appname,
														@PathVariable("entity") String entity,@PathVariable("processDefinitionKey") String processDefinitionKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey) {
		if(StringUtils.isEmpty(appname)||"null".equals(appname)||"alls".equals(appname))
			appname="";
		if(StringUtils.isEmpty(processDefinitionKey)||"null".equals(processDefinitionKey)||"alls".equals(processDefinitionKey))
			processDefinitionKey="";
		if(StringUtils.isEmpty(taskDefinitionKey)||"null".equals(taskDefinitionKey)||"alls".equals(taskDefinitionKey))
			taskDefinitionKey="";
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getBusinessKeys(system,appname,entity,processDefinitionKey,taskDefinitionKey,""));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" },  notes = "根据流程步骤查询我的待办主键清单")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-user-{userId}/{entity}/process-definitions/{processDefinitionKey}/usertasks/{taskDefinitionKey}/tasks")
	public ResponseEntity<List<String>> getbusinesskeysByUserId(@PathVariable("system") String system,@PathVariable("userId") String userId,
																@PathVariable("entity") String entity,@PathVariable("processDefinitionKey") String processDefinitionKey,@PathVariable("taskDefinitionKey") String taskDefinitionKey) {
		if(StringUtils.isEmpty(processDefinitionKey)||"null".equals(processDefinitionKey)||"alls".equals(processDefinitionKey))
			processDefinitionKey="";
		if(StringUtils.isEmpty(taskDefinitionKey)||"null".equals(taskDefinitionKey)||"alls".equals(taskDefinitionKey))
			taskDefinitionKey="";
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getBusinessKeys(system,"",entity,processDefinitionKey,taskDefinitionKey,userId));
	}

	@ApiOperation(value = "getBusinessKeys", tags = {"String" } ,notes = "查询我的待办主键清单（含流程参数）")
	@RequestMapping(method= RequestMethod.GET , value="/{system}-app-{appname}/{entity}/mytasks")
	public ResponseEntity<Map<String,Map<String,Object>>> getbusinesskeys(@PathVariable("system") String system,@PathVariable("entity") String entity,WFTaskSearchContext context) {
		context.setN_definitionkey_leftlike(String.format("%s-%s",system,entity));
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.searchMyTask2(context));
	}

	@ApiOperation(value = "获取我的系统待办", tags = {"工作流任务" } ,notes = "获取我的系统待办")
	@RequestMapping(method= RequestMethod.GET , value="/{system}-app-{appname}/mytasks")
	public ResponseEntity<List<WFTask>> fetchDefault(@PathVariable("system") String system,WFTaskSearchContext context) {
		context.setN_definitionkey_leftlike(system);
		Page<WFTask> domains = wfCoreService.searchMyTask(context) ;
		return ResponseEntity.status(HttpStatus.OK)
				.header("x-page", String.valueOf(context.getPageable().getPageNumber()))
				.header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
				.header("x-total", String.valueOf(domains.getTotalElements()))
				.body(domains.getContent());
	}

	@ApiOperation(value = "获取我的全部待办", tags = {"工作流任务" } ,notes = "获取我的全部待办")
	@RequestMapping(method= RequestMethod.GET , value="/mytasks")
	public ResponseEntity<List<WFTask>> fetchMyTasks(WFTaskSearchContext context) {
		Page<WFTask> domains = wfCoreService.searchMyTask(context);
		return ResponseEntity.status(HttpStatus.OK)
				.header("x-page", String.valueOf(context.getPageable().getPageNumber()))
				.header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
				.header("x-total", String.valueOf(domains.getTotalElements()))
				.body(domains.getContent());
	}

	@ApiOperation(value = "获取我的分页缓存待办", tags = {"工作流任务" } ,notes = "获取我的分页缓存待办")
	@RequestMapping(method= RequestMethod.GET , value="/mypagetasks")
	public ResponseEntity<List<WFTask>> getTaskAll(WFTaskSearchContext context) {
		Page domains = wfCoreService.getTaskByPage(context);
		return ResponseEntity.status(HttpStatus.OK)
				.header("x-page", String.valueOf(context.getPageable().getPageNumber()))
				.header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
				.header("x-total", String.valueOf(domains.getTotalElements()))
				.body(domains.getContent());
	}

	@RequestMapping(value = "/mytasks/{processDefinitionKey}/{type}/{businessKey}/usertasks/{taskDefinitionKey}", method = RequestMethod.GET  )
	public ResponseEntity openTask(@PathVariable("processDefinitionKey") final String processDefinitionKey,@PathVariable("type") final String type,
								   @PathVariable("businessKey") final String businessKey, @PathVariable("taskDefinitionKey") final String taskDefinitionKey,
								   HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path =  wfCoreService.getTaskUrl(type,processDefinitionKey,"",businessKey,taskDefinitionKey);
		if(StringUtils.isEmpty(path))
			throw new BadRequestAlertException("未找到待办任务处理页","","");

		return ResponseEntity.status(HttpStatus.OK).body(path);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deploybpmn")
	public ResponseEntity<Boolean> deployBpmnFile(@RequestBody List<Map<String,Object>> bpmnfiles){
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.wfdeploybpmns(bpmnfiles));
	}

	@ApiOperation(value = "withDraw", tags = {"withDraw" },  notes = "根据实例将流程撤回前一步")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/withdraw")
	public ResponseEntity<Boolean> withDraw(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											@RequestBody WFTaskWay taskWay){
		taskWay.setTaskid(taskId);
		return ResponseEntity.ok(wfCoreService.withDraw(system,appname,entity,businessKey,taskWay));
	}

	@ApiOperation(value = "dataAccessMode", tags = {"流程跳转" },  notes = "流程跳转")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-{entity}/{businessKey}/process-instances/{processInstanceId}/jump")
	public ResponseEntity<Boolean> jump(@PathVariable("system") String system,
										@PathVariable("entity") String entity,
										@PathVariable("businessKey") String businessKey,@PathVariable("processInstanceId") String processInstanceId,
										@RequestBody WFProcessInstance instance) {
		instance.setId(processInstanceId);
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.jump(system,entity,businessKey,instance));
	}

	@ApiOperation(value = "restartwf", tags = {"重启流程" },  notes = "重启流程")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-{entity}/{businessKey}/process-instances/{processInstanceId}/restart")
	public ResponseEntity<Boolean> restart(@PathVariable("system") String system,
										   @PathVariable("entity") String entity,
										   @PathVariable("businessKey") String businessKey, @PathVariable("processInstanceId") String processInstanceId,
										   @RequestBody WFProcessInstance instance) {
		instance.setId(processInstanceId);
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.restart(system,entity,businessKey,instance));
	}

	@ApiOperation(value = "前加签任务", tags = {"工作流前加签任务" } ,notes = "前加签任务")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/beforesign")
	public ResponseEntity<Boolean> beforeSign(@PathVariable("system") String system,@PathVariable("appname") String appname,
											  @PathVariable("entity") String entity,
											  @PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											  @RequestBody WFTaskWay taskWay) {
		taskWay.setTaskid(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.beforeSign(system,appname,entity,businessKey,taskWay));
	}

	@ApiOperation(value = "转办任务", tags = {"工作流转办任务" },  notes = "转办任务")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/transfer")
	public ResponseEntity<Boolean> reassign(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											@RequestBody WFTaskWay taskWay) {
		taskWay.setTaskid(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.reassign(system,appname,entity,businessKey,taskWay));
	}

	@ApiOperation(value = "将文件抄送给选定人员", tags = {"将文件抄送给选定人员" } ,notes = "将文件抄送给选定人员")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/sendcopy")
	public ResponseEntity<Boolean> sendCopy(@PathVariable("system") String system,@PathVariable("appname") String appname,
											@PathVariable("entity") String entity,
											@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
											@RequestBody WFTaskWay taskWay) {
		taskWay.setTaskid(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.sendCopy(system,appname,entity,businessKey,taskWay));
	}


	/**
	 * 将流程表单设置到响应头中
	 */
	private HttpHeaders getHeader() {
		Object objReq= RequestContextHolder.currentRequestAttributes();
		HttpHeaders headers=new HttpHeaders();
		if(!ObjectUtils.isEmpty(objReq) && objReq instanceof ServletRequestAttributes){
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest req = attr.getRequest();
			Object form=req.getAttribute(formTag);
			Object mobForm=req.getAttribute(mobFormTag);
			if(!ObjectUtils.isEmpty(form))
				headers.set(formTag,String.valueOf(form));
			if(!ObjectUtils.isEmpty(mobForm))
				headers.set(mobFormTag,String.valueOf(mobForm));
		}
		return headers;
	}

}
