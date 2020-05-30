package com.cyx.residential_estate_property_management.Dao.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/4 15:24
 */
@Mapper
public interface RoomDao {
    String SELECT_ALL = "select id,room_id,unit_id,house_id,status,hall_num,room_num,remark,area,floor_num " +
            "from Room ";

    /**
     * 保存房屋
     * @param room
     * @return
     */
    @Insert("insert into Room (room_id,unit_id,house_id,status,hall_num,room_num,remark,area,floor_num) " +
            "values(#{room.room_id},#{room.unit_id},#{room.house_id},#{room.status},#{room.hall_num},#{room.room_num},#{room.remark},#{room.area},#{room.floor_num})")
    int save(@Param("room") Room room);

    /**
     * 获取房屋列表
     * @param house_id
     * @param unit_id
     * @param room_id
     * @return
     */
    List<Room> getRoomList(@Param("house_id") String house_id,
                           @Param("unit_id") String unit_id,
                           @Param("room_id")String room_id);

    /**
     * 根据id删除房屋
     * @param id
     * @return
     */
    @Delete("delete from Room where id = #{id}")
    Integer deleteRoomById(Integer id);

    /**
     * 根据id获取房屋信息
     * @param id
     * @return
     */
    @Select(SELECT_ALL + "where id = #{id}")
    Room getRoomById(Integer id);

    /**
     * 获取所有房屋数量
     * @return
     */
    @Select("select count(*) from Room")
    int getRoomCount();

    /**
     * 获取未售房屋数量
     * @return
     */
    @Select("select count(*) from Room where status = '未售'")
    int getRoomNotSaleCount();
}
