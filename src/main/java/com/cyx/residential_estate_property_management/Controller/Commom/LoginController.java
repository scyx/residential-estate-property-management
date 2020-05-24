package com.cyx.residential_estate_property_management.Controller.Commom;

import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Bean.User;
import com.cyx.residential_estate_property_management.Service.Common.UserService;
import com.cyx.residential_estate_property_management.Util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyx
 * @data 2020/1/6 10:27
 * 登录
 */
@Api(tags = "登录接口",description = "提供登陆的Rest Api")
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("login" )
    public Result<Map<String, Object>> Login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        User currUser = userService.login(user);
        Map<String,Object> map = new HashMap<>();
        String token = TokenUtil.generateToken();
        if (currUser != null) {
            map.put("user",currUser);
            map.put("token",token);
            httpServletResponse.addCookie(userService.generateCookie(token));
            return Result.success(map);
        } else {
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
    }
}
