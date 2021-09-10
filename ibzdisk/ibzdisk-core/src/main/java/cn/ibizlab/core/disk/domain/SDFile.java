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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[文件]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZFILE", resultMap = "SDFileResultMap")
@ApiModel("文件")
public class SDFile extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @DEField(name = "fileid", isKeyField = true)
    @TableId(value = "fileid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty("标识")
    private String id;
    /**
     * 名称
     */
    @DEField(name = "filename")
    @TableField(value = "filename")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty("名称")
    private String name;
    /**
     * 路径
     */
    @TableField(value = "filepath")
    @JSONField(name = "file_path")
    @JsonProperty("file_path")
    @ApiModelProperty("路径")
    private String filePath;
    /**
     * 特定目录
     */
    @TableField(value = "folder")
    @JSONField(name = "folder")
    @JsonProperty("folder")
    @ApiModelProperty("特定目录")
    private String folder;
    /**
     * 文件大小
     */
    @TableField(value = "filesize")
    @JSONField(name = "file_size")
    @JsonProperty("file_size")
    @ApiModelProperty("文件大小")
    private Integer fileSize;
    /**
     * 扩展名
     */
    @DEField(name = "fileext")
    @TableField(value = "fileext")
    @JSONField(name = "extension")
    @JsonProperty("extension")
    @ApiModelProperty("扩展名")
    private String extension;
    /**
     * 所属类型
     */
    @TableField(value = "ownertype")
    @JSONField(name = "owner_type")
    @JsonProperty("owner_type")
    @ApiModelProperty("所属类型")
    private String ownerType;
    /**
     * 所属主体
     */
    @TableField(value = "ownerid")
    @JSONField(name = "owner_id")
    @JsonProperty("owner_id")
    @ApiModelProperty("所属主体")
    private String ownerId;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    @ApiModelProperty("备注")
    private String memo;
    /**
     * 签名
     */
    @TableField(value = "digestcode")
    @JSONField(name = "digest_code")
    @JsonProperty("digest_code")
    @ApiModelProperty("签名")
    private String digestCode;
    /**
     * 创建人
     */
    @DEField(name = "createman", preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman", fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    @ApiModelProperty("创建人")
    private String createman;
    /**
     * 创建日期
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    @ApiModelProperty("创建日期")
    private Timestamp createdate;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    @ApiModelProperty("更新人")
    private String updateman;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    @ApiModelProperty("更新时间")
    private Timestamp updatedate;



    /**
     * 设置 [名称]
     */
    public void setName(String name) {
        this.name = name;
        this.modify("filename", name);
    }

    /**
     * 设置 [路径]
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this.modify("filepath", filePath);
    }

    /**
     * 设置 [特定目录]
     */
    public void setFolder(String folder) {
        this.folder = folder;
        this.modify("folder", folder);
    }

    /**
     * 设置 [文件大小]
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        this.modify("filesize", fileSize);
    }

    /**
     * 设置 [扩展名]
     */
    public void setExtension(String extension) {
        this.extension = extension;
        this.modify("fileext", extension);
    }

    /**
     * 设置 [所属类型]
     */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
        this.modify("ownertype", ownerType);
    }

    /**
     * 设置 [所属主体]
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        this.modify("ownerid", ownerId);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
    }

    /**
     * 设置 [签名]
     */
    public void setDigestCode(String digestCode) {
        this.digestCode = digestCode;
        this.modify("digestcode", digestCode);
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
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


