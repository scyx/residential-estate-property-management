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


    public List<PayListItem> getPayItemList(String pay_person, String start_time, String end_time) ;

    @Update("update paylistitem set status= '已付款' where id = #{id}")
    void updateStatusById(String id);
}
