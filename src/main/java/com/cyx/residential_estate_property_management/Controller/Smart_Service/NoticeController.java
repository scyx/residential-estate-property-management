package com.cyx.residential_estate_property_management.Controller.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Smart_Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
