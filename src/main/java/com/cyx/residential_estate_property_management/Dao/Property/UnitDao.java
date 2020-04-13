package com.cyx.residential_estate_property_management.Dao.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/3/16 12:49
 */
@Mapper
public interface UnitDao {
    String SELECT = "select id,unit_id,house_id,level,has_lift,remark,create_user from unit ";

    /**
     * 给楼栋添加单元
     * @param house_id
     * @param unit
     * @return
     */
    @Insert("insert into unit (unit_id,house_id,level,has_lift,remark,create_user) values" +
            "(#{unit.unit_id},#{house_id},#{unit.level},#{unit.has_lift},#{unit.remark},#{unit.create_user})")
    int addUnit(@Param("house_id") Integer house_id, @Param("unit") Unit unit);

    /**
     * 获得一个楼栋的所有单元
     * @param house_id
     * @return
     */
    @Select(SELECT + "where house_id = #{house_id}")
    List<Unit> getUnitList(Integer house_id);

    /**
     * 根据id获得具体的单元信息
     * @param unit_id
     * @return
     */
    @Select(SELECT + "where id = #{unit_id}")
    Unit getUnitById(Integer unit_id);

    @Delete("delete from unit where id = #{id}")
    Integer deleteById(Integer id);
}
