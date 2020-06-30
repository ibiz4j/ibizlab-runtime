package cn.ibizlab.core.ou.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZOrganization] 服务对象接口
 */
@Component
public class IBZOrganizationFallback implements IBZOrganizationFeignClient{

    public Page<IBZOrganization> select(){
            return null;
     }

    public IBZOrganization create(IBZOrganization ibzorganization){
            return null;
     }
    public Boolean createBatch(List<IBZOrganization> ibzorganizations){
            return false;
     }

    public IBZOrganization update(String orgid, IBZOrganization ibzorganization){
            return null;
     }
    public Boolean updateBatch(List<IBZOrganization> ibzorganizations){
            return false;
     }


    public Boolean remove(String orgid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZOrganization get(String orgid){
            return null;
     }


    public IBZOrganization getDraft(){
            return null;
    }



    public Boolean checkKey(IBZOrganization ibzorganization){
            return false;
     }


    public Boolean save(IBZOrganization ibzorganization){
            return false;
     }
    public Boolean saveBatch(List<IBZOrganization> ibzorganizations){
            return false;
     }

    public Page<IBZOrganization> searchDefault(IBZOrganizationSearchContext context){
            return null;
     }


}
