package cn.ibizlab.core.disk.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.filter.SDFileSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SDFile] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzdisk-api:ibzdisk-api}", contextId = "SDFile", fallback = SDFileFallback.class)
public interface SDFileFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sdfiles/select")
    Page<SDFile> select();


    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles")
    SDFile create(@RequestBody SDFile sdfile);

    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles/batch")
    Boolean createBatch(@RequestBody List<SDFile> sdfiles);


    @RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/{id}")
    SDFile update(@PathVariable("id") String id,@RequestBody SDFile sdfile);

    @RequestMapping(method = RequestMethod.PUT, value = "/sdfiles/batch")
    Boolean updateBatch(@RequestBody List<SDFile> sdfiles);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sdfiles/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/sdfiles/{id}")
    SDFile get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/sdfiles/getdraft")
    SDFile getDraft(SDFile entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles/checkkey")
    Boolean checkKey(@RequestBody SDFile sdfile);


    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles/save")
    Boolean save(@RequestBody SDFile sdfile);

    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles/savebatch")
    Boolean saveBatch(@RequestBody List<SDFile> sdfiles);



    @RequestMapping(method = RequestMethod.POST, value = "/sdfiles/searchdefault")
    Page<SDFile> searchDefault(@RequestBody SDFileSearchContext context);


}
