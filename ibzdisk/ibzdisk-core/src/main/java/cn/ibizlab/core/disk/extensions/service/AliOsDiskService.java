package cn.ibizlab.core.disk.extensions.service;

import cn.ibizlab.core.disk.extensions.vo.FileItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Primary
@Slf4j
@Service
@ConditionalOnExpression("${ibiz.aliOsdisk:false}")
public class AliOsDiskService extends DiskCoreService{
    @Override
    public FileItem saveFile(String folder, String fileId, String ownerType, String ownerId, MultipartFile multipartFile) {
        return super.saveFile(folder,fileId,ownerType,ownerId,multipartFile);
    }
}
