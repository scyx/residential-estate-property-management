package com.cyx.residential_estate_property_management.Controller.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Unit;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Property.UnitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/3/16 12:48
 */
@RestController
public class UnitController {
    @Autowired
    UnitService unitService;

    /**
     *
     * @param house_id 当前楼栋id
     * @param unit 单元
     * @return
     */
    @ApiOperation("给楼栋添加单元")
    @PostMapping("addUnit/{id}")
    public Result<CodeMsg> addUnit(@PathVariable("id") Integer house_id, @RequestBody Unit unit) {
        Integer res = unitService.addUnit(house_id,unit);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    /**
     *
     * @param house_id 当前楼栋id
     * @return
     */
    @ApiOperation("获取单元列表")
    @GetMapping("getUnitList/{house_id}")
    public Result<List<Unit>> getUnitList(@PathVariable("house_id") Integer house_id) {
        List<Unit> list = unitService.getUnitList(house_id);
        return Result.success(list);
    }

    @ApiOperation("根据id获取单元信息")
    @GetMapping("getUnitById/{unit_id}")
    public Result<Unit> getUnitById(@PathVariable("unit_id") Integer unit_id) {
        Unit unit = unitService.getUnitById(unit_id);
        return Result.success(unit);
    }

    @ApiOperation("根据id修改单元信息")
    @PutMapping("editUnit")
    public Result<CodeMsg> editUnit(@RequestBody Unit unit) {
        Integer res = unitService.save(unit);
        if (res == unit.getId()) {
            return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        }
        return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }

    @ApiOperation("根据id删除某个单元")
    @DeleteMapping("deleteUnitById/{id}")
    public Result<CodeMsg> deleteUnitById(@PathVariable("id") Integer id) {
        Integer res = unitService.deleteById(id);
        System.out.println(res);
        if (res > 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        }
        return Result.error(CodeMsg.DELETE_FAIL);
    }
}
