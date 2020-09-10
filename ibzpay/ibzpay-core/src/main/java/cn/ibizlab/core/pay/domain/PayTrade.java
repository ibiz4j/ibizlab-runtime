package cn.ibizlab.core.pay.domain;

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
import cn.ibizlab.util.annotation.Audit;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.util.domain.EntityMP;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * 实体[支付交易1]
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = "handler")
@TableName(value = "IBZPAYTRADE",resultMap = "PayTradeResultMap")
public class PayTrade extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单标题
     */
    @TableField(value = "subject")
    @JSONField(name = "subject")
    @JsonProperty("subject")
    private String subject;
    /**
     * 订单金额
     */
    @TableField(value = "totalamount")
    @JSONField(name = "total_amount")
    @JsonProperty("total_amount")
    private String totalAmount;
    /**
     * 交易名称
     */
    @TableField(value = "tradename")
    @JSONField(name = "trade_name")
    @JsonProperty("trade_name")
    private String tradeName;
    /**
     * 支付类型
     */
    @TableField(value = "tradetype")
    @JSONField(name = "trade_type")
    @JsonProperty("trade_type")
    private String tradeType;
    /**
     * 支付状态
     */
    @TableField(value = "tradestatus")
    @JSONField(name = "trade_status")
    @JsonProperty("trade_status")
    private String tradeStatus;
    /**
     * 订单号
     */
    @TableField(value = "outtradeno")
    @JSONField(name = "out_trade_no")
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * 交易标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "tradeid",type=IdType.ASSIGN_UUID)
    @JSONField(name = "trade_id")
    @JsonProperty("trade_id")
    private String tradeId;
    /**
     * AccessKey(AppId)
     */
    @TableField(value = "appid")
    @JSONField(name = "app_id")
    @JsonProperty("app_id")
    private String appId;
    /**
     * 支付平台
     */
    @TableField(value = "accessname")
    @JSONField(name = "access_name")
    @JsonProperty("access_name")
    private String accessName;
    /**
     * 支付平台接入标识
     */
    @TableField(value = "accessid")
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    private String accessId;

    /**
     * 接入平台
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.core.pay.domain.PayOpenAccess openaccess;



    /**
     * 设置 [订单标题]
     */
    public void setSubject(String subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }

    /**
     * 设置 [订单金额]
     */
    public void setTotalAmount(String totalAmount){
        this.totalAmount = totalAmount ;
        this.modify("totalamount",totalAmount);
    }

    /**
     * 设置 [交易名称]
     */
    public void setTradeName(String tradeName){
        this.tradeName = tradeName ;
        this.modify("tradename",tradeName);
    }

    /**
     * 设置 [支付类型]
     */
    public void setTradeType(String tradeType){
        this.tradeType = tradeType ;
        this.modify("tradetype",tradeType);
    }

    /**
     * 设置 [支付状态]
     */
    public void setTradeStatus(String tradeStatus){
        this.tradeStatus = tradeStatus ;
        this.modify("tradestatus",tradeStatus);
    }

    /**
     * 设置 [订单号]
     */
    public void setOutTradeNo(String outTradeNo){
        this.outTradeNo = outTradeNo ;
        this.modify("outtradeno",outTradeNo);
    }

    /**
     * 设置 [AccessKey(AppId)]
     */
    public void setAppId(String appId){
        this.appId = appId ;
        this.modify("appid",appId);
    }

    /**
     * 设置 [支付平台]
     */
    public void setAccessName(String accessName){
        this.accessName = accessName ;
        this.modify("accessname",accessName);
    }

    /**
     * 设置 [支付平台接入标识]
     */
    public void setAccessId(String accessId){
        this.accessId = accessId ;
        this.modify("accessid",accessId);
    }


    /**
     * 获取 [交易标识]
     */
    public String getTradeId(){
        if(ObjectUtils.isEmpty(tradeId)){
            tradeId=(String)getDefaultKey(true);
        }
        return tradeId;
    }

    @Override
    public Serializable getDefaultKey(boolean gen) {
        if((!ObjectUtils.isEmpty(this.getAccessId()))&&(!ObjectUtils.isEmpty(this.getOutTradeNo())))
            return DigestUtils.md5DigestAsHex(String.format("%s||%s" ,this.getAccessId(),this.getOutTradeNo()).getBytes());
        return null;
    }
}


