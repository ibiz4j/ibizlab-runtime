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
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZPost] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "IBZPost", fallback = IBZPostFallback.class)
public interface IBZPostFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzposts/select")
    Page<IBZPost> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts")
    IBZPost create(@RequestBody IBZPost ibzpost);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts/batch")
    Boolean createBatch(@RequestBody List<IBZPost> ibzposts);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzposts/{postid}")
    IBZPost update(@PathVariable("postid") String postid,@RequestBody IBZPost ibzpost);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzposts/batch")
    Boolean updateBatch(@RequestBody List<IBZPost> ibzposts);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzposts/{postid}")
    Boolean remove(@PathVariable("postid") String postid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzposts/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzposts/{postid}")
    IBZPost get(@PathVariable("postid") String postid);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzposts/getdraft")
    IBZPost getDraft();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts/checkkey")
    Boolean checkKey(@RequestBody IBZPost ibzpost);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts/save")
    Boolean save(@RequestBody IBZPost ibzpost);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts/save")
    Boolean saveBatch(@RequestBody List<IBZPost> ibzposts);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzposts/searchdefault")
    Page<IBZPost> searchDefault(@RequestBody IBZPostSearchContext context);


}
