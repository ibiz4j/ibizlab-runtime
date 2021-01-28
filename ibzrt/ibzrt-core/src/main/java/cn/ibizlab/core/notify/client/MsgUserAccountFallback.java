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
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.filter.MsgUserAccountSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[MsgUserAccount] 服务对象接口
 */
@Component
public class MsgUserAccountFallback implements MsgUserAccountFeignClient {

    public Page<MsgUserAccount> select() {
        return null;
    }

    public MsgUserAccount create(MsgUserAccount msguseraccount) {
        return null;
    }
    public Boolean createBatch(List<MsgUserAccount> msguseraccounts) {
        return false;
    }

    public MsgUserAccount update(String id, MsgUserAccount msguseraccount) {
        return null;
    }
    public Boolean updateBatch(List<MsgUserAccount> msguseraccounts) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public MsgUserAccount get(String id) {
        return null;
    }


    public MsgUserAccount getDraft(MsgUserAccount entity){
        return null;
    }



    public Boolean checkKey(MsgUserAccount msguseraccount) {
        return false;
    }


    public Boolean save(MsgUserAccount msguseraccount) {
        return false;
    }
    public Boolean saveBatch(List<MsgUserAccount> msguseraccounts) {
        return false;
    }

    public Page<MsgUserAccount> searchDefault(MsgUserAccountSearchContext context) {
        return null;
    }


}
