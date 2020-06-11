package cn.ibizlab.core.dict.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.dict.domain.IBZDictItem;
import cn.ibizlab.core.dict.filter.IBZDictItemSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZDictItem] 服务对象接口
 */
@Component
public class IBZDictItemFallback implements IBZDictItemFeignClient{

    public Page<IBZDictItem> select(){
            return null;
     }

    public IBZDictItem update(String itemid, IBZDictItem ibzdictitem){
            return null;
     }
    public Boolean updateBatch(List<IBZDictItem> ibzdictitems){
            return false;
     }


    public Boolean checkKey(IBZDictItem ibzdictitem){
            return false;
     }


    public Boolean save(IBZDictItem ibzdictitem){
            return false;
     }
    public Boolean saveBatch(List<IBZDictItem> ibzdictitems){
            return false;
     }

    public Boolean remove(String itemid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZDictItem get(String itemid){
            return null;
     }


    public IBZDictItem create(IBZDictItem ibzdictitem){
            return null;
     }
    public Boolean createBatch(List<IBZDictItem> ibzdictitems){
            return false;
     }

    public IBZDictItem getDraft(){
            return null;
    }



    public Page<IBZDictItem> searchDefault(IBZDictItemSearchContext context){
            return null;
     }


}
