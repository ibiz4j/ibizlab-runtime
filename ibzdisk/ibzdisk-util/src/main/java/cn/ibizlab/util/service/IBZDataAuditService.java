package cn.ibizlab.util.service;

import cn.ibizlab.util.annotation.Audit;
import cn.ibizlab.util.domain.EntityBase;
import org.springframework.scheduling.annotation.Async;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 实体[DataAudit] 服务对象接口
 */
public interface IBZDataAuditService {
    @Async("asyncExecutor")
    void createAudit(HttpServletRequest request, EntityBase entity, Object idValue, Map<String, Audit> auditFields);
    @Async("asyncExecutor")
    void updateAudit(HttpServletRequest request, EntityBase beforeEntity, Object serviceObj, Object idValue, Map<String, Audit> auditFields);
    @Async("asyncExecutor")
    void removeAudit(HttpServletRequest request, EntityBase entity, Object idValue, Map<String, Audit> auditFields);
}