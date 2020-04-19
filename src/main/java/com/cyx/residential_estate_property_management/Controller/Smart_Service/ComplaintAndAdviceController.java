package com.cyx.residential_estate_property_management.Controller.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.Household.HouseHold;
import com.cyx.residential_estate_property_management.Bean.Property.Room;
import com.cyx.residential_estate_property_management.Bean.SmartService.ComplaintAndAdvice;
import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Smart_Service.ComplaintAndAdviceService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/19 14:53
 */
@RestController
public class ComplaintAndAdviceController {
    @Autowired
    ComplaintAndAdviceService complaintAndAdviceService;
    @ApiOperation("添加投诉或建议")
    @PostMapping("addComplaintOrAdvice")
    public Result<CodeMsg> addComplaintOrAdvice(@RequestBody ComplaintAndAdvice complaintAndAdvice) {
        int res = complaintAndAdviceService.add(complaintAndAdvice);
        return res > 0 ? Result.success(CodeMsg.ADD_SUCCESS) : Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("获取投诉或建议列表")
    @GetMapping("getComplaintAndAdviceList")
    public Result<PageInfo<ComplaintAndAdvice>> getComplaintAndAdviceList(@RequestParam String complaint_person,
                                                                          @RequestParam String complaint_type,
                                                                          @RequestParam int pageNum,
                                                                          @RequestParam int pageSize) {
         return  Result.success(complaintAndAdviceService.getComplaintAndAdviceList(complaint_person,complaint_type,pageNum,pageSize));
    }
    @ApiOperation("根据id删除某个投诉")
    @DeleteMapping("deleteComplaintById/{id}")
    public Result<CodeMsg> deleteNoticeById(@PathVariable("id") Integer id) {
        Integer res = complaintAndAdviceService.deleteComplaintById(id);
        if (res > 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        }
        return Result.error(CodeMsg.DELETE_FAIL);
    }
    @ApiOperation("根据id获取投诉或建议的内容")
    @GetMapping("getComplaintById/{id}")
    public Result<ComplaintAndAdvice> getComplaintById(@PathVariable("id") Integer id) {
        ComplaintAndAdvice c = complaintAndAdviceService.getComplaintById(id);
        return c==null ? null :Result.success(c);
    }

    @ApiOperation("编辑投诉或建议的信息")
    @PutMapping("saveComplaintAndAdvice")
    public Result<CodeMsg> saveComplaintAndAdvice(@RequestBody ComplaintAndAdvice complaintAndAdvice) {
        Integer res = complaintAndAdviceService.saveComplaintAndAdvice(complaintAndAdvice);
        if (res != 0) return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        else return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }

}
