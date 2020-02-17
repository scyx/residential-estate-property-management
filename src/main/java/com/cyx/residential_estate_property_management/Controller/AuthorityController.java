package com.cyx.residential_estate_property_management.Controller;

import com.cyx.residential_estate_property_management.Bean.AuthorityGroup;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.AuthorityGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/16 16:15
 * 权限组接口
 */
@Api(tags = "'系统管理-权限组'的接口",description = "提供'系统管理-权限组'的Rest Api")
@RestController
public class AuthorityController {
    @Autowired
    AuthorityGroupService authorityGroupService;

    /**
     * 获取权限组列表
     * @return
     */
    @ApiOperation("获取权限组列表")
    @GetMapping("getAuthorityGroupList")
    public Result<List<AuthorityGroup>> getAuthorityGroupList() {
        List<AuthorityGroup> list = authorityGroupService.getAuthorityGroupList();
        if (list != null) {
            return Result.success(list);
        }
        return null;
    }

    /**
     * 添加权限组
     * @param name
     * @param description
     * @return
     */
    @ApiOperation("添加权限组")
    @PostMapping("addAuthorityGroupList")
    public Result<Integer> addAuthorityGroupList(@RequestParam String name,
                                                 @RequestParam String description) {
        Integer res = authorityGroupService.addAuthorityGroupList(name,description);
        if (res < 1) {
            return null;
        }
        return Result.success(res);
    }

    /**
     * 删除权限组
     * @param id
     * @return
     */
    @ApiOperation("删除权限组")
    @DeleteMapping("deleteAuthorityGroupById/{id}")
    public Result<Integer> deleteAuthorityGroupById(@PathVariable Integer id) {
        Integer res = authorityGroupService.deleteAuthorityGroupById(id);
        if (res == 1) {
            return Result.success(res);
        }
        return null;
    }

}
