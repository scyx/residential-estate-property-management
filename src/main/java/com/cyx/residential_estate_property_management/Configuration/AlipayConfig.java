package com.cyx.residential_estate_property_management.Configuration;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author cyx
 * @data 2020/5/14 14:20
 */
@Configuration
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    //    netapp映射的地址，，，根据自己的需要修改
    private static String neturl = "http://23iswn.natappfree.cc";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
    public static String app_id = "2016102400751451";

    // 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCiDFlg6lryWnzluccNerml3DWEyxUe/BIfdwuZwJMIWXeTNlwHVYrVZnaZg2Zdl1x5Wcc4LsXKTZHgyvBWqtAF/9gbqXOH63YgpklqW0KBzWfMebRlil41QBstR1ouRjWOZdi4RssJ8z9pblMAw5GdgHDX6xAH0y6+WPWCOI4TrfOUpUh6ABRt6SXImiwoMOIrNfRAuA0BOWzch4ZxJM+B6thDxfBKliG2JitRTAqvP50Rh7pJxD/24gBaRwOHlbSdaL3202Cxzmx5paQSJ0Hiq/A+8s0S1d0ZZrCz3P674xayr1XyakeyZXPRNdVKgzqH2vfxQ4HgItEyb51HL4cvAgMBAAECggEAA/+MAQEnR02GQWDJEYMSq434YBNmrQIJLG+SgLOorQ8QDTjNIn0w1L0Xdggw8WQ3quLVMISu6qPpUoOPVIQYZ919JomSySq9Gmcf7pjb1joMMpZaJhs44dV4FjDpf7TJw36tzzYn8lHnIaHQOHea0ykFH760AY1rXNTzEch1cPTSt530eJlXZWYkJvSH+ziJFalXyhXYAGb+A9ew0PNZpeIyTBDyJaxrl/t9UfFtUTsvTEKuG5Z3uGhDWBMy9UNYfnZUjqJrSxiEsnHViwpPn4X0XdRGOBfnJZx838Ypqto0YVGfyh9bYVkmSme09Lf0w/f/qCH2CEkKc9JUaZffCQKBgQDaMXDPEum4qiERurnYk7buicb6Aol9yvwQmI1ExHvqoV6TuFzNOCtmXQyXvR1AGeF6hx/zNJAlBfnHpY+SdDufVnn3UatJ9UbBXAXJf/yhU49e/uUGDlOZcCpJ1ezBFBUPkX7D0jEYKH26WRdhHEtY/lp2BIhCCngSQyGs+9hvowKBgQC+IHJc0VkrXFCekSwDMZqs1NGyTH0SQpbm+mgGXK7Qu9fBu4A3tqk5nzi3m1jc2Bku0abjYRriSHWjhFf4hcSC3Qu+vB3PQOnbuaRJ42gbmScIp/ea8nD4OGnDH/N+4Utg+KjgDvGL4nqzXYWes2Cmfxcgidfg9pXjr7H1X2bTBQKBgQCS8Ujvq+ULIEg1EHOoj5JbAx6lsJ+3v8QRySsabNinIxX2leqpqnJP9cpNRmc0jDl1sxqpR3Tr+iJFehI+p1if7jUlgjLBFBYakkazdSZF32hmqXLDqVJTu14/a3qObV/hpDKi3iOCCYLixK0iEVQNEv8JC/RXxYUnh15eiR0x0QKBgCINea46KLhlbmMYKUPhLIzsCSrgHD6bAqAYFW2eSAlGu5wNUyenZaPWargn8MCNS+Vg031CNSh2ReulloQCoXG22ZWt58DpJXmfRFefjVP0GFOqkeSEq8spf3fdTyVYgMG7h7OpuYWOaN+bToVgJ11qwd+oEKxQPgRrwXnrPmVpAoGAMM3lRp4zX69M4NgiaOtM/EdafJ17aMyQKePd5qUQKORplvAFf/G1GTJhLmIXYVs2sASsXlUZjDIcrnAXmZwepdXufOisvM3Uw50+19Hken7e/Hf5YaAn76RCyV7WqQ7HdOVod9ZnR/QJwxwC13P8A9XibfSsAqroWBDpO5eCX1Y=";

    // 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmDjUC2XzGzl8lvF6VxsIcdz9f8gdvz7AVs8V24/yIFM/NNggxGFABALgdJ6drtlrwHb6ZxSb/DeA6IvYyuA2WmesPtS4N/5BYMOBbSrT9HKYZBS+KQJPlBgG5ZnodegyjhOmnEtb2NzzQc5i0b2dRXEk/JV+7vL31IKEYGJ68X0dtphOC6VOjzSddzJSRpnq3IGGTqnwpEccG+0dRWvCHRwOFBjH4uP9Q/D+IJshSGGH+lMJB3Iv0mBvOnS8w7EACTvHgmziJpCQ1FKw4LhKc/oyqunP4QfsANfjELgztgaudG2UrGWhcmlJvydVh1gZHIvevFyNNm/x4KAflURerwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String notify_url = neturl+"/alipay.do";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String return_url = neturl+"/PaymentList";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    public static String getNeturl() {
        return neturl;
    }

    public static void setNeturl(String neturl) {
        AlipayConfig.neturl = neturl;
    }

    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        AlipayConfig.app_id = app_id;
    }

    public static String getMerchant_private_key() {
        return merchant_private_key;
    }

    public static void setMerchant_private_key(String merchant_private_key) {
        AlipayConfig.merchant_private_key = merchant_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        AlipayConfig.charset = charset;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public static void setGatewayUrl(String gatewayUrl) {
        AlipayConfig.gatewayUrl = gatewayUrl;
    }

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        AlipayConfig.log_path = log_path;
    }
}
