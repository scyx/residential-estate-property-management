package com.cyx.residential_estate_property_management.Controller;

import com.cyx.residential_estate_property_management.Bean.HouseHold;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.HouseHoldService;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/7 18:32
 * 业主Controller
 */
@Api(tags = "'业主管理-住户列表'的接口",description = "提供'业主管理-住户列表'的Rest Api")
@RestController
public class HouseHoldController {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    HouseHoldService houseHoldService;

    /**
     * 住户列表
     * @param pageNum 分页 页数
     * @param pageSize 一页多少个
     * @param query 查询参数
     * @return
     */
    @ApiOperation("获取住户列表")
    @GetMapping("households")
    public Result<PageInfo<HouseHold>> getHouseHoldList(@RequestParam Integer pageNum,
                                                        @RequestParam Integer pageSize,
                                                        @RequestParam String query) {
        PageInfo<HouseHold> houseHoldPageInfo = houseHoldService.getHouseHoldList(pageNum,pageSize,query);
        return Result.success(houseHoldPageInfo);
    }

    /**
     * 添加住户
     * @param houseHold 住户
     * @return
     */
    @ApiOperation("添加住户")
    @PostMapping("addHouseHold")
    public Result<CodeMsg> addHouseHold(@RequestBody HouseHold houseHold) {
        int res = houseHoldService.addHouseHold(houseHold);
        if(res !=0){
            return Result.success(CodeMsg.ADD_HOUSEHOLD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_HOUSEHOLD_FAIL);
    }

    /**
     * 根据id获取具体住户 用于编辑dialog
     * @param id
     * @return
     */
    @ApiOperation("据id获取具体住户")
    @GetMapping("getHouseHoldById/{id}")
    public Result<HouseHold> getHouseHoldById(@PathVariable(value = "id") Integer id) {
        HouseHold houseHold = houseHoldService.getHouseHoldById(id);
        if(houseHold != null){
            return Result.success(houseHold);
        }
        return Result.error(CodeMsg.GET_HOUSEHOLDBYID_FAIL);
    }

    /**
     * 提交编辑
     * @param id
     * @param houseHold
     * @return
     */
    @ApiOperation("编辑住户")
    @PutMapping("editHouseHold/{id}")
    public Result<CodeMsg> submitEdit(@PathVariable(value = "id") Integer id,
                                      @RequestBody HouseHold houseHold) {
        HouseHold selectHouseHold = houseHoldService.getHouseHoldById(id);
        if(selectHouseHold != null) {
            if (selectHouseHold.equals(houseHold)) {
                return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
            } else {
                Integer res = houseHoldService.save(houseHold);
                if (res != 0) return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
                else return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
            }
        } else {
            return Result.error(CodeMsg.HOUSEHOLDBYID_NOT_EXIST);
        }
    }

    /**
     * 删除住户
     * @param id
     * @return
     */
    @ApiOperation("根据id删除住户")
    @DeleteMapping("deleteHouseHold/{id}")
    public Result<CodeMsg> deleteHouseHoldById(@PathVariable(value = "id") Integer id) {
        Integer res = houseHoldService.deleteHouseHoldById(id);
        if (res != 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        } else {
            return Result.error(CodeMsg.DELETE_FAIL);
        }
    }

    /**
     *根据业主id选出业主成员
     * @param id
     * @return
     */
    @ApiOperation("根据id选出业主成员列表")
    @GetMapping("getMembersByHouseHoldId/{id}")
    public Result<List<HouseHold>> getMembersByHouseHoldId(@PathVariable Integer id) {
        List<HouseHold> list = houseHoldService.getMembersByHouseHoldId(id);
        return Result.success(list);
    }

    /**
     * 获取业主列表
     * @param pageNum 分页 页数
     * @param pageSize 一页多少个
     * @param query 查询参数
     * @return
     */
    @ApiOperation("获取业主列表")
    @GetMapping("getHouseHoldsIsFList")
    public Result<PageInfo<HouseHold>> getHouseHoldIsFList(@RequestParam Integer pageNum,
                                                        @RequestParam Integer pageSize,
                                                        @RequestParam String query) {
        System.out.println("query" + query);
        PageInfo<HouseHold> houseHoldPageInfo = houseHoldService.getHouseHoldIsFList(pageNum,pageSize,query);
        return Result.success(houseHoldPageInfo);
    }

    /**
     *
     * @param id 业主id
     * @param houseHold 添加的成员
     * @return
     */
    @ApiOperation("添加业主成员")
    @PostMapping("addMemberByHouseHoldId/{id}")
    public Result<CodeMsg> getHouseHoldIsFList(@PathVariable Integer id, @RequestBody HouseHold houseHold) {
        Integer res = houseHoldService.addMemberByHouseHoldId(id,houseHold);
        if (res != 0) {
            return Result.success(CodeMsg.ADD_MEMBER_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_MEMBER_FAIL);
    }

}
