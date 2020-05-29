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
 * 费用Dao
 */
@Mapper
public interface FeeDao {
    /**
     * 获取费用设置项
     * @param feeProject
     * @param feeType
     * @return
     */
    List<FeeSettingItem> getFeeSettingItemList(String feeProject, String feeType);

    /**
     * 删除费用设置项
     * @param id
     * @return
     */
    @Delete("delete from feesettingitem where id = #{id}")
    int deleteFeeSettingItemById(Integer id);

    /**
     * 获取费用项信息
     * @param id
     * @return
     */
    @Select("select * from feesettingitem where id = #{id}")
    FeeSettingItem getFeeSettingItemById(Integer id);
}
