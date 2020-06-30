package cn.ibizlab.api.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[SDFileDTO]
 */
@Data
public class SDFileDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [FILEID]
     *
     */
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 属性 [FILENAME]
     *
     */
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 属性 [FILEPATH]
     *
     */
    @JSONField(name = "file_path")
    @JsonProperty("file_path")
    private String filePath;

    /**
     * 属性 [FOLDER]
     *
     */
    @JSONField(name = "folder")
    @JsonProperty("folder")
    private String folder;

    /**
     * 属性 [FILESIZE]
     *
     */
    @JSONField(name = "file_size")
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * 属性 [FILEEXT]
     *
     */
    @JSONField(name = "extension")
    @JsonProperty("extension")
    private String extension;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    private String ownerType;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    private String ownerId;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [DIGESTCODE]
     *
     */
    @JSONField(name = "digest_code")
    @JsonProperty("digest_code")
    private String digestCode;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;


    /**
     * 设置 [FILENAME]
     */
    public void setName(String  name){
        this.name = name ;
        this.modify("filename",name);
    }

    /**
     * 设置 [FILEPATH]
     */
    public void setFilePath(String  filePath){
        this.filePath = filePath ;
        this.modify("filepath",filePath);
    }

    /**
     * 设置 [FOLDER]
     */
    public void setFolder(String  folder){
        this.folder = folder ;
        this.modify("folder",folder);
    }

    /**
     * 设置 [FILESIZE]
     */
    public void setFileSize(Integer  fileSize){
        this.fileSize = fileSize ;
        this.modify("filesize",fileSize);
    }

    /**
     * 设置 [FILEEXT]
     */
    public void setExtension(String  extension){
        this.extension = extension ;
        this.modify("fileext",extension);
    }

    /**
     * 设置 [OWNERTYPE]
     */
    public void setOwnerType(String  ownerType){
        this.ownerType = ownerType ;
        this.modify("ownertype",ownerType);
    }

    /**
     * 设置 [OWNERID]
     */
    public void setOwnerId(String  ownerId){
        this.ownerId = ownerId ;
        this.modify("ownerid",ownerId);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [DIGESTCODE]
     */
    public void setDigestCode(String  digestCode){
        this.digestCode = digestCode ;
        this.modify("digestcode",digestCode);
    }


}

