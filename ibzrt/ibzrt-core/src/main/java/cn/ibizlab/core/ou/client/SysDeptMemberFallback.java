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
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysDeptMember] 服务对象接口
 */
@Component
public class SysDeptMemberFallback implements SysDeptMemberFeignClient{

    public Page<SysDeptMember> select(){
            return null;
     }

    public SysDeptMember create(SysDeptMember sysdeptmember){
            return null;
     }
    public Boolean createBatch(List<SysDeptMember> sysdeptmembers){
            return false;
     }

    public SysDeptMember update(String memberid, SysDeptMember sysdeptmember){
            return null;
     }
    public Boolean updateBatch(List<SysDeptMember> sysdeptmembers){
            return false;
     }


    public Boolean remove(String memberid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public SysDeptMember get(String memberid){
            return null;
     }


    public SysDeptMember getDraft(){
            return null;
    }



    public Boolean checkKey(SysDeptMember sysdeptmember){
            return false;
     }


    public Boolean save(SysDeptMember sysdeptmember){
            return false;
     }
    public Boolean saveBatch(List<SysDeptMember> sysdeptmembers){
            return false;
     }

    public Page<SysDeptMember> searchDefault(SysDeptMemberSearchContext context){
            return null;
     }


}
