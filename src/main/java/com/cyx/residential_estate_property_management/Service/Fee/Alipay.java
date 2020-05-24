package com.cyx.residential_estate_property_management.Service.Fee;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cyx.residential_estate_property_management.Bean.Pay.AlipayBean;
import com.cyx.residential_estate_property_management.Configuration.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cyx
 * @data 2020/5/14 14:39
 */
@Component
public class Alipay {
    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * 支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    public String pay(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        String serverUrl = alipayConfig.getGatewayUrl();
        String appId = alipayConfig.getApp_id();
        String privateKey = alipayConfig.getMerchant_private_key();
        String format = "json";
        String charset = alipayConfig.getCharset();
        String alipayPublicKey = alipayConfig.getAlipay_public_key();
        String signType = alipayConfig.getSign_type();
        String returnUrl = alipayConfig.getReturn_url();
        String notifyUrl = alipayConfig.getNotify_url();
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        return result;
    }
}
