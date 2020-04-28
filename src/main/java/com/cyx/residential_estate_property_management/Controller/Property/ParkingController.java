package com.cyx.residential_estate_property_management.Controller.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Parking;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Property.ParkingService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/20 16:50
 */
@RestController
public class ParkingController {
    @Autowired
    ParkingService parkingService;
    @ApiOperation("添加车位信息")
    @PostMapping("addParking")
    public Result<CodeMsg> addRepair(@RequestBody Parking parking) {
        int res = parkingService.addParking(parking);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("获取车位列表")
    @GetMapping("getParkingList")
    public Result<PageInfo<Parking>> getRepairList(@RequestParam("parking_number") String parking_number,
                                                  @RequestParam("status") String status,
                                                  @RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize) {
        return Result.success(parkingService.getParkingList(parking_number, status,pageNum, pageSize));
    }

    @ApiOperation("根据id获取具体报修信息")
    @GetMapping("getParkingById/{id}")
    public Result<Parking> getRepairById(@PathVariable(value = "id") Integer id) {
        Parking parking = parkingService.getParkingById(id);
        if(parking != null){
            return Result.success(parking);
        }
        return Result.error(CodeMsg.GET_MSG_FAIL);
    }

    @ApiOperation("根据id删除具体报修信息")
    @DeleteMapping("deleteParkingById/{id}")
    public Result<CodeMsg> deleteParkingById(@PathVariable(value = "id") Integer id) {
        int res = parkingService.deleteParkingById(id);
        if (res > 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        }
        return Result.error(CodeMsg.DELETE_FAIL);
    }
    @ApiOperation("根据id修改车位信息")
    @PutMapping("editParking")
    public Result<CodeMsg> editUnit(@RequestBody Parking parking) {
        Integer res = parkingService.save(parking);
        if (res == parking.getId()) {
            return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        }
        return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }
}
