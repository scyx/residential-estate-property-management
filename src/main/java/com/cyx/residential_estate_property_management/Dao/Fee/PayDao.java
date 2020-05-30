package com.cyx.residential_estate_property_management.Dao.Fee;

import com.cyx.residential_estate_property_management.Bean.Fee.PayListItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author cyx
 * @data 2020/4/28 16:14
 */
@Mapper
public interface PayDao {

    /**
     * 获取支付单列表
     * @param pay_person
     * @param start_time
     * @param end_time
     * @return
     */
    List<PayListItem> getPayItemList(String pay_person, String start_time, String end_time) ;

    /**
     * 支付宝支付成功回调 更新订单状态
     * @param id
     */
    @Update("update PayListItem set status= '已付款' where id = #{id}")
    void updateStatusById(String id);
}
