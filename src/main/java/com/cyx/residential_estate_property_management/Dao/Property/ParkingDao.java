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
    List<Parking> getParkingList(String parking_number, String status);

    @Select("select id,parking_number,status,area from parking where id = #{id}")
    Parking getParkingById(Integer id);

    @Delete("delete from parking where id = #{id}")
    int deleteParkingById(Integer id);

    @Select("select count(*) from parking")
    int getParkingNum();

    @Select("select count(*) from parking where status = '空闲'")
    int getParkingNum_NotSale();
}
