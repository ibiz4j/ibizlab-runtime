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
import org.springframework.stereotype.Component;

/**
 * 实体[SDFile] 服务对象接口
 */
@Component
public class SDFileFallback implements SDFileFeignClient {

    public Page<SDFile> select() {
        return null;
    }

    public SDFile create(SDFile sdfile) {
        return null;
    }
    public Boolean createBatch(List<SDFile> sdfiles) {
        return false;
    }

    public SDFile update(String id, SDFile sdfile) {
        return null;
    }
    public Boolean updateBatch(List<SDFile> sdfiles) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SDFile get(String id) {
        return null;
    }


    public SDFile getDraft(SDFile entity){
        return null;
    }



    public Boolean checkKey(SDFile sdfile) {
        return false;
    }


    public Boolean save(SDFile sdfile) {
        return false;
    }
    public Boolean saveBatch(List<SDFile> sdfiles) {
        return false;
    }

    public Page<SDFile> searchDefault(SDFileSearchContext context) {
        return null;
    }


}
