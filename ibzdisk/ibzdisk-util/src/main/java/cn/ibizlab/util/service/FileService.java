package cn.ibizlab.util.service;

import cn.ibizlab.util.domain.FileItem;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

public interface FileService
{
    FileItem saveFile(MultipartFile multipartFile);
    File getFile(String fileid);
}