package com.cyx.residential_estate_property_management.Controller.Pay;

import com.alipay.api.AlipayApiException;
import com.cyx.residential_estate_property_management.Bean.Pay.AlipayBean;
import com.cyx.residential_estate_property_management.Dao.Fee.PayDao;
import com.cyx.residential_estate_property_management.Service.Fee.PayService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @author cyx
 * @data 2020/5/14 14:36
 */
@RestController
public class AliPayController {
    Logger logger = LoggerFactory.getLogger(AliPayController.class);
    @Autowired
    PayService payService;
    @PostMapping("order")
    public String alipay( String tradeNo,String subject,
                           String totalAmount) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(String.valueOf(tradeNo));
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        String res = payService.aliPay(alipayBean);
        System.out.println(res);
        return res;
    }
    @PostMapping("alipay.do")
    public void alipayCallback(HttpServletRequest request) {
        Map<String, String> params= Maps.newHashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for(int i = 0; i<values.length;i++){
                valueStr = (i==values.length-1)?valueStr+values[i]:valueStr+values[i]+",";
            }
            params.put(name,valueStr);
        }
        logger.info("订单id：" + params.get("out_trade_no"));
        payService.updateStatusById(params.get("out_trade_no"));
//        logger.info("支付宝回调, sign:{},trade_status:{},参数:{}",params.get("sign"),params.get("trade_status"),params.toString());
        //!!! 验证回调的正确性，是不是支付宝发了，而且还要避免重复通知
        params.remove("sign_type");
    }

}
