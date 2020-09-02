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
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;

/**
 * 服务DTO对象[SysUserDTO]
 */
@Data
public class SysUserDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [USERID]
     *
     */
    @JSONField(name = "userid")
    @JsonProperty("userid")
    private String userid;

    /**
     * 属性 [USERNAME]
     *
     */
    @JSONField(name = "username")
    @JsonProperty("username")
    private String username;

    /**
     * 属性 [PERSONNAME]
     *
     */
    @JSONField(name = "personname")
    @JsonProperty("personname")
    private String personname;

    /**
     * 属性 [USERCODE]
     *
     */
    @JSONField(name = "usercode")
    @JsonProperty("usercode")
    private String usercode;

    /**
     * 属性 [PASSWORD]
     *
     */
    @JSONField(name = "password")
    @JsonProperty("password")
    private String password;

    /**
     * 属性 [LOGINNAME]
     *
     */
    @JSONField(name = "loginname")
    @JsonProperty("loginname")
    private String loginname;

    /**
     * 属性 [DOMAINS]
     *
     */
    @JSONField(name = "domains")
    @JsonProperty("domains")
    private String domains;

    /**
     * 属性 [MDEPTID]
     *
     */
    @JSONField(name = "mdeptid")
    @JsonProperty("mdeptid")
    private String mdeptid;

    /**
     * 属性 [MDEPTCODE]
     *
     */
    @JSONField(name = "mdeptcode")
    @JsonProperty("mdeptcode")
    private String mdeptcode;

    /**
     * 属性 [MDEPTNAME]
     *
     */
    @JSONField(name = "mdeptname")
    @JsonProperty("mdeptname")
    private String mdeptname;

    /**
     * 属性 [BCODE]
     *
     */
    @JSONField(name = "bcode")
    @JsonProperty("bcode")
    private String bcode;

    /**
     * 属性 [POSTID]
     *
     */
    @JSONField(name = "postid")
    @JsonProperty("postid")
    private String postid;

    /**
     * 属性 [POSTCODE]
     *
     */
    @JSONField(name = "postcode")
    @JsonProperty("postcode")
    private String postcode;

    /**
     * 属性 [POSTNAME]
     *
     */
    @JSONField(name = "postname")
    @JsonProperty("postname")
    private String postname;

    /**
     * 属性 [ORGID]
     *
     */
    @JSONField(name = "orgid")
    @JsonProperty("orgid")
    private String orgid;

    /**
     * 属性 [ORGCODE]
     *
     */
    @JSONField(name = "orgcode")
    @JsonProperty("orgcode")
    private String orgcode;

    /**
     * 属性 [ORGNAME]
     *
     */
    @JSONField(name = "orgname")
    @JsonProperty("orgname")
    private String orgname;

    /**
     * 属性 [NICKNAME]
     *
     */
    @JSONField(name = "nickname")
    @JsonProperty("nickname")
    private String nickname;

    /**
     * 属性 [SEX]
     *
     */
    @JSONField(name = "sex")
    @JsonProperty("sex")
    private String sex;

    /**
     * 属性 [BIRTHDAY]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "birthday" , format="yyyy-MM-dd")
    @JsonProperty("birthday")
    private Timestamp birthday;

    /**
     * 属性 [CERTCODE]
     *
     */
    @JSONField(name = "certcode")
    @JsonProperty("certcode")
    private String certcode;

    /**
     * 属性 [PHONE]
     *
     */
    @JSONField(name = "phone")
    @JsonProperty("phone")
    private String phone;

    /**
     * 属性 [EMAIL]
     *
     */
    @JSONField(name = "email")
    @JsonProperty("email")
    private String email;

    /**
     * 属性 [AVATAR]
     *
     */
    @JSONField(name = "avatar")
    @JsonProperty("avatar")
    private String avatar;

    /**
     * 属性 [ADDR]
     *
     */
    @JSONField(name = "addr")
    @JsonProperty("addr")
    private String addr;

    /**
     * 属性 [USERICON]
     *
     */
    @JSONField(name = "usericon")
    @JsonProperty("usericon")
    private String usericon;

    /**
     * 属性 [THEME]
     *
     */
    @JSONField(name = "theme")
    @JsonProperty("theme")
    private String theme;

    /**
     * 属性 [LANG]
     *
     */
    @JSONField(name = "lang")
    @JsonProperty("lang")
    private String lang;

    /**
     * 属性 [FONTSIZE]
     *
     */
    @JSONField(name = "fontsize")
    @JsonProperty("fontsize")
    private String fontsize;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;

    /**
     * 属性 [SUPERUSER]
     *
     */
    @JSONField(name = "superuser")
    @JsonProperty("superuser")
    private Integer superuser;


    /**
     * 设置 [USERNAME]
     */
    public void setUsername(String  username){
        this.username = username ;
        this.modify("username",username);
    }

    /**
     * 设置 [PERSONNAME]
     */
    public void setPersonname(String  personname){
        this.personname = personname ;
        this.modify("personname",personname);
    }

    /**
     * 设置 [USERCODE]
     */
    public void setUsercode(String  usercode){
        this.usercode = usercode ;
        this.modify("usercode",usercode);
    }

    /**
     * 设置 [PASSWORD]
     */
    public void setPassword(String  password){
        this.password = password ;
        this.modify("password",password);
    }

    /**
     * 设置 [LOGINNAME]
     */
    public void setLoginname(String  loginname){
        this.loginname = loginname ;
        this.modify("loginname",loginname);
    }

    /**
     * 设置 [DOMAINS]
     */
    public void setDomains(String  domains){
        this.domains = domains ;
        this.modify("domains",domains);
    }

    /**
     * 设置 [MDEPTID]
     */
    public void setMdeptid(String  mdeptid){
        this.mdeptid = mdeptid ;
        this.modify("mdeptid",mdeptid);
    }

    /**
     * 设置 [MDEPTCODE]
     */
    public void setMdeptcode(String  mdeptcode){
        this.mdeptcode = mdeptcode ;
        this.modify("mdeptcode",mdeptcode);
    }

    /**
     * 设置 [MDEPTNAME]
     */
    public void setMdeptname(String  mdeptname){
        this.mdeptname = mdeptname ;
        this.modify("mdeptname",mdeptname);
    }

    /**
     * 设置 [BCODE]
     */
    public void setBcode(String  bcode){
        this.bcode = bcode ;
        this.modify("bcode",bcode);
    }

    /**
     * 设置 [POSTID]
     */
    public void setPostid(String  postid){
        this.postid = postid ;
        this.modify("postid",postid);
    }

    /**
     * 设置 [POSTCODE]
     */
    public void setPostcode(String  postcode){
        this.postcode = postcode ;
        this.modify("postcode",postcode);
    }

    /**
     * 设置 [POSTNAME]
     */
    public void setPostname(String  postname){
        this.postname = postname ;
        this.modify("postname",postname);
    }

    /**
     * 设置 [ORGCODE]
     */
    public void setOrgcode(String  orgcode){
        this.orgcode = orgcode ;
        this.modify("orgcode",orgcode);
    }

    /**
     * 设置 [NICKNAME]
     */
    public void setNickname(String  nickname){
        this.nickname = nickname ;
        this.modify("nickname",nickname);
    }

    /**
     * 设置 [SEX]
     */
    public void setSex(String  sex){
        this.sex = sex ;
        this.modify("sex",sex);
    }

    /**
     * 设置 [BIRTHDAY]
     */
    public void setBirthday(Timestamp  birthday){
        this.birthday = birthday ;
        this.modify("birthday",birthday);
    }

    /**
     * 设置 [CERTCODE]
     */
    public void setCertcode(String  certcode){
        this.certcode = certcode ;
        this.modify("certcode",certcode);
    }

    /**
     * 设置 [PHONE]
     */
    public void setPhone(String  phone){
        this.phone = phone ;
        this.modify("phone",phone);
    }

    /**
     * 设置 [EMAIL]
     */
    public void setEmail(String  email){
        this.email = email ;
        this.modify("email",email);
    }

    /**
     * 设置 [AVATAR]
     */
    public void setAvatar(String  avatar){
        this.avatar = avatar ;
        this.modify("avatar",avatar);
    }

    /**
     * 设置 [ADDR]
     */
    public void setAddr(String  addr){
        this.addr = addr ;
        this.modify("addr",addr);
    }

    /**
     * 设置 [USERICON]
     */
    public void setUsericon(String  usericon){
        this.usericon = usericon ;
        this.modify("usericon",usericon);
    }

    /**
     * 设置 [THEME]
     */
    public void setTheme(String  theme){
        this.theme = theme ;
        this.modify("theme",theme);
    }

    /**
     * 设置 [LANG]
     */
    public void setLang(String  lang){
        this.lang = lang ;
        this.modify("lang",lang);
    }

    /**
     * 设置 [FONTSIZE]
     */
    public void setFontsize(String  fontsize){
        this.fontsize = fontsize ;
        this.modify("fontsize",fontsize);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }

    /**
     * 设置 [SUPERUSER]
     */
    public void setSuperuser(Integer  superuser){
        this.superuser = superuser ;
        this.modify("superuser",superuser);
    }


}

