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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZTeamMember] 服务对象接口
 */
@Component
public class IBZTeamMemberFallback implements IBZTeamMemberFeignClient{

    public Page<IBZTeamMember> select(){
            return null;
     }

    public IBZTeamMember create(IBZTeamMember ibzteammember){
            return null;
     }
    public Boolean createBatch(List<IBZTeamMember> ibzteammembers){
            return false;
     }

    public IBZTeamMember update(String teammemberid, IBZTeamMember ibzteammember){
            return null;
     }
    public Boolean updateBatch(List<IBZTeamMember> ibzteammembers){
            return false;
     }


    public Boolean remove(String teammemberid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZTeamMember get(String teammemberid){
            return null;
     }


    public IBZTeamMember getDraft(){
            return null;
    }



    public Boolean checkKey(IBZTeamMember ibzteammember){
            return false;
     }


    public Boolean save(IBZTeamMember ibzteammember){
            return false;
     }
    public Boolean saveBatch(List<IBZTeamMember> ibzteammembers){
            return false;
     }

    public Page<IBZTeamMember> searchDefault(IBZTeamMemberSearchContext context){
            return null;
     }


}
