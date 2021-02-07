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
import cn.ibizlab.core.ou.domain.SysTeam;
import cn.ibizlab.core.ou.filter.SysTeamSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysTeam] 服务对象接口
 */
@Component
public class SysTeamFallback implements SysTeamFeignClient {

    public Page<SysTeam> select() {
        return null;
    }

    public SysTeam create(SysTeam systeam) {
        return null;
    }
    public Boolean createBatch(List<SysTeam> systeams) {
        return false;
    }

    public SysTeam update(String teamid, SysTeam systeam) {
        return null;
    }
    public Boolean updateBatch(List<SysTeam> systeams) {
        return false;
    }


    public Boolean remove(String teamid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysTeam get(String teamid) {
        return null;
    }


    public SysTeam getDraft(SysTeam entity){
        return null;
    }



    public Boolean checkKey(SysTeam systeam) {
        return false;
    }


    public Object saveEntity(SysTeam systeam) {
        return null;
    }

    public Boolean save(SysTeam systeam) {
        return false;
    }
    public Boolean saveBatch(List<SysTeam> systeams) {
        return false;
    }

    public Page<SysTeam> searchDefault(SysTeamSearchContext context) {
        return null;
    }


}
