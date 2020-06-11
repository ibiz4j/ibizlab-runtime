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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZDeptMember] 服务对象接口
 */
@Component
public class IBZDeptMemberFallback implements IBZDeptMemberFeignClient{

    public Page<IBZDeptMember> select(){
            return null;
     }

    public IBZDeptMember update(String memberid, IBZDeptMember ibzdeptmember){
            return null;
     }
    public Boolean updateBatch(List<IBZDeptMember> ibzdeptmembers){
            return false;
     }


    public IBZDeptMember get(String memberid){
            return null;
     }


    public Boolean checkKey(IBZDeptMember ibzdeptmember){
            return false;
     }


    public Boolean remove(String memberid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZDeptMember create(IBZDeptMember ibzdeptmember){
            return null;
     }
    public Boolean createBatch(List<IBZDeptMember> ibzdeptmembers){
            return false;
     }

    public IBZDeptMember getDraft(){
            return null;
    }



    public Boolean save(IBZDeptMember ibzdeptmember){
            return false;
     }
    public Boolean saveBatch(List<IBZDeptMember> ibzdeptmembers){
            return false;
     }

    public Page<IBZDeptMember> searchDefault(IBZDeptMemberSearchContext context){
            return null;
     }


}
