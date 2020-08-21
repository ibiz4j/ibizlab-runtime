package cn.ibizlab.core.disk.extensions.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Slf4j
@Service
public class FileCoreService {

    @Cacheable( value="file",key = "'authcode:'+#p0")
    public String getAuthCode(String fileId)
    {
        return IdWorker.getIdStr();
    }
}
