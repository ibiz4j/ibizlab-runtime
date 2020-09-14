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
     * 订单号
     */
    @JSONField(name = "out_trade_no")
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * rt开放平台配置标识(OpenAccessId或AppId)
     */
    @JSONField(name = "access_id")
    @JsonProperty("access_id")
    private String accessId;
}


