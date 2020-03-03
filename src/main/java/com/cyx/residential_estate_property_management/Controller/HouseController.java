package com.cyx.residential_estate_property_management.Controller;

import com.cyx.residential_estate_property_management.Bean.House;
import com.cyx.residential_estate_property_management.Bean.HouseHold;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.HouseService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/3/1 15:11
 */
@RestController
public class HouseController {
    @Autowired
    HouseService houseService;

    /**
     * 添加楼栋
     * @param house
     * @return
     */
    @ApiOperation("添加楼栋")
    @PostMapping("addHouse")
    public Result<CodeMsg> addHouse(@RequestBody House house) {
        int res = houseService.addHouse(house);
        if(res !=0){
            return Result.success(CodeMsg.ADD_HOUSE_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_HOUSE_FAIL);
    }

    @ApiOperation("获取楼栋列表")
    @GetMapping("getHouseList")
    public Result<PageInfo<House>> getHouseList(@RequestParam Integer pageNum,
                                                    @RequestParam Integer pageSize,
                                                    @RequestParam String query) {
        PageInfo<House> housePageInfo = houseService.getList(pageNum,pageSize,query);
        return Result.success(housePageInfo);
    }

    @ApiOperation("根据id获取楼栋信息")
    @GetMapping("getHouseById/{id}")
    public Result<House> getHouseById(@PathVariable("id") Integer id) {
        House house = houseService.getHouseById(id);
        return house==null ? null :Result.success(house);
    }

    @ApiOperation("根据id删除某个楼栋")
    @DeleteMapping("deleteHouseById/{id}")
    public Result<CodeMsg> deleteHouseById(@PathVariable("id") Integer id) {
        Integer res= houseService.deleteHouseById(id);
        return res==0 ? Result.error(CodeMsg.DELETE_FAIL) :Result.success(CodeMsg.DELETE_SUCCESS);
    }

    @ApiOperation("编辑住户")
    @PutMapping("editHouse/{id}")
    public Result<CodeMsg> submitEdit(@PathVariable(value = "id") Integer id,
                                      @RequestBody House house) {
        House currentHouse = houseService.getHouseById(id);
        if(currentHouse != null) {
            if (house.equals(currentHouse)) {
                return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
            } else {
                Integer res = houseService.save(house);
                if (res != 0) return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
                else return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
            }
        } else {
            return Result.error(CodeMsg.HOUSEHOLDBYID_NOT_EXIST);
        }
    }
}
