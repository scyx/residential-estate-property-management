package com.cyx.residential_estate_property_management.Dao.Property;

import com.cyx.residential_estate_property_management.Bean.Property.House;
import org.apache.ibatis.annotations.*;

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
            "or create_date like binary CONCAT('%',#{query},'%')" +
            "or create_user like CONCAT('%',#{query},'%')")
    List<House> getHouseListByQuery(@Param("query") String query);

    /**
     * 根据id获取楼栋信息
     * @param id
     * @return
     */
    @Select("select house_id,house_name,remark,create_user,create_date from house where house_id = #{id}")
    House getHouseById(Integer id);

    /**
     * 根据id删除楼栋
     */
    @Delete("delete from house where house_id = #{id}")
    Integer deleteHouseById(Integer id);
}
