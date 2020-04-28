package com.cyx.residential_estate_property_management.Controller.Repair;

import com.cyx.residential_estate_property_management.Bean.Repair.Repair;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Repair.RepairService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/20 15:43
 */
@RestController
public class RepairController {
    @Autowired
    RepairService repairService;

    @ApiOperation("添加派单信息")
    @PostMapping("addRepair")
    public Result<CodeMsg> addRepair(@RequestBody Repair repair) {
        int res = repairService.addRepair(repair);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("获取报修列表")
    @GetMapping("getRepairList")
    public Result<PageInfo<Repair>> getRepairList(@RequestParam("repairer") String repairer,
                                                  @RequestParam("telephone") String telephone,
                                                  @RequestParam("type") String type,
                                                  @RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize) {
        return Result.success(repairService.getRepairList(repairer, telephone,type,pageNum, pageSize));
    }

    @ApiOperation("根据id获取具体报修信息")
    @GetMapping("getRepairById/{id}")
    public Result<Repair> getRepairById(@PathVariable(value = "id") Integer id) {
        Repair repair = repairService.getRepairById(id);
        if(repair != null){
            return Result.success(repair);
        }
        return Result.error(CodeMsg.GET_MSG_FAIL);
    }

}
