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
    @JSONField(name = "filepath")
    @JsonProperty("filepath")
    private String filepath;

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
    @JSONField(name = "filesize")
    @JsonProperty("filesize")
    private Integer filesize;

    /**
     * 属性 [FILEEXT]
     *
     */
    @JSONField(name = "fileext")
    @JsonProperty("fileext")
    private String fileext;

    /**
     * 属性 [OWNERTYPE]
     *
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;

    /**
     * 属性 [OWNERID]
     *
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

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
    @JSONField(name = "digestcode")
    @JsonProperty("digestcode")
    private String digestcode;

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
    public void setFilepath(String  filepath){
        this.filepath = filepath ;
        this.modify("filepath",filepath);
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
    public void setFilesize(Integer  filesize){
        this.filesize = filesize ;
        this.modify("filesize",filesize);
    }

    /**
     * 设置 [FILEEXT]
     */
    public void setFileext(String  fileext){
        this.fileext = fileext ;
        this.modify("fileext",fileext);
    }

    /**
     * 设置 [OWNERTYPE]
     */
    public void setOwnertype(String  ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }

    /**
     * 设置 [OWNERID]
     */
    public void setOwnerid(String  ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
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
    public void setDigestcode(String  digestcode){
        this.digestcode = digestcode ;
        this.modify("digestcode",digestcode);
    }


}

