package cn.ibizlab.core.ou.extensions.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EmpNode {

    @JSONField(name = "id")
    @JsonProperty("id")
    private String userid;

    @JSONField(name = "label")
    @JsonProperty("label")
    private String personname;

    @JSONField(name = "code")
    @JsonProperty("code")
    private String usercode;

    private String loginname;

    private String domains;

    private String username;

    private String bcode;

    private String mdeptid;

    private String mdeptcode;

    private String mdeptname;

    private String postid;

    private String postcode;

    private String postname;

    private String orgid;

    private String orgcode;

    private String orgname;

    private String nickname;

    private String sex;

    private String certcode;

    private String phone;

    @JsonFormat(pattern="yyyy-MM-dd", locale = "zh" , timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
    private Timestamp birthday;

    private String email;

    private String avatar;

    private String addr;

    public String getGroup()
    {
        return mdeptname;
    }

}
