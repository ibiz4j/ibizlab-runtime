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
import cn.ibizlab.core.dict.domain.IBZDict;
import cn.ibizlab.core.dict.filter.IBZDictSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZDict] 服务对象接口
 */
@Component
public class IBZDictFallback implements IBZDictFeignClient{

    public Page<IBZDict> select(){
            return null;
     }

    public IBZDict create(IBZDict ibzdict){
            return null;
     }
    public Boolean createBatch(List<IBZDict> ibzdicts){
            return false;
     }

    public Boolean remove(String dictid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZDict update(String dictid, IBZDict ibzdict){
            return null;
     }
    public Boolean updateBatch(List<IBZDict> ibzdicts){
            return false;
     }


    public IBZDict getDraft(){
            return null;
    }



    public Boolean save(IBZDict ibzdict){
            return false;
     }
    public Boolean saveBatch(List<IBZDict> ibzdicts){
            return false;
     }

    public IBZDict get(String dictid){
            return null;
     }


    public Boolean checkKey(IBZDict ibzdict){
            return false;
     }


    public Page<IBZDict> searchDefault(IBZDictSearchContext context){
            return null;
     }


}
