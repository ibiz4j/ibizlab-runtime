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
import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.core.ou.filter.IBZTeamSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZTeam] 服务对象接口
 */
@Component
public class IBZTeamFallback implements IBZTeamFeignClient{

    public Page<IBZTeam> select(){
            return null;
     }

    public Boolean checkKey(IBZTeam ibzteam){
            return false;
     }


    public IBZTeam create(IBZTeam ibzteam){
            return null;
     }
    public Boolean createBatch(List<IBZTeam> ibzteams){
            return false;
     }

    public IBZTeam update(String teamid, IBZTeam ibzteam){
            return null;
     }
    public Boolean updateBatch(List<IBZTeam> ibzteams){
            return false;
     }


    public Boolean remove(String teamid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZTeam get(String teamid){
            return null;
     }


    public Boolean save(IBZTeam ibzteam){
            return false;
     }
    public Boolean saveBatch(List<IBZTeam> ibzteams){
            return false;
     }

    public IBZTeam getDraft(){
            return null;
    }



    public Page<IBZTeam> searchDefault(IBZTeamSearchContext context){
            return null;
     }


}
