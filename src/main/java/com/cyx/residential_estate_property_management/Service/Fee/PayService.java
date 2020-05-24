package com.cyx.residential_estate_property_management.Service.Fee;

import com.alipay.api.AlipayApiException;
import com.cyx.residential_estate_property_management.Bean.Fee.PayListItem;
import com.cyx.residential_estate_property_management.Bean.Pay.AlipayBean;
import com.cyx.residential_estate_property_management.Dao.Fee.PayDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/4/28 16:13
 */
@Service
public class PayService {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    PayDao payDao;


    public int addPayListItem(PayListItem payListItem) {
        return baseMysqlCRUDManager.save(payListItem);
    }


    public PageInfo<PayListItem> getPayItemList(String pay_person, String start_time, String end_time, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(payDao.getPayItemList(pay_person,start_time,end_time));
    }

    @Autowired
    private Alipay alipay;

    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }

    public void updateStatusById(String id) {
        payDao.updateStatusById(id);
    }
}
