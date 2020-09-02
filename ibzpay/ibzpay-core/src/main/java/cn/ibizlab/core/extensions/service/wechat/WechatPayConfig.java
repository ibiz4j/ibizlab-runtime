package cn.ibizlab.core.extensions.service.wechat;


import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Data
public class WechatPayConfig extends WXPayConfig {

    private byte[] certData;

    private String appID;

    private String mchID;

    private String key;

    private InputStream certStream;

    private IWXPayDomain WXPayDomain;


//    public WechatPayConfig() throws Exception {
//        String certPath = "/path/to/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
//    }
//
//    public String getAppID() {
//        return "wx8888888888888888";
//    }
//
//    public String getMchID() {
//        return "12888888";
//    }
//
//    public String getKey() {
//        return "88888888888888888888888888888888";
//    }

//    public InputStream getCertStream() {
//        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
//        return certBis;
//    }

//    public int getHttpConnectTimeoutMs() {
//        return 8000;
//    }
//
//    public int getHttpReadTimeoutMs() {
//        return 10000;
//    }

//    @Override
//    IWXPayDomain getWXPayDomain() {
//        return null;
//    }
}