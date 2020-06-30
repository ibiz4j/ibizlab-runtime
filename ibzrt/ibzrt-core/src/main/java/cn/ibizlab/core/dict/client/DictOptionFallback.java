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
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[DictOption] 服务对象接口
 */
@Component
public class DictOptionFallback implements DictOptionFeignClient{

    public Page<DictOption> select(){
            return null;
     }

    public DictOption create(DictOption dictoption){
            return null;
     }
    public Boolean createBatch(List<DictOption> dictoptions){
            return false;
     }

    public DictOption update(String value_key, DictOption dictoption){
            return null;
     }
    public Boolean updateBatch(List<DictOption> dictoptions){
            return false;
     }


    public Boolean remove(String value_key){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public DictOption get(String value_key){
            return null;
     }


    public DictOption getDraft(){
            return null;
    }



    public Boolean checkKey(DictOption dictoption){
            return false;
     }


    public Boolean save(DictOption dictoption){
            return false;
     }
    public Boolean saveBatch(List<DictOption> dictoptions){
            return false;
     }

    public Page<DictOption> searchDefault(DictOptionSearchContext context){
            return null;
     }


}
