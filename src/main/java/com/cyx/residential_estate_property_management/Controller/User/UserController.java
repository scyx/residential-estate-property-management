package com.cyx.residential_estate_property_management.Controller.User;

import com.cyx.residential_estate_property_management.Bean.User;
import com.cyx.residential_estate_property_management.Result.CodeMsg;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Common.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cyx
 * @data 2020/4/20 0:32
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @ApiOperation("获取用户列表")
    @GetMapping("getUserList")
    public Result<PageInfo<User>> getUserList(@RequestParam("query") String query,
                                                @RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("pageSize") Integer pageSize) {
        return Result.success(userService.getUserList(query,pageNum,pageSize));
    }
    @ApiOperation("重置用户名密码")
    @PutMapping("resetPasswordByUserId/{id}")
    public Result<CodeMsg> resetPasswordByUserId(@PathVariable("id") int id) {
        int res = userService.resetPasswordByUserId(id);
        return res>0 ? Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS):Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }

    @ApiOperation("添加用户")
    @PostMapping("addUser")
    public Result<CodeMsg> addUser(@RequestBody User user) {
        int res = userService.addUser(user);
        if(res !=0){
            return Result.success(CodeMsg.ADD_SUCCESS);
        }
        return Result.error(CodeMsg.ADD_FAIL);
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("deleteUserById/{id}")
    public Result<CodeMsg> deleteUserById(@PathVariable(value = "id") Integer id) {
        Integer res = userService.deleteUserById(id);
        if (res != 0) {
            return Result.success(CodeMsg.DELETE_SUCCESS);
        } else {
            return Result.error(CodeMsg.DELETE_FAIL);
        }
    }
    @ApiOperation("根据id获取具体用户信息")
    @GetMapping("getUserById/{id}")
    public Result<User> getUserById(@PathVariable(value = "id") Integer id) {
        User user = userService.getUserById(id);
        if(user != null){
            return Result.success(user);
        }
        return Result.error(CodeMsg.GET_MSG_FAIL);
    }

    @ApiOperation("根据id修改用户信息")
    @PutMapping("editUser")
    public Result<CodeMsg> editUnit(@RequestBody User user) {
        Integer res = userService.save(user);
        if (res == user.getId()) {
            return Result.success(CodeMsg.SUBMIT_EDIT_SUCCESS);
        }
        return Result.error(CodeMsg.SUBMIT_EDIT_FAIL);
    }

    @ApiOperation("查询用户名是否存在")
    @GetMapping("checkUserNameisExist")
    public Result<Integer> checkUserNameisExist(@RequestParam("userName") String userName) {
        int res = userService.checkUserNameisExist(userName);
        if(res == 0){
            return Result.success(1);
        }
        return Result.error(CodeMsg.USERNAME_ALREADY_EXIST);
    }

    @ApiOperation("给用户分配权限组")
    @PostMapping("distributeGroup/{userId}/{groupId}")
    public Result<Integer> distributeGroup(@PathVariable(value = "userId") Integer userId,
                                        @PathVariable(value = "groupId") Integer groupId) {
        Integer res = userService.distributeGroup(userId,groupId);
        if(res > 0){
            return Result.success(res);
        }
        return Result.error(CodeMsg.GET_MSG_FAIL);
    }
}
