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
import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[IBZPost] 服务对象接口
 */
@Component
public class IBZPostFallback implements IBZPostFeignClient{

    public Page<IBZPost> select(){
            return null;
     }

    public IBZPost create(IBZPost ibzpost){
            return null;
     }
    public Boolean createBatch(List<IBZPost> ibzposts){
            return false;
     }

    public IBZPost update(String postid, IBZPost ibzpost){
            return null;
     }
    public Boolean updateBatch(List<IBZPost> ibzposts){
            return false;
     }


    public Boolean remove(String postid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZPost get(String postid){
            return null;
     }


    public IBZPost getDraft(){
            return null;
    }



    public Boolean checkKey(IBZPost ibzpost){
            return false;
     }


    public Boolean save(IBZPost ibzpost){
            return false;
     }
    public Boolean saveBatch(List<IBZPost> ibzposts){
            return false;
     }

    public Page<IBZPost> searchDefault(IBZPostSearchContext context){
            return null;
     }


}
