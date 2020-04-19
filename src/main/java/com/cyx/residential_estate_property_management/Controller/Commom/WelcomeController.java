package com.cyx.residential_estate_property_management.Controller.Commom;

import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Common.WelcomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author cyx
 * @data 2020/2/4 20:28
 */
@Api(tags = "首页接口",description = "提供首页相关数据的Rest Api")
@RestController
public class WelcomeController {
    @Autowired
    WelcomeService welcomeService;

    @ApiOperation("获取首页住户总数，业主总数，房屋总数、空闲数，停车位总数、空闲数")
    @GetMapping("getWelComeNum")
    public Result<Map<String, Object>> getWelComeNum() {
        return welcomeService.getWelComeNum();
    }
}
