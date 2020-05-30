package com.cyx.residential_estate_property_management.Dao.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Parking;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/20 16:51
 */
@Mapper
public interface ParkingDao {
    /**
     * 查看停车位列表
     * @param parking_number
     * @param status
     * @return
     */
    List<Parking> getParkingList(String parking_number, String status);

    /**
     * 获取停车位信息
     * @param id
     * @return
     */
    @Select("select id,parking_number,status,area,owner,owner_telephone from Parking where id = #{id}")
    Parking getParkingById(Integer id);

    /**
     * 删除停车位
     * @param id
     * @return
     */
    @Delete("delete from Parking where id = #{id}")
    int deleteParkingById(Integer id);

    /**
     * 获取所有车位数量
     * @return
     */
    @Select("select count(*) from Parking")
    int getParkingNum();

    /**
     * 获取空闲车位数量
     * @return
     */
    @Select("select count(*) from Parking where status = '空闲'")
    int getParkingNum_NotSale();
}
