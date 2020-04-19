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
            "from room ";

    @Insert("insert into room (room_id,unit_id,house_id,status,hall_num,room_num,remark,area,floor_num) " +
            "values(#{room.room_id},#{room.unit_id},#{room.house_id},#{room.status},#{room.hall_num},#{room.room_num},#{room.remark},#{room.area},#{room.floor_num})")
    int save(@Param("room") Room room);


    List<Room> getRoomList(@Param("house_id") String house_id,
                           @Param("unit_id") String unit_id,
                           @Param("room_id")String room_id);

    @Delete("delete from room where id = #{id}")
    Integer deleteHouseById(Integer id);

    @Select(SELECT_ALL + "where id = #{id}")
    Room getRoomById(Integer id);

    @Select("select count(*) from room")
    int getRoomCount();

    @Select("select count(*) from room where status = '未售'")
    int getRoomNotSaleCount();
}
