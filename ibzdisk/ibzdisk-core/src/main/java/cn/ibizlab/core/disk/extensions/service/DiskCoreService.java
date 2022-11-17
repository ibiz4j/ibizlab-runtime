package cn.ibizlab.core.disk.extensions.service;

import cn.ibizlab.core.disk.domain.SDFile;
import cn.ibizlab.core.disk.service.ISDFileService;
import cn.ibizlab.core.disk.extensions.vo.FileItem;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.errors.InternalServerErrorException;
import cn.ibizlab.util.helper.ZipUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipOutputStream;

@Primary
@Slf4j
@Service
@ConditionalOnExpression("!${ibiz.aliOsdisk:false}")
public class DiskCoreService {

    @Value("${ibiz.filePath:/app/file/}")
    private String fileRoot;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");

    @Autowired
    private ISDFileService sdFileService;

    @Autowired
    private FileCoreService fileCoreService;

    public FileItem saveFile(MultipartFile multipartFile)  {
        return saveFile("",multipartFile);
    }

    public FileItem saveFile(String folder,MultipartFile multipartFile)  {
        return saveFile(folder,"",multipartFile);
    }

    public FileItem saveFile(String folder,String fileId,MultipartFile multipartFile) {
        return saveFile(folder,"","","",multipartFile);
    }

    public FileItem saveFile(String folder,String fileId,String ownerType,String ownerId,MultipartFile multipartFile) {
        SDFile sdFile = new SDFile();
        if(!StringUtils.isEmpty(fileId))
            sdFile.setId(fileId);
        if(!StringUtils.isEmpty(folder))
            sdFile.setFolder(folder);
        if(!StringUtils.isEmpty(ownerId))
            sdFile.setOwnerId(ownerId);
        if(!StringUtils.isEmpty(ownerType))
            sdFile.setOwnerType(ownerType);
        String fileName = multipartFile.getOriginalFilename();
        sdFile.setName(fileName);
        int size = (int)multipartFile.getSize();
        sdFile.setFileSize(size);
        try {
            return saveFile(sdFile,multipartFile.getBytes());
        } catch (IOException e) {
            throw new InternalServerErrorException("文件上传失败");
        }
    }

    public FileItem saveFile(SDFile sdFile,byte[] multipartFile) {
        FileItem item=null;
        try {
            String fileName = sdFile.getName();
            String extension="."+getExtensionName(fileName);
            sdFile.setExtension(extension);
            String digestCode = DigestUtils.md5DigestAsHex(multipartFile);
            sdFile.setDigestCode(digestCode);
            String fileId = sdFile.getId();
            if(StringUtils.isEmpty(fileId))
            {
                fileId = simpleDateFormat.format(new Date()).concat("_").concat(IdWorker.getIdStr());
                sdFile.setId(fileId);
            }
            String folder = sdFile.getFolder();
            if(StringUtils.isEmpty(folder))
            {
                folder = "ibizutil";
                sdFile.setFolder(folder);
            }
            String filePath =  sdFile.getFilePath();
            if(StringUtils.isEmpty(filePath)) {
                filePath = folder.concat(File.separator).concat(fileId.replace("_",File.separator)).concat(File.separator).concat(fileName);
                sdFile.setFilePath(filePath);
            }

            String fileFullPath = this.fileRoot.concat(filePath);
            fileFullPath = fileFullPath.replace("\\",File.separator).replace("/",File.separator);
            File file = new File(fileFullPath);
            File parent = new File(file.getParent());
            if(!parent.exists())
                parent.mkdirs();
            FileCopyUtils.copy(multipartFile,Files.newOutputStream(file.toPath()));
            item=new FileItem(fileId,fileName,fileId,fileName,sdFile.getFileSize(),extension,fileCoreService.getAuthCode(fileId));
            sdFileService.save(sdFile);
        } catch (IOException e) {
            throw new InternalServerErrorException("文件上传失败");
        }
        return item;
    }

    public File getFile(String fileId) {
        return getFile("",fileId);
    }

    public File getFile(String folder,String fileId) {
        return getFile("",fileId,"");
    }
    public File getFile(String folder,String fileId,String authcode) {
        if(StringUtils.isEmpty(folder)||folder.equals("download"))
            folder = "ibizutil";
        if(folder.toLowerCase().startsWith("ibizutil")) {
            String dirpath = this.fileRoot.concat(folder).concat(File.separator).concat(fileId.replace("_", File.separator));
            File parent = new File(dirpath);
            if (parent.exists() && parent.isDirectory() && parent.listFiles().length > 0) {
                return parent.listFiles()[0];
            }
        }
        else if (StringUtils.isEmpty(authcode)||(!authcode.equals(fileCoreService.getAuthCode(fileId)))) {
            throw new BadRequestAlertException("没有权限下载","SDFile","");
        }
        SDFile sdFile = sdFileService.get(fileId);
        return getFile(sdFile);
    }

    public File getFile(SDFile sdFile) {
        if(!StringUtils.isEmpty(sdFile.getFilePath())){
            String fileFullPath = this.fileRoot.concat(sdFile.getFilePath());
            fileFullPath = fileFullPath.replace("\\",File.separator).replace("/",File.separator);
            File file = new File(fileFullPath);
            if(file.exists())
                return file;
        }
        throw new InternalServerErrorException("文件未找到");
    }

