package com.cyx.residential_estate_property_management.Controller.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.Property.Room;
import com.cyx.residential_estate_property_management.Bean.Property.Unit;
import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Property.UnitService;
import com.cyx.residential_estate_property_management.Service.Smart_Service.NoticeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/13 13:27
 */
@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @PostMapping("addNotice")
    public Result<CodeMsg> addNotice(@RequestBody Notice notice) {
        if(noticeService.addNotice(notice) > 0) {
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("获取公告列表")
    @GetMapping("getNoticeList")
    public Result<PageInfo<Notice>> getNoticeList(@RequestParam("notice_title") String notice_title,
                                              @RequestParam("notice_type") String notice_type,
                                              @RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Notice> noticePageInfo = noticeService.getNoticeList(notice_title,notice_type,pageNum,pageSize);
        return Result.success(noticePageInfo);
    }

    @ApiOperation("根据id获取公告信息")
    @GetMapping("getNoticeById/{id}")
    public Result<Notice> getNoticeById(@PathVariable("id") Integer id) {
        Notice notice = noticeService.getNoticeById(id);
        return notice==null ? null :Result.success(notice);
    }

    @ApiOperation("根据id修改公告信息")
    @PutMapping("editNotice")
    public Result<CodeMsg> editUnit(@RequestBody Notice Notice) {
        Integer res = noticeService.save(Notice);
        if (res == Notice.getId()) {
            return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        }
        return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }
    @ApiOperation("根据id删除某个公告")
    @DeleteMapping("deleteNoticeById/{id}")
    public Result<CodeMsg> deleteNoticeById(@PathVariable("id") Integer id) {
        Integer res = noticeService.deleteNoticeById(id);
        if (res > 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        }
        return Result.error(CodeMsg.DELETE_FAIL);
    }
}
