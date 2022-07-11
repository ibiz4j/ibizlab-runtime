package cn.ibizlab.core.notify.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[MsgTemplate] 服务对象接口
 */
@Component
public class MsgTemplateFallback implements MsgTemplateFeignClient {

    public MsgTemplate create(MsgTemplate msgtemplate) {
        return null;
    }
    public Boolean createBatch(List<MsgTemplate> msgtemplates) {
        return false;
    }

    public MsgTemplate get(String tid) {
        return null;
    }


    public Boolean remove(String tid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public MsgTemplate update(String tid, MsgTemplate msgtemplate) {
        return null;
    }
    public Boolean updateBatch(List<MsgTemplate> msgtemplates) {
        return false;
    }


    public Boolean checkKey(MsgTemplate msgtemplate) {
        return false;
    }


    public Page<MsgTemplate> searchDefault(MsgTemplateSearchContext context) {
        return null;
    }


    public MsgTemplate getDraft(MsgTemplate entity){
        return null;
    }



    public Object saveEntity(MsgTemplate msgtemplate) {
        return null;
    }

    public Boolean save(MsgTemplate msgtemplate) {
        return false;
    }
    public Boolean saveBatch(List<MsgTemplate> msgtemplates) {
        return false;
    }

    public Page<MsgTemplate> select() {
        return null;
    }

}
