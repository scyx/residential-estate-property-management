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
}
