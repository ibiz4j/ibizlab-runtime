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
import cn.ibizlab.core.ou.domain.SysPost;
import cn.ibizlab.core.ou.filter.SysPostSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysPost] 服务对象接口
 */
@Component
public class SysPostFallback implements SysPostFeignClient {

    public SysPost create(SysPost syspost) {
        return null;
    }
    public Boolean createBatch(List<SysPost> sysposts) {
        return false;
    }

    public SysPost get(String postid) {
        return null;
    }


    public Boolean remove(String postid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysPost update(String postid, SysPost syspost) {
        return null;
    }
    public Boolean updateBatch(List<SysPost> sysposts) {
        return false;
    }


    public Boolean checkKey(SysPost syspost) {
        return false;
    }


    public Page<SysPost> searchDefault(SysPostSearchContext context) {
        return null;
    }


    public SysPost getDraft(SysPost entity){
        return null;
    }



    public Object saveEntity(SysPost syspost) {
        return null;
    }

    public Boolean save(SysPost syspost) {
        return false;
    }
    public Boolean saveBatch(List<SysPost> sysposts) {
        return false;
    }

    public Page<SysPost> select() {
        return null;
    }

}
