package cn.ibizlab.util.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * 实体[支付交易]
 */
@Data
public class PayTrade{
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
    @JSONField(name = "total_amount")
    @JsonProperty("total_amount")
    private String totalAmount;
    /**
     * 支付类型
     */
    @JSONField(name = "trade_type")
    @JsonProperty("trade_type")
    private String tradeType;
    /**
     * 订单号
     */
    @JSONField(name = "out_trade_no")
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * 应用标识
     */
    @JSONField(name = "app_id")
    @JsonProperty("app_id")
    private String appId;
    /**
     * 支付平台接入标识
     */
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    private String accessId;
}


