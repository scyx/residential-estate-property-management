package com.cyx.residential_estate_property_management.Dao;

import com.cyx.residential_estate_property_management.Bean.HouseHold;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/7 19:07
 */
@Mapper
public interface HouseHoldDao {

    String select_all = "select *,ROUND(DATEDIFF(CURDATE(), birthday)/365.2422) AS age from household ";

    /**
     * 获取住户列表
     * @return
     */
    @Select(select_all)
    List<HouseHold> getHouseHoldList();

    /**
     * 根据信息查询住户
     * @param query
     * @return
     */
    @Select(select_all + "where household_name like CONCAT('%',#{query},'%')" +
            "or telephone like CONCAT('%',#{query},'%')" +
            "or gender like CONCAT('%',#{query},'%')" +
            "or address like CONCAT('%',#{query},'%')" +
            "or birthday like CONCAT('%',#{query},'%')" )
    List<HouseHold> getHouseHoldListByQuery(String query);

    /**
     *
     * @param id
     * @return
     */
    @Select(select_all + "where household_id = #{id}")
    HouseHold getHouseHoldById(Integer id);

    /**
     * 根据id删除业主
     * @param id
     * @return
     */
    @Delete("delete from household where household_id = #{id}")
    Integer deleteHouseHoldById(Integer id);

    /**
     * 根据业主id 选出成员列表
     * @param id
     * @return
     */
    @Select(select_all + "where f_id = #{id}")
    List<HouseHold> getMembersByHouseHoldId(Integer id);

    /**
     * 查询业主列表
     * @return
     */
    @Select(select_all + "where is_f = '是' ")
    List<HouseHold> getHouseHoldIsFList();

    /**
     * 检索业主
     * @param query
     * @return
     */
    @Select(select_all + "where is_f = '是'" +
            "and household_name like CONCAT('%',#{query},'%')" +
            "or telephone like CONCAT('%',#{query},'%')" +
            "or gender like CONCAT('%',#{query},'%')" +
            "or address like CONCAT('%',#{query},'%')" +
            "or age like CONCAT('%',#{query},'%')")
    List<HouseHold> getHouseHoldIsFListByQuery(String query);

    /**
     * 获取所有住户数量
     * @return
     */
    @Select("select count(*) from household")
    Integer getPeopleSum();

    /**
     * 给业主添加成员
     * @param id
     * @param houseHold
     * @return
     */
    @Insert("insert into household (household_name,telephone,gender,address,birthday,f_id,is_f,create_user) " +
            "values (#{household.household_name},#{household.telephone},#{household.gender},#{household.address},#{household.birthday},#{id},'否',#{household.create_user})")
    Integer addMemberByHouseHoldId(@Param("id") Integer id, @Param("household") HouseHold houseHold);
}
