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
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import cn.ibizlab.util.domain.EntityMongo;

/**
 * 大数据 [文件] 对象
 */
@Data
@Document(collection = "sdfile")
public class SDFile extends EntityMongo implements Serializable {

    /**
     * 标识
     */
    @Id()
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
    @Field(name = "filename")
    private String name;

    /**
     * 路径
     */
    @JSONField(name = "filepath")
    @JsonProperty("filepath")
    @Field(name = "filepath")
    private String filepath;

    /**
     * 特定目录
     */
    @JSONField(name = "folder")
    @JsonProperty("folder")
    @Field(name = "folder")
    private String folder;

    /**
     * 文件大小
     */
    @JSONField(name = "filesize")
    @JsonProperty("filesize")
    @Field(name = "filesize")
    private Integer filesize;

    /**
     * 扩展名
     */
    @JSONField(name = "fileext")
    @JsonProperty("fileext")
    @Field(name = "fileext")
    private String fileext;

    /**
     * 所属类型
     */
    @JSONField(name = "ownertype")
    @JsonProperty("ownertype")
    @Field(name = "ownertype")
    private String ownertype;

    /**
     * 所属主体
     */
    @JSONField(name = "ownerid")
    @JsonProperty("ownerid")
    @Field(name = "ownerid")
    private String ownerid;

    /**
     * 备注
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @Field(name = "memo")
    private String memo;

    /**
     * 签名
     */
    @JSONField(name = "digestcode")
    @JsonProperty("digestcode")
    @Field(name = "digestcode")
    private String digestcode;

    /**
     * 创建人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @Field(name = "createman")
    private String createman;

    /**
     * 创建日期
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @Field(name = "createdate")
    private Timestamp createdate;

    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @Field(name = "updateman")
    private String updateman;

    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @Field(name = "updatedate")
    private Timestamp updatedate;





}


