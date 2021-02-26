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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.DTOClient;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务DTO对象[PayTradeDTO]
 */
@Data
@ApiModel("支付交易")
public class PayTradeDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [SUBJECT]
     *
     */
    @JSONField(name = "subject")
    @JsonProperty("subject")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("订单标题")
    private String subject;

    /**
     * 属性 [TOTALAMOUNT]
     *
     */
    @JSONField(name = "total_amount")
    @JsonProperty("total_amount")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("订单金额")
    private String totalAmount;

    /**
     * 属性 [TRADENAME]
     *
     */
    @JSONField(name = "trade_name")
    @JsonProperty("trade_name")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("交易名称")
    private String tradeName;

    /**
     * 属性 [TRADETYPE]
     *
     */
    @JSONField(name = "trade_type")
    @JsonProperty("trade_type")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("支付类型")
    private String tradeType;

    /**
     * 属性 [TRADESTATUS]
     *
     */
    @JSONField(name = "trade_status")
    @JsonProperty("trade_status")
    @Size(min = 0, max = 60, message = "内容长度必须小于等于[60]")
    @ApiModelProperty("支付状态")
    private String tradeStatus;

    /**
     * 属性 [OUTTRADENO]
     *
     */
    @JSONField(name = "out_trade_no")
    @JsonProperty("out_trade_no")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("订单号")
    private String outTradeNo;

    /**
     * 属性 [TRADEID]
     *
     */
    @JSONField(name = "trade_id")
    @JsonProperty("trade_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("交易标识")
    private String tradeId;

    /**
     * 属性 [APPID]
     *
     */
    @JSONField(name = "app_id")
    @JsonProperty("app_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("AccessKey(AppId)")
    private String appId;

    /**
     * 属性 [ACCESSNAME]
     *
     */
    @JSONField(name = "access_name")
    @JsonProperty("access_name")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("支付平台")
    private String accessName;

    /**
     * 属性 [ACCESSID]
     *
     */
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    @Size(min = 0, max = 100, message = "内容长度必须小于等于[100]")
    @ApiModelProperty("支付平台接入标识")
    private String accessId;


    /**
     * 设置 [SUBJECT]
     */
    public void setSubject(String  subject){
        this.subject = subject ;
        this.modify("subject",subject);
    }

    /**
     * 设置 [TOTALAMOUNT]
     */
    public void setTotalAmount(String  totalAmount){
        this.totalAmount = totalAmount ;
        this.modify("totalamount",totalAmount);
    }

    /**
     * 设置 [TRADENAME]
     */
    public void setTradeName(String  tradeName){
        this.tradeName = tradeName ;
        this.modify("tradename",tradeName);
    }

    /**
     * 设置 [TRADETYPE]
     */
    public void setTradeType(String  tradeType){
        this.tradeType = tradeType ;
        this.modify("tradetype",tradeType);
    }

    /**
     * 设置 [TRADESTATUS]
     */
    public void setTradeStatus(String  tradeStatus){
        this.tradeStatus = tradeStatus ;
        this.modify("tradestatus",tradeStatus);
    }

    /**
     * 设置 [OUTTRADENO]
     */
    public void setOutTradeNo(String  outTradeNo){
        this.outTradeNo = outTradeNo ;
        this.modify("outtradeno",outTradeNo);
    }

    /**
     * 设置 [APPID]
     */
    public void setAppId(String  appId){
        this.appId = appId ;
        this.modify("appid",appId);
    }

    /**
     * 设置 [ACCESSNAME]
     */
    public void setAccessName(String  accessName){
        this.accessName = accessName ;
        this.modify("accessname",accessName);
    }

    /**
     * 设置 [ACCESSID]
     */
    public void setAccessId(String  accessId){
        this.accessId = accessId ;
        this.modify("accessid",accessId);
    }


}


