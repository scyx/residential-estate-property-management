package com.cyx.residential_estate_property_management.Dao;

import com.cyx.residential_estate_property_management.Bean.House;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cyx
 * @data 2020/3/1 15:11
 */
@Mapper
public interface HouseDao {
    String select_all = "select house_id,house_name,remark,create_date,create_user from house ";
    /**
     * 添加楼栋
     * @param house
     * @return
     */
    @Insert("insert into house (house_name,remark,create_date,create_user) values (#{house.house_name},#{house.remark},current_timestamp,#{house.create_user})")
    int addHouse(@Param("house") House house);

    /**
     * 不带参数查询楼栋列表
     * @return
     */
    @Select(select_all)
    List<House> getHouseList();

    /**
     * 带参数查询楼栋列表
     * @param query
     * @return
     */
    @Select(select_all + "where house_name like CONCAT('%',#{query},'%')" +
            "or remark  like CONCAT('%',#{query},'%')" +
            "or create_date like CONCAT('%',#{query},'%')" +
            "or create_user like CONCAT('%',#{query},'%')")
    List<House> getHouseListByQuery(@Param("query") String query);

    @Select("select house_name,remark,create_user,create_date from house where id = #{id}")
    House getHouseById(int id);
}
