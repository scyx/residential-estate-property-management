package com.cyx.residential_estate_property_management.Service.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Room;
import com.cyx.residential_estate_property_management.Dao.Property.RoomDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/4 15:24
 */
@Service
public class RoomService {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    RoomDao roomDao;
    List<Room> list;
    PageInfo<Room> roomPageInfo;

    public int addRoom(Room room) {
        return roomDao.save(room);
    }

    public PageInfo<Room> getRoomList(Integer pageNum,
                                      Integer pageSize,
                                      String houseId,
                                      String unitId,
                                      String roomId) {

        PageHelper.startPage(pageNum,pageSize);
        list = roomDao.getRoomList(houseId, unitId, roomId);
        roomPageInfo = new PageInfo<Room>(list);
        return roomPageInfo;
    }

    public int updateHouse(Room room) {
        return baseMysqlCRUDManager.save(room);
    }

    public Integer deleteRoomById(Integer id) {
        return roomDao.deleteRoomById(id);
    }

    public Room getRoomById(Integer id) {
        return roomDao.getRoomById(id);
    }

}
