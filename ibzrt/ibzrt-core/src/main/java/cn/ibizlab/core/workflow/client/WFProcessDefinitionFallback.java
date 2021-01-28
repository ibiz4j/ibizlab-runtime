package cn.ibizlab.core.workflow.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFProcessDefinition] 服务对象接口
 */
@Component
public class WFProcessDefinitionFallback implements WFProcessDefinitionFeignClient {

    public Page<WFProcessDefinition> select() {
        return null;
    }

    public WFProcessDefinition create(WFProcessDefinition wfprocessdefinition) {
        return null;
    }
    public Boolean createBatch(List<WFProcessDefinition> wfprocessdefinitions) {
        return false;
    }

    public WFProcessDefinition update(String definitionkey, WFProcessDefinition wfprocessdefinition) {
        return null;
    }
    public Boolean updateBatch(List<WFProcessDefinition> wfprocessdefinitions) {
        return false;
    }


    public Boolean remove(String definitionkey) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFProcessDefinition get(String definitionkey) {
        return null;
    }


    public WFProcessDefinition getDraft(WFProcessDefinition entity){
        return null;
    }



    public Boolean checkKey(WFProcessDefinition wfprocessdefinition) {
        return false;
    }


    public Boolean save(WFProcessDefinition wfprocessdefinition) {
        return false;
    }
    public Boolean saveBatch(List<WFProcessDefinition> wfprocessdefinitions) {
        return false;
    }

    public Page<WFProcessDefinition> searchDefault(WFProcessDefinitionSearchContext context) {
        return null;
    }


}
