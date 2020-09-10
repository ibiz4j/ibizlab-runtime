package cn.ibizlab.core.extensions.service.wechat;

import lombok.Data;
import java.io.InputStream;

@Data
public class WechatPayConfig extends WXPayConfig {

    private byte[] certData;

    private String appID;

    private String mchID;

    private String key;

    private InputStream certStream;

    private IWXPayDomain WXPayDomain;
}