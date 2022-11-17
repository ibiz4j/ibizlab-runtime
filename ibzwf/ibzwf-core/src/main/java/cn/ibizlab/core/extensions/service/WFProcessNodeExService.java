package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.extensions.service.WFModelService;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import cn.ibizlab.core.workflow.service.impl.WFProcessNodeServiceImpl;
import org.flowable.bpmn.model.UserTask;
import org.flowable.ui.common.service.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Primary
@Service("WFProcessNodeExService")
public class WFProcessNodeExService extends WFProcessNodeServiceImpl {

    @Autowired
    WFModelService modelService;

    @Override
    public Page<WFProcessNode> searchProcessNode(WFProcessNodeSearchContext context) {
        String processDefinitionId = context.getN_definitionid_eq();
        if(StringUtils.isEmpty(processDefinitionId)){
            throw new BadRequestException("为传入流程定义标识");
        }

        List<WFProcessNode> processNodes = new ArrayList<>();
        LinkedHashMap<String, UserTask> userTasks =  modelService.getModelStepById(processDefinitionId);
        if(!ObjectUtils.isEmpty(userTasks)){
            for(Map.Entry<String,UserTask> entry : userTasks.entrySet()){
                String userTaskId = entry.getKey();
                UserTask userTask = entry.getValue();

                WFProcessNode node = new WFProcessNode();
                node.setUsertaskid(userTaskId);
                node.setUsertaskname(userTask.getName());
                node.setProcessdefinitionkey(processDefinitionId);
//                node.setProcessdefinitionname(instance.getProcessdefinitionname());
                processNodes.add(node);
            }
        }

        return new PageImpl<WFProcessNode>(processNodes,context.getPageable(),processNodes.size());
    }

}
