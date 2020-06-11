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
import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.filter.WFSystemSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFSystem] 服务对象接口
 */
@Component
public class WFSystemFallback implements WFSystemFeignClient{

    public Page<WFSystem> select(){
            return null;
     }

    public Boolean save(WFSystem wfsystem){
            return false;
     }
    public Boolean saveBatch(List<WFSystem> wfsystems){
            return false;
     }

    public Boolean remove(String pssystemid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public WFSystem get(String pssystemid){
            return null;
     }


    public WFSystem getDraft(){
            return null;
    }



    public WFSystem create(WFSystem wfsystem){
            return null;
     }
    public Boolean createBatch(List<WFSystem> wfsystems){
            return false;
     }

    public Boolean checkKey(WFSystem wfsystem){
            return false;
     }


    public WFSystem update(String pssystemid, WFSystem wfsystem){
            return null;
     }
    public Boolean updateBatch(List<WFSystem> wfsystems){
            return false;
     }


    public Page<WFSystem> searchDefault(WFSystemSearchContext context){
            return null;
     }


}
