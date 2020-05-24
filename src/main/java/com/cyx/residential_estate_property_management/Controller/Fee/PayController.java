package com.cyx.residential_estate_property_management.Controller.Fee;

import com.cyx.residential_estate_property_management.Bean.Fee.PayListItem;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Fee.PayService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/28 16:13
 */
@RestController
public class PayController {
    @Autowired
    PayService payService;

    @ApiOperation("添加缴费项")
    @PostMapping("addPayListItem")
    public Result<CodeMsg> addPayListItem(@RequestBody PayListItem payListItem) {
        int res = payService.addPayListItem(payListItem);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("获取缴费项列表")
    @GetMapping("getPayItemList")
    public Result<PageInfo<PayListItem>> getPayItemList(@RequestParam("pay_person") String pay_person,
                                                        @RequestParam("start_time") String start_time,
                                                        @RequestParam("end_time") String end_time,
                                                        @RequestParam("pageNum") Integer pageNum,
                                                        @RequestParam("pageSize") Integer pageSize) {
        return Result.success(payService.getPayItemList(pay_person, start_time, end_time, pageNum, pageSize));
    }

}
