package cn.ibizlab.core.uaa.domain;

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
import java.io.Serializable;
import lombok.*;
import org.springframework.data.annotation.Transient;
import cn.ibizlab.util.annotation.Audit;

import cn.ibizlab.util.domain.EntityClient;

/**
 * ServiceApi [系统用户] 对象
 */
@Data
public class SysUser extends EntityClient implements Serializable {

    /**
     * 用户标识
     */
    @DEField(isKeyField=true)
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 用户全局名
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 用户姓名
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 用户工号
     */
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;

    /**
     * 密码
     */
    @JSONField(name = "password")
    @JsonProperty("password")
    private String password;

    /**
     * 登录名
     */
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;

    /**
     * 区属
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 主部门
     */
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;

    /**
     * 主部门代码
     */
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    private String mdeptcode;

    /**
     * 主部门名称
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;

    /**
     * 业务编码
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 岗位标识
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;

    /**
     * 岗位代码
     */
    @JSONField(name = "postcode")
    @JsonProperty("postcode")
    private String postcode;

    /**
     * 岗位名称
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;

    /**
     * 单位
     */
    @DEField(preType = DEPredefinedFieldType.ORGID)
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 单位代码
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 单位名称
     */
    @DEField(preType = DEPredefinedFieldType.ORGNAME)
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 昵称别名
     */
    @JSONField(name = "nickname")
    @JsonProperty("nickname")
    private String nickname;

    /**
     * 性别
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 出生日期
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "birthday" , format="yyyy-MM-dd")
    @JsonProperty("birthday")
    private Timestamp birthday;

    /**
     * 证件号码
     */
    @JSONField(name = "certcode")
    @JsonProperty("certcode")
    private String certcode;

    /**
     * 联系方式
     */
    @JSONField(name = "phone")
    @JsonProperty("phone")
    private String phone;

    /**
     * 邮件
     */
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;

    /**
     * 社交账号
     */
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    private String avatar;

    /**
     * 地址
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
    private String addr;

    /**
     * 照片
     */
    @JSONField(name = "usericon")
    @JsonProperty("usericon")
    private String usericon;

    /**
     * 样式
     */
    @JSONField(name = "theme")
    @JsonProperty("theme")
    private String theme;

    /**
     * 语言
     */
    @JSONField(name = "lang")
    @JsonProperty("lang")
    private String lang;

    /**
     * 字号
     */
    @JSONField(name = "fontsize")
    @JsonProperty("fontsize")
    private String fontsize;

    /**
     * 备注
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 保留
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 超级管理员
     */
    @DEField(defaultValue = "0")
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;





    /**
     * 设置 [用户全局名]
     */
    public void setUsername(String username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [用户姓名]
     */
    public void setPersonname(String personname){
        this.personname = personname ;
        this.modify("personname",personname);
    }

    /**
     * 设置 [用户工号]
     */
    public void setUsercode(String usercode){
        this.usercode = usercode ;
        this.modify("usercode",usercode);
    }

    /**
     * 设置 [密码]
     */
    public void setPassword(String password){
        this.password = password ;
        this.modify("password",password);
    }

    /**
     * 设置 [登录名]
     */
    public void setLoginname(String loginname){
        this.loginname = loginname ;
        this.modify("loginname",loginname);
    }

    /**
     * 设置 [区属]
     */
    public void setDomains(String domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [主部门]
     */
    public void setMdeptid(String mdeptid){
        this.mdeptid = mdeptid ;
        this.modify("mdeptid",mdeptid);
    }

    /**
     * 设置 [主部门代码]
     */
    public void setMdeptcode(String mdeptcode){
        this.mdeptcode = mdeptcode ;
        this.modify("mdeptcode",mdeptcode);
    }

    /**
     * 设置 [主部门名称]
     */
    public void setMdeptname(String mdeptname){
        this.mdeptname = mdeptname ;
        this.modify("mdeptname",mdeptname);
    }

    /**
     * 设置 [业务编码]
     */
    public void setBcode(String bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [岗位标识]
     */
    public void setPostid(String postid){
        this.postid = postid ;
        this.modify("postid",postid);
    }

    /**
     * 设置 [岗位代码]
     */
    public void setPostcode(String postcode){
        this.postcode = postcode ;
        this.modify("postcode",postcode);
    }

    /**
     * 设置 [岗位名称]
     */
    public void setPostname(String postname){
        this.postname = postname ;
        this.modify("postname",postname);
    }

    /**
     * 设置 [单位代码]
     */
    public void setOrgcode(String orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [昵称别名]
     */
    public void setNickname(String nickname){
        this.nickname = nickname ;
        this.modify("nickname",nickname);
    }

    /**
     * 设置 [性别]
     */
    public void setSex(String sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [出生日期]
     */
    public void setBirthday(Timestamp birthday){
        this.birthday = birthday ;
        this.modify("birthday",birthday);
    }

    /**
     * 格式化日期 [出生日期]
     */
    public String formatBirthday(){
        if (this.birthday == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birthday);
    }
    /**
     * 设置 [证件号码]
     */
    public void setCertcode(String certcode){
        this.certcode = certcode ;
        this.modify("certcode",certcode);
    }

    /**
     * 设置 [联系方式]
     */
    public void setPhone(String phone){
        this.phone = phone ;
        this.modify("phone",phone);
    }

    /**
     * 设置 [邮件]
     */
    public void setEmail(String email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [社交账号]
     */
    public void setAvatar(String avatar){
        this.avatar = avatar ;
        this.modify("avatar",avatar);
    }

    /**
     * 设置 [地址]
     */
    public void setAddr(String addr){
        this.addr = addr ;
        this.modify("addr",addr);
    }

    /**
     * 设置 [照片]
     */
    public void setUsericon(String usericon){
        this.usericon = usericon ;
        this.modify("usericon",usericon);
    }

    /**
     * 设置 [样式]
     */
    public void setTheme(String theme){
        this.theme = theme ;
        this.modify("theme",theme);
    }

    /**
     * 设置 [语言]
     */
    public void setLang(String lang){
        this.lang = lang ;
        this.modify("lang",lang);
    }

    /**
     * 设置 [字号]
     */
    public void setFontsize(String fontsize){
        this.fontsize = fontsize ;
        this.modify("fontsize",fontsize);
    }

    /**
     * 设置 [备注]
     */
    public void setMemo(String memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [保留]
     */
    public void setReserver(String reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [超级管理员]
     */
    public void setSuperuser(Integer superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
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
        return super.copyTo(targetEntity,bIncEmpty);
    }
}


