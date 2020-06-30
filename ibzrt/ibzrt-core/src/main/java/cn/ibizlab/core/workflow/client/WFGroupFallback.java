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
import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFGroup] 服务对象接口
 */
@Component
public class WFGroupFallback implements WFGroupFeignClient{

    public Page<WFGroup> select(){
            return null;
     }

    public WFGroup create(WFGroup wfgroup){
            return null;
     }
    public Boolean createBatch(List<WFGroup> wfgroups){
            return false;
     }

    public WFGroup update(String id, WFGroup wfgroup){
            return null;
     }
    public Boolean updateBatch(List<WFGroup> wfgroups){
            return false;
     }


    public Boolean remove(String id){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public WFGroup get(String id){
            return null;
     }


    public WFGroup getDraft(){
            return null;
    }



    public Boolean checkKey(WFGroup wfgroup){
            return false;
     }


    public Boolean save(WFGroup wfgroup){
            return false;
     }
    public Boolean saveBatch(List<WFGroup> wfgroups){
            return false;
     }

    public Page<WFGroup> searchDefault(WFGroupSearchContext context){
            return null;
     }


}
