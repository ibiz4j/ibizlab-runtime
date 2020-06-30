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
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZEmployee] 服务对象接口
 */
@Component
public class IBZEmployeeFallback implements IBZEmployeeFeignClient{

    public Page<IBZEmployee> select(){
            return null;
     }

    public IBZEmployee create(IBZEmployee ibzemployee){
            return null;
     }
    public Boolean createBatch(List<IBZEmployee> ibzemployees){
            return false;
     }

    public IBZEmployee update(String userid, IBZEmployee ibzemployee){
            return null;
     }
    public Boolean updateBatch(List<IBZEmployee> ibzemployees){
            return false;
     }


    public Boolean remove(String userid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZEmployee get(String userid){
            return null;
     }


    public IBZEmployee getDraft(){
            return null;
    }



    public Boolean checkKey(IBZEmployee ibzemployee){
            return false;
     }


    public IBZEmployee initPwd( String userid, IBZEmployee ibzemployee){
            return null;
     }

    public Boolean save(IBZEmployee ibzemployee){
            return false;
     }
    public Boolean saveBatch(List<IBZEmployee> ibzemployees){
            return false;
     }

    public Page<IBZEmployee> searchDefault(IBZEmployeeSearchContext context){
            return null;
     }


}
