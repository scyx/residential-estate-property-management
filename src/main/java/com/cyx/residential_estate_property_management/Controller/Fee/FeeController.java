package com.cyx.residential_estate_property_management.Controller.Fee;

import com.cyx.residential_estate_property_management.Bean.Fee.FeeSettingItem;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Fee.FeeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/26 15:06
 */
@RestController
public class FeeController {
    @Autowired
    FeeService feeService;
    @ApiOperation("添加费用项")
    @PostMapping("addFeeSettingItem")
    public Result<CodeMsg> addFeeSettingItem(@RequestBody FeeSettingItem feeSettingItem) {
        int res = feeService.addFeeSettingItem(feeSettingItem);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }
    @ApiOperation("获取费用项列表")
    @GetMapping("getFeeSettingItemList")
    public Result<PageInfo<FeeSettingItem>> getFeeSettingItemList(@RequestParam("feeProject") String feeProject,
                                                   @RequestParam("feeType") String feeType,
                                                   @RequestParam("pageNum") Integer pageNum,
                                                   @RequestParam("pageSize") Integer pageSize) {
        return Result.success(feeService.getFeeSettingItemList(feeProject, feeType,pageNum, pageSize));
    }

    @ApiOperation("根据id删除费用项")
    @DeleteMapping("deleteFeeSettingItemById/{id}")
    public Result<CodeMsg> deleteFeeSettingItemById(@PathVariable(value = "id") Integer id) {
        int res = feeService.deleteFeeSettingItemById(id);
        if (res > 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        }
        return Result.error(CodeMsg.DELETE_FAIL);
    }

    @ApiOperation("根据id获取具体报修信息")
    @GetMapping("getFeeSettingItemById/{id}")
    public Result<FeeSettingItem> getFeeSettingItemById(@PathVariable(value = "id") Integer id) {
        FeeSettingItem feeSettingItem = feeService.getFeeSettingItemById(id);
        if(feeSettingItem != null){
            return Result.success(feeSettingItem);
        }
        return Result.error(CodeMsg.GET_MSG_FAIL);
    }
    @ApiOperation("修改费用项")
    @PutMapping("editFeeSettingItem")
    public Result<CodeMsg> editFeeSettingItem(@RequestBody FeeSettingItem feeSettingItem) {
        int res = feeService.saveFeeSettingItem(feeSettingItem);
        if (res != 0) {
            return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        }
        return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }
}