    /**
     * 批量下载文件 [{ "id":"fileid1"},{"id":"fileid2"}]
     * @param strCat
     * @param list
     * @return
     */
    public File getFile(String strCat, List<JsonNode> list) {

        if (ObjectUtils.isEmpty(list)) {
            throw new InternalServerErrorException("未传入文件清单");
        }

        List<File> fileList = new ArrayList<File>();
        for (JsonNode item : list) {

            if (item instanceof ObjectNode) {
                ObjectNode map = (ObjectNode) item;
                item = map.get("id");
            }
            fileList.add(this.getFile(strCat, item.asText()));
        }

        try {
            File tempFile = File.createTempFile("oss", ".zip");
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tempFile))) {
                for (File file : fileList) {
                    if (file.getParentFile() == null || file.getParentFile().getParentFile() == null) {
                        throw new Exception("文件路径不正确");
                    }
                    int nFolderLength = file.getParentFile().getParentFile().getAbsolutePath().length() + 1;
                    long nTime = System.currentTimeMillis();
                    ZipUtils.zip(file, zipOutputStream, nFolderLength);
                    log.debug(String.format("压缩文件[%1$s]耗时[%2$s]ms", file.getAbsolutePath(), System.currentTimeMillis() - nTime));
                }
                zipOutputStream.flush();
                zipOutputStream.close();
            }
            return tempFile;
        } catch (Throwable ex) {
            throw new InternalServerErrorException(String.format("生成压缩文件发生异常，%1$s", ex.getMessage()));
        }

    }

    /**
     * 批量压缩文件，压缩包内所有文件平铺展示，子目录文件重名时，通过序号区分（如：文件名.txt; 件名(1).txt )
     * @param strCat
     * @param list
     * @return
     */
    public File getFile2(String strCat, List<JsonNode> list) {

        if (ObjectUtils.isEmpty(list)) {
            throw new InternalServerErrorException("未传入文件清单");
        }

        List<File> fileList = new ArrayList<>();
        for (JsonNode item : list) {

            if (item instanceof ObjectNode) {
                ObjectNode map = (ObjectNode) item;
                item = map.get("id");
            }
            fileList.add(this.getFile(strCat, item.asText()));
        }

        try {
            Map<String ,List<File>> zipFileMap = new HashMap<>(); //压缩文件集合
            File tempFile = File.createTempFile("oss", ".zip");
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tempFile))) {
                for (File file : fileList) {
                    if (file.getParentFile() == null || file.getParentFile().getParentFile() == null) {
                        throw new Exception("文件路径不正确");
                    }
                    long nTime = System.currentTimeMillis();
                    ZipUtils.zip2(file, zipOutputStream, zipFileMap);
                    log.debug(String.format("压缩文件[%1$s]耗时[%2$s]ms", file.getAbsolutePath(), System.currentTimeMillis() - nTime));
                }
                zipOutputStream.flush();
                zipOutputStream.close();
            }
            return tempFile;
        } catch (Throwable ex) {
            throw new InternalServerErrorException(String.format("生成压缩文件发生异常，%1$s", ex.getMessage()));
        }

    }

    public File getFileById(String fileId) {
        SDFile sdFile=sdFileService.getById(fileId);
        if(sdFile!=null&&(!StringUtils.isEmpty(sdFile.getFilePath()))){
            String fileFullPath = this.fileRoot.concat(sdFile.getFilePath());
            fileFullPath = fileFullPath.replace("\\",File.separator).replace("/",File.separator);
            File file = new File(fileFullPath);
            if(file.exists())
                return file;
        }
        throw new InternalServerErrorException("文件未找到");
    }

    public List<FileItem> getFileList(String folder,String ownerType,String ownerId)
    {
        List<FileItem> fileItems = new ArrayList<>();
        sdFileService.list(Wrappers.<SDFile>lambdaQuery().eq(SDFile::getFolder,folder).eq(SDFile::getOwnerType,ownerType).eq(SDFile::getOwnerId,ownerId).orderByAsc(SDFile::getCreatedate)).forEach(item -> {
            fileItems.add(new FileItem(item.getId(),item.getName(),item.getId(),item.getName(),item.getFileSize(),item.getExtension(),fileCoreService.getAuthCode(item.getId())));
        });
        return fileItems;
    }

    public void saveFileList(String folder,String ownerType,String ownerId,List<FileItem> fileItems)
    {
        List<SDFile> sdFiles = new ArrayList<>();
        fileItems.forEach(item -> {
            SDFile sdFile = new SDFile();
            sdFile.setId(item.getId());
            sdFile.setOwnerType(ownerType);
            sdFile.setOwnerId(ownerId);
            sdFiles.add(sdFile);
        });
        sdFileService.updateBatch(sdFiles);
    }


    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public static String getExtensionName(String fileName) {
        if ((fileName != null) && (fileName.length() > 0)) {
            int dot = fileName.lastIndexOf('.');
            if ((dot >-1) && (dot < (fileName.length() - 1))) {
                return fileName.substring(dot + 1);
            }
        }
        return "";
    }

    public static String getExtensionName(File file) {
        return getExtensionName(file.getName());
    }

    public static String getHash256(File file) {
        String value = "";
        // 获取hash值
        InputStream fis = null;
        try {
            byte[] buffer = new byte[1024];
            int numRead;
            fis = new FileInputStream(file);
            //如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
            MessageDigest complete = MessageDigest.getInstance("SHA-256");
            do {
                //从文件读到buffer
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    //用读到的字节进行MD5的计算，第二个参数是偏移量
                    complete.update(buffer, 0, numRead);
                }
            } while (numRead != -1);

            value = new String(Base64.getEncoder().encode(complete.digest()));
        } catch (NoSuchAlgorithmException e) {

        }catch (IOException e) {

        }
        finally {
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }
        return value;
    }

}
