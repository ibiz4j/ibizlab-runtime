package cn.ibizlab.core.workflow.extensions.listener;

import cn.ibizlab.core.workflow.extensions.domain.FlowUser;
import cn.ibizlab.core.workflow.extensions.service.WFModelService;
import cn.ibizlab.util.service.RemoteService;
import lombok.extern.slf4j.Slf4j;

import org.flowable.common.engine.api.delegate.event.*;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.impl.event.FlowableEntityEventImpl;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.event.impl.FlowableActivityEventImpl;
import org.flowable.engine.delegate.event.impl.FlowableEntityWithVariablesEventImpl;
import org.flowable.engine.delegate.event.impl.FlowableProcessStartedEventImpl;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class ProcessInstanceListener implements FlowableEventListener {


    @Autowired
    @Lazy
    private WFModelService wfModelService;

    @Autowired
    @Lazy
    private RemoteService remoteService;

    @Autowired
    @Lazy
    private TaskService taskService;


    @Override
    public void onEvent(FlowableEvent evt) {

        if(evt instanceof FlowableEntityWithVariablesEventImpl)
        {
            FlowableEntityWithVariablesEventImpl event = (FlowableEntityWithVariablesEventImpl) evt;
            if(event.getType() == FlowableEngineEventType.TASK_COMPLETED)
            {
                TaskEntity taskEntity = (TaskEntity)event.getEntity();
                if(taskEntity.getTaskDefinitionKey().startsWith("tid-"))
                {
                    Object data=taskEntity.getVariable("activedata");
                    Object link=taskEntity.getVariable("sequenceFlowName");

                    if(data!=null&&(data instanceof Map)&&link!=null)
                    {
                        Map activedata=(Map)data;
                        String srfwfmemo="";
                        if(activedata.get("srfwfmemo")!=null)
                            srfwfmemo=activedata.get("srfwfmemo").toString();
                        taskService.addComment(taskEntity.getId(),taskEntity.getProcessInstanceId(),link.toString(),srfwfmemo);
                    }
                }
            }
        }
        else if(evt instanceof FlowableProcessStartedEventImpl)
        {
            FlowableProcessStartedEventImpl event=(FlowableProcessStartedEventImpl)evt;
            if(event.getEntity() instanceof ExecutionEntityImpl){
                ExecutionEntityImpl executionEntity= (ExecutionEntityImpl) event.getEntity();
                if(executionEntity.getVariable("cloud-serviceid")==null)
                    return;
                String businessKey=(String)executionEntity.getVariable("businessKey");
                //HashMap curUser=(HashMap) executionEntity.getVariable("curuser");
                FlowUser curUser=FlowUser.getCurUser();
                String entity=executionEntity.getVariable("entitys").toString();
                String cloudServiceid=executionEntity.getVariable("cloud-serviceid").toString();
                Map setting=wfModelService.getProcessGlobalSetting(executionEntity.getProcessDefinitionId());
                String wfstepfield="";
                if(setting.containsKey("wfstepfield"+"_"+entity))
                    wfstepfield=setting.get("wfstepfield"+"_"+entity).toString();
                String wfinstfield="";
                if(setting.containsKey("wfinstfield"+"_"+entity))
                    wfinstfield=setting.get("wfinstfield"+"_"+entity).toString();
                String udstatefield="";
                if(setting.containsKey("udstatefield"+"_"+entity))
                    udstatefield=setting.get("udstatefield"+"_"+entity).toString();
                String wfstatefield="";
                if(setting.containsKey("wfstatefield"+"_"+entity))
                    wfstatefield=setting.get("wfstatefield"+"_"+entity).toString();
                String wfverfield="";
                if(setting.containsKey("wfverfield"+"_"+entity))
                    wfverfield=setting.get("wfverfield"+"_"+entity).toString();
                String majortext_field="";
                if(setting.containsKey("majortext"+"_"+entity))
                {
                    majortext_field = setting.get("majortext" + "_" + entity).toString();
                    Object activedata=executionEntity.getVariable("activedata");
                    if(activedata!=null)
                        executionEntity.setVariable("majortext",((Map)activedata).get(majortext_field));
                }
                executionEntity.setVariable("wfstepfield",wfstepfield);
                executionEntity.setVariable("wfinstfield",wfinstfield);
                executionEntity.setVariable("udstatefield",udstatefield);
                executionEntity.setVariable("wfstatefield",wfstatefield);
                executionEntity.setVariable("wfverfield",wfverfield);
                executionEntity.setVariable("majortextfield",majortext_field);

                Map callbackArg=new LinkedHashMap();
                if(!StringUtils.isEmpty(wfinstfield))
                    callbackArg.put(wfinstfield,executionEntity.getProcessInstanceId());
                if(!StringUtils.isEmpty(wfstatefield))
                    callbackArg.put(wfstatefield,1);
                if(!StringUtils.isEmpty(udstatefield))
                    callbackArg.put(udstatefield,"20");
                if((!StringUtils.isEmpty(wfverfield))&&(executionEntity.getVariable("wfversion")!=null))
                    callbackArg.put(wfverfield,Integer.parseInt(executionEntity.getVariable("wfversion").toString()));

                if(callbackArg.size()>0) {
                    if(StringUtils.isEmpty(curUser.getToken()))
                        return;
                    String token=curUser.getToken();
                    remoteService.getClient(cloudServiceid).put(entity + "/" + businessKey, token,callbackArg);
                }
            }
        }
        else if(evt instanceof FlowableEntityEventImpl)
        {
            FlowableEntityEventImpl event=((FlowableEntityEventImpl) evt);
            FlowableEventType eventType = event.getType();
            if(eventType == FlowableEngineEventType.PROCESS_COMPLETED){
                ExecutionEntityImpl executionEntity= (ExecutionEntityImpl) event.getEntity();
                if(executionEntity.getVariable("cloud-serviceid")==null)
                    return;
                String businessKey=(String)executionEntity.getVariable("businessKey");
                //HashMap curUser=(HashMap) executionEntity.getVariable("curuser");
                FlowUser curUser=FlowUser.getCurUser();
                String entity=executionEntity.getVariable("entitys").toString();
                String cloudServiceid=executionEntity.getVariable("cloud-serviceid").toString();
                String wfstepfield = executionEntity.getVariable("wfstepfield").toString();
                String udstatefield = executionEntity.getVariable("udstatefield").toString();
                String wfstate = executionEntity.getVariable("wfstate").toString();
                Map callbackArg=new LinkedHashMap();
                if(!StringUtils.isEmpty(wfstate))
                    callbackArg.put(wfstate,2);
                if(!StringUtils.isEmpty(udstatefield))
                    callbackArg.put(udstatefield,"30");
                if(!StringUtils.isEmpty(wfstepfield))
                    callbackArg.put(wfstepfield,"");
                if(callbackArg.size()>0) {
                    if(StringUtils.isEmpty(curUser.getToken()))
                        return;
                    String token=curUser.getToken();
                    remoteService.getClient(cloudServiceid).put(entity + "/" + businessKey, token,callbackArg);
                }
                System.out.println("流程结束");
            }
            if(eventType == FlowableEngineEventType.PROCESS_COMPLETED_WITH_ERROR_END_EVENT){
                event.getEntity();
                System.out.println("流程异常结束");
            }
        }
        else if(evt instanceof FlowableActivityEventImpl)
        {
            FlowableActivityEventImpl event=((FlowableActivityEventImpl) evt);
            FlowableEventType eventType = event.getType();
            if(eventType == FlowableEngineEventType.ACTIVITY_STARTED && "userTask".equals(event.getActivityType())){
                if(event.getExecution().getVariable("cloud-serviceid")==null)
                    return;
                String businessKey=(String)event.getExecution().getVariable("businessKey");
                //HashMap curUser=(HashMap) event.getExecution().getVariable("curuser");
                FlowUser curUser=FlowUser.getCurUser();
                String entity=event.getExecution().getVariable("entitys").toString();
                String cloudServiceid=event.getExecution().getVariable("cloud-serviceid").toString();
                String wfstepfield = event.getExecution().getVariable("wfstepfield").toString();
                Map callbackArg=new LinkedHashMap();
                if(!StringUtils.isEmpty(wfstepfield)&&event.getActivityId().startsWith("tid-"))
                    callbackArg.put(wfstepfield,event.getActivityId().split("-")[1]);
                if(callbackArg.size()>0) {
                    if(StringUtils.isEmpty(curUser.getToken()))
                        return;
                    String token=curUser.getToken();
                    remoteService.getClient(cloudServiceid).put(entity + "/" + businessKey, token,callbackArg);
                }
            }
        }

    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}