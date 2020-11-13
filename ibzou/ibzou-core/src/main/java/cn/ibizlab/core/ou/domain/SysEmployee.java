package cn.ibizlab.core.ou.domain;

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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[人员]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZEMP", resultMap = "SysEmployeeResultMap")
public class SysEmployee extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户标识
     */
    @DEField(isKeyField = true)
    @TableId(value = "userid", type = IdType.ASSIGN_UUID)
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;
    /**
     * 用户全局名
     */
    @TableField(value = "username")
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;
    /**
     * 姓名
     */
    @TableField(value = "personname")
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;
    /**
     * 用户工号
     */
    @TableField(value = "usercode")
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;
    /**
     * 登录名
     */
    @TableField(value = "loginname")
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;
    /**
     * 密码
     */
    @TableField(value = "password")
    @JSONField(name = "password")
    @JsonProperty("password")
    private String password;
    /**
     * 区属
     */
    @TableField(value = "domains")
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;
    /**
     * 主部门
     */
    @TableField(value = "mdeptid")
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;
    /**
     * 主部门代码
     */
    @TableField(value = "mdeptcode")
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    private String mdeptcode;
    /**
     * 主部门名称
     */
    @TableField(value = "mdeptname")
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;
    /**
     * 业务编码
     */
    @TableField(value = "bcode")
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;
    /**
     * 岗位标识
     */
    @TableField(value = "postid")
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;
    /**
     * 岗位代码
     */
    @TableField(value = "postcode")
    @JSONField(name = "postcode")
    @JsonProperty("postcode")
    private String postcode;
    /**
     * 岗位名称
     */
    @TableField(value = "postname")
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;
    /**
     * 单位
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @TableField(value = "orgid")
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;
    /**
     * 单位代码
     */
    @TableField(value = "orgcode")
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;
    /**
     * 单位名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @TableField(value = "orgname")
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;
    /**
     * 昵称别名
     */
    @TableField(value = "nickname")
    @JSONField(name = "nickname")
    @JsonProperty("nickname")
    private String nickname;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;
    /**
     * 证件号码
     */
    @TableField(value = "certcode")
    @JSONField(name = "certcode")
    @JsonProperty("certcode")
    private String certcode;
    /**
     * 联系方式
     */
    @TableField(value = "phone")
    @JSONField(name = "phone")
    @JsonProperty("phone")
    private String phone;
    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "birthday", format = "yyyy-MM-dd")
    @JsonProperty("birthday")
    private Timestamp birthday;
    /**
     * 邮件
     */
    @TableField(value = "email")
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;
    /**
     * 社交账号
     */
    @TableField(value = "avatar")
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    private String avatar;
    /**
     * 地址
     */
    @TableField(value = "addr")
    @JSONField(name = "addr")
    @JsonProperty("addr")
    private String addr;
    /**
     * 照片
     */
    @TableField(value = "usericon")
    @JSONField(name = "usericon")
    @JsonProperty("usericon")
    private String usericon;
    /**
     * ip地址
     */
    @TableField(value = "ipaddr")
    @JSONField(name = "ipaddr")
    @JsonProperty("ipaddr")
    private String ipaddr;
    /**
     * 样式
     */
    @TableField(value = "theme")
    @JSONField(name = "theme")
    @JsonProperty("theme")
    private String theme;
    /**
     * 语言
     */
    @TableField(value = "lang")
    @JSONField(name = "lang")
    @JsonProperty("lang")
    private String lang;
    /**
     * 字号
     */
    @TableField(value = "fontsize")
    @JSONField(name = "fontsize")
    @JsonProperty("fontsize")
    private String fontsize;
    /**
     * 备注
     */
    @TableField(value = "memo")
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;
    /**
     * 保留
     */
    @TableField(value = "reserver")
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;
    /**
     * 排序
     */
    @TableField(value = "showorder")
    @JSONField(name = "showorder")
    @JsonProperty("showorder")
    private Integer showorder;
    /**
     * 逻辑有效
     */
    @DEField(preType = DEPredefinedFieldType.LOGICVALID, logicval = "1", logicdelval = "0")
    @TableLogic(value = "1", delval = "0")
    @TableField(value = "enable")
    @JSONField(name = "enable")
    @JsonProperty("enable")
    private Integer enable;
    /**
     * 创建时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "createdate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 最后修改时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "updatedate", format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysDepartment maindept;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysOrganization org;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.ou.domain.SysPost post;



    /**
     * 设置 [用户全局名]
     */
    public void setUsername(String username) {
        this.username = username;
        this.modify("username", username);
    }

    /**
     * 设置 [姓名]
     */
    public void setPersonname(String personname) {
        this.personname = personname;
        this.modify("personname", personname);
    }

    /**
     * 设置 [用户工号]
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
        this.modify("usercode", usercode);
    }

    /**
     * 设置 [登录名]
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
        this.modify("loginname", loginname);
    }

    /**
     * 设置 [密码]
     */
    public void setPassword(String password) {
        this.password = password;
        this.modify("password", password);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains) {
        this.domains = domains;
        this.modify("domains", domains);
    }

    /**
     * 设置 [主部门]
     */
    public void setMdeptid(String mdeptid) {
        this.mdeptid = mdeptid;
        this.modify("mdeptid", mdeptid);
    }

    /**
     * 设置 [主部门代码]
     */
    public void setMdeptcode(String mdeptcode) {
        this.mdeptcode = mdeptcode;
        this.modify("mdeptcode", mdeptcode);
    }

    /**
     * 设置 [主部门名称]
     */
    public void setMdeptname(String mdeptname) {
        this.mdeptname = mdeptname;
        this.modify("mdeptname", mdeptname);
    }

    /**
     * 设置 [业务编码]
     */
    public void setBcode(String bcode) {
        this.bcode = bcode;
        this.modify("bcode", bcode);
    }

    /**
     * 设置 [岗位标识]
     */
    public void setPostid(String postid) {
        this.postid = postid;
        this.modify("postid", postid);
    }

    /**
     * 设置 [岗位代码]
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
        this.modify("postcode", postcode);
    }

    /**
     * 设置 [岗位名称]
     */
    public void setPostname(String postname) {
        this.postname = postname;
        this.modify("postname", postname);
    }

    /**
     * 设置 [单位代码]
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
        this.modify("orgcode", orgcode);
    }

    /**
     * 设置 [昵称别名]
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
        this.modify("nickname", nickname);
    }

    /**
     * 设置 [性别]
     */
    public void setSex(String sex) {
        this.sex = sex;
        this.modify("sex", sex);
    }

    /**
     * 设置 [证件号码]
     */
    public void setCertcode(String certcode) {
        this.certcode = certcode;
        this.modify("certcode", certcode);
    }

    /**
     * 设置 [联系方式]
     */
    public void setPhone(String phone) {
        this.phone = phone;
        this.modify("phone", phone);
    }

    /**
     * 设置 [出生日期]
     */
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
        this.modify("birthday", birthday);
    }

    /**
     * 格式化日期 [出生日期]
     */
    public String formatBirthday() {
        if (this.birthday == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birthday);
    }
    /**
     * 设置 [邮件]
     */
    public void setEmail(String email) {
        this.email = email;
        this.modify("email", email);
    }

    /**
     * 设置 [社交账号]
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
        this.modify("avatar", avatar);
    }

    /**
     * 设置 [地址]
     */
    public void setAddr(String addr) {
        this.addr = addr;
        this.modify("addr", addr);
    }

    /**
     * 设置 [照片]
     */
    public void setUsericon(String usericon) {
        this.usericon = usericon;
        this.modify("usericon", usericon);
    }

    /**
     * 设置 [ip地址]
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
        this.modify("ipaddr", ipaddr);
    }

    /**
     * 设置 [样式]
     */
    public void setTheme(String theme) {
        this.theme = theme;
        this.modify("theme", theme);
    }

    /**
     * 设置 [语言]
     */
    public void setLang(String lang) {
        this.lang = lang;
        this.modify("lang", lang);
    }

    /**
     * 设置 [字号]
     */
    public void setFontsize(String fontsize) {
        this.fontsize = fontsize;
        this.modify("fontsize", fontsize);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo) {
        this.memo = memo;
        this.modify("memo", memo);
    }

    /**
     * 设置 [保留]
     */
    public void setReserver(String reserver) {
        this.reserver = reserver;
        this.modify("reserver", reserver);
    }

    /**
     * 设置 [排序]
     */
    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
        this.modify("showorder", showorder);
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
        this.reset("userid");
        return super.copyTo(targetEntity, bIncEmpty);
    }
}


