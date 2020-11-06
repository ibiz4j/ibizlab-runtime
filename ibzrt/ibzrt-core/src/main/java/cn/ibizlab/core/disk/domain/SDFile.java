package cn.ibizlab.core.disk.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.enums.DEPredefinedFieldType;
import cn.ibizlab.util.enums.DEFieldDefaultValueType;
import cn.ibizlab.util.helper.DataObject;
import cn.ibizlab.util.enums.DupCheck;
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [文件] 对象
 */
@Data
public class SDFile extends EntityClient implements Serializable {

    /**
     * 标识
     */
    @DEField(name = "fileid" , isKeyField=true)
    @JSONField(name = "id")
    @JsonProperty("id")
    private String id;

    /**
     * 名称
     */
    @DEField(name = "filename")
    @JSONField(name = "name")
    @JsonProperty("name")
    private String name;

    /**
     * 路径
     */
    @JSONField(name = "filepath")
    @JsonProperty("filepath")
    private String filepath;

    /**
     * 特定目录
     */
    @JSONField(name = "folder")
    @JsonProperty("folder")
    private String folder;

    /**
     * 文件大小
     */
    @JSONField(name = "filesize")
    @JsonProperty("filesize")
    private Integer filesize;

    /**
     * 扩展名
     */
    @JSONField(name = "fileext")
    @JsonProperty("fileext")
    private String fileext;

    /**
     * 所属类型
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    private String ownertype;

    /**
     * 所属主体
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    private String ownerid;

    /**
     * 备注
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 签名
     */
    @JSONField(name = "digestcode")
    @JsonProperty("digestcode")
    private String digestcode;

    /**
     * 创建人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 创建日期
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;





    /**
     * 设置 [名称]
     */
    public void setName(String name){
        this.name = name ;
        this.modify("filename",name);
    }

    /**
     * 设置 [路径]
     */
    public void setFilepath(String filepath){
        this.filepath = filepath ;
        this.modify("filepath",filepath);
    }

    /**
     * 设置 [特定目录]
     */
    public void setFolder(String folder){
        this.folder = folder ;
        this.modify("folder",folder);
    }

    /**
     * 设置 [文件大小]
     */
    public void setFilesize(Integer filesize){
        this.filesize = filesize ;
        this.modify("filesize",filesize);
    }

    /**
     * 设置 [扩展名]
     */
    public void setFileext(String fileext){
        this.fileext = fileext ;
        this.modify("fileext",fileext);
    }

    /**
     * 设置 [所属类型]
     */
    public void setOwnertype(String ownertype){
        this.ownertype = ownertype ;
        this.modify("ownertype",ownertype);
    }

    /**
     * 设置 [所属主体]
     */
    public void setOwnerid(String ownerid){
        this.ownerid = ownerid ;
        this.modify("ownerid",ownerid);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [签名]
     */
    public void setDigestcode(String digestcode){
        this.digestcode = digestcode ;
        this.modify("digestcode",digestcode);
    }

    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param bIncEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T copyTo(T targetEntity, boolean bIncEmpty) {
        this.reset("fileid");
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


