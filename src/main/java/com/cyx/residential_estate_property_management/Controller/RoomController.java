package com.cyx.residential_estate_property_management.Controller;

import com.cyx.residential_estate_property_management.Bean.House;
import com.cyx.residential_estate_property_management.Bean.HouseHold;
import com.cyx.residential_estate_property_management.Bean.Room;
import com.cyx.residential_estate_property_management.Bean.Unit;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.RoomService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/4 15:23
 */
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;
    /**
     * 添加房屋
     * @param room
     * @return
     */
    @ApiOperation("添加房屋")
    @PostMapping("addRoom")
    public Result<CodeMsg> addRoom(@RequestBody Room room) {
        int res = roomService.addRoom(room);
        if(res !=0){
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    /**
     *
     * @param houseId 所属楼栋编号
     * @param unitId 单元编号
     * @param roomId 房屋编号
     * @param pageNum 页数
     * @param pageSize 一页几个
     * @return
     */
    @ApiOperation("获取房屋列表")
    @GetMapping("getRoomList")
    public Result<PageInfo<Room>> getRoomList(@RequestParam String houseId,
                                              @RequestParam String unitId,
                                              @RequestParam String roomId,
                                              @RequestParam Integer pageNum,
                                              @RequestParam Integer pageSize) {
        PageInfo<Room> roomPageInfo = roomService.getRoomList(pageNum,pageSize,houseId,unitId,roomId);
        return Result.success(roomPageInfo);
    }

    /**
     *
     * @param room
     * @return
     */
    @ApiOperation("编辑房屋信息")
    @PutMapping("editRoom")
    public Result<CodeMsg> editHouse(@RequestBody Room room) {
        Integer res = roomService.updateHouse(room);
        if (res != 0) return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        else return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }

    @ApiOperation("根据id删除某个房屋")
    @DeleteMapping("deleteRoomById/{id}")
    public Result<CodeMsg> deleteRoomById(@PathVariable("id") Integer id) {
        Integer res= roomService.deleteRoomById(id);
        return res==0 ? Result.error(CodeMsg.DELETE_FAIL) :Result.success(CodeMsg.DELETE_SUCCESS);
    }


    @ApiOperation("根据id获取房屋信息")
    @GetMapping("getRoomById/{id}")
    public Result<Room> getRoomById(@PathVariable("id") Integer id) {
        Room room = roomService.getRoomById(id);
        return room==null ? null :Result.success(room);
    }
}
