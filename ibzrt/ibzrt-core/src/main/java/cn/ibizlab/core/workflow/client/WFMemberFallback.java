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
import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFMember] 服务对象接口
 */
@Component
public class WFMemberFallback implements WFMemberFeignClient {

    public Page<WFMember> select() {
        return null;
    }

    public WFMember create(WFMember wfmember) {
        return null;
    }
    public Boolean createBatch(List<WFMember> wfmembers) {
        return false;
    }

    public WFMember update(String memberid, WFMember wfmember) {
        return null;
    }
    public Boolean updateBatch(List<WFMember> wfmembers) {
        return false;
    }


    public Boolean remove(String memberid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFMember get(String memberid) {
        return null;
    }


    public WFMember getDraft(WFMember entity){
        return null;
    }



    public Boolean checkKey(WFMember wfmember) {
        return false;
    }


    public Object saveEntity(WFMember wfmember) {
        return null;
    }

    public Boolean save(WFMember wfmember) {
        return false;
    }
    public Boolean saveBatch(List<WFMember> wfmembers) {
        return false;
    }

    public Page<WFMember> searchDefault(WFMemberSearchContext context) {
        return null;
    }


}
