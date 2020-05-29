package com.cyx.residential_estate_property_management.Dao.Fee;

import com.cyx.residential_estate_property_management.Bean.Fee.FeeSettingItem;
import com.cyx.residential_estate_property_management.Service.Fee.FeeService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/26 15:07
 */
@Mapper
public interface FeeDao {
    List<FeeSettingItem> getFeeSettingItemList(String feeProject, String feeType);

    @Delete("delete from feesettingitem where id = #{id}")
    int deleteFeeSettingItemById(Integer id);

    @Select("select * from feesettingitem where id = #{id}")
    FeeSettingItem getFeeSettingItemById(Integer id);
}
