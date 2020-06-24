package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.workflow.domain.*;
import cn.ibizlab.core.workflow.extensions.service.WFCoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = {"wfcore" })
@RestController("api-wfcore")
@RequestMapping("")
public class WFCoreResource
{

    @Autowired
    private WFCoreService wfCoreService;


    @ApiOperation(value = "getWFProcessDefinition", tags = {"WFProcessDefinition" },  notes = "根据系统实体查找当前适配的工作流模型")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions")
    public ResponseEntity<List<WFProcessDefinition>> getworkflow(@PathVariable("system") String system,@PathVariable("appname") String appname,
			@PathVariable("entity") String entity) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

	@ApiOperation(value = "getStepByEntity", tags = {"WFProcessNode" },  notes = "根据系统实体查找当前适配的工作流模型步骤")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/process-definitions-nodes")
	public ResponseEntity<List<WFProcessNode>> getwfstep(@PathVariable("system") String system,@PathVariable("appname") String appname,
			@PathVariable("entity") String entity) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getWFStep(system,appname,entity));
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
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getWFLink(system,appname,entity,businessKey,taskDefinitionKey));
	}

	@ApiOperation(value = "getWayByTaskId", tags = {"WFTaskWay" },  notes = "根据业务主键和当前步骤获取操作路径")
	@RequestMapping(method = RequestMethod.GET, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}/ways")
	public ResponseEntity<List<WFTaskWay>> gettasklink(@PathVariable("system") String system,@PathVariable("appname") String appname,
			@PathVariable("entity") String entity,
			@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId) {
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.getTaskLink(system,appname,entity,businessKey,taskId));
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
	@ApiOperation(value = "wfsubmit", tags = {"WFProcessInstance" },  notes = "工作流执行步骤")
	@RequestMapping(method = RequestMethod.POST, value = "/{system}-app-{appname}/{entity}/{businessKey}/tasks/{taskId}")
	public ResponseEntity<WFProcessInstance> wfsubmit(@PathVariable("system") String system,@PathVariable("appname") String appname,
			@PathVariable("entity") String entity,
			@PathVariable("businessKey") String businessKey,@PathVariable("taskId") String taskId,
			@RequestBody WFTaskWay taskWay) {
		WFProcessInstance instance = new WFProcessInstance();
		return ResponseEntity.ok(wfCoreService.wfsubmit(system,appname,entity,businessKey,taskId,taskWay));
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

	@RequestMapping(method = RequestMethod.POST, value = "/deploybpmn")
	public ResponseEntity<Boolean> deployBpmnFile(@RequestBody List<Map<String,Object>> bpmnfiles){
		return ResponseEntity.status(HttpStatus.OK).body(wfCoreService.wfdeploybpmns(bpmnfiles));
	}

}
