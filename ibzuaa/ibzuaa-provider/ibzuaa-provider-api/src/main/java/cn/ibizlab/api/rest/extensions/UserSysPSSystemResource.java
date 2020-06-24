package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.SysPSSystemDTO;
import cn.ibizlab.api.rest.SysPSSystemResource;
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserSysPSSystemResource extends SysPSSystemResource {

    @Override
    public ResponseEntity<Boolean> save(@RequestBody  SysPSSystemDTO syspssystemdto) {
        SysPSSystem system = syspssystemService.get(syspssystemdto.getPssystemid());
        if( !StringUtils.isEmpty(system.getMd5check()) && system.getMd5check().equals(syspssystemdto.getMd5check())){
            log.warn(String.format("[%s]系统资源没有变化，忽略本次同步请求:",syspssystemdto.getPssystemid()));
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        else{
            return super.save(syspssystemdto);
        }
    }
}
