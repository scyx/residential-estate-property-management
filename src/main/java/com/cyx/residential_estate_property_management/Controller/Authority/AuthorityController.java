package com.cyx.residential_estate_property_management.Controller.Authority;


import com.cyx.residential_estate_property_management.Bean.Anthority.AuthorityGroup;
import com.cyx.residential_estate_property_management.Bean.Anthority.Authority_Group_Item;
import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Authority.AuthorityGroupService;
import com.cyx.residential_estate_property_management.Service.Common.MenuService;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
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
    @Autowired
    MenuService menuService;

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

    @ApiOperation("给权限组添加权限")
    @PostMapping("addAuthorityByGroupId/{id}")
    public Result<Integer> addAuthorityByGroupId(@PathVariable String id,
                                                 @RequestBody List<MenuVo> authorityIdList) {
        Integer res = authorityGroupService.addAuthorityByGroupId(id,authorityIdList);
        if (res < 1) {
            return null;
        }
        return Result.success(res);
    }

    @ApiOperation("获取权限组下面的权限列表")
    @GetMapping("getAuthorityListByGroupId/{id}")
    public Result<List<Authority_Group_Item>> getAuthorityListByGroupId(@PathVariable String id) {
        List<Authority_Group_Item> list = authorityGroupService.getAuthorityListByGroupId(id);
        if (list != null) {
            return Result.success(list);
        }
        return null;
    }

    @ApiOperation("获取权限列表")
    @GetMapping("getPermissionList/{currentGroupId}")
    public Result<List<MenuVo>> getPermissionList(@PathVariable String currentGroupId) {
        List<MenuVo> list = menuService.getPermissionList(currentGroupId);
        for (int i = 0;i < list.size(); i++ ) {
            MenuVo m = list.get(i);
            int currentID = m.getPsid();
            m.setChildren(menuService.getChildrenById(currentID));
        }
        List<Authority_Group_Item> itemList = authorityGroupService.getAllAuthorityByGroupId(currentGroupId);
        if (itemList.size() > 0) {
            for (MenuVo menuVo : list) {
                List<MenuVo> children = menuVo.getChildren();
                for(MenuVo ch : children) {
                    int id = ch.getPsid();
                    ch.setDisabled(false);
                    for (Authority_Group_Item item : itemList) {
                        if (menuVo.getPsid() == item.getPs_id()){
                            menuVo.setDisabled(true);
                        }
                        if (id == item.getPs_id()){
                            ch.setDisabled(true);
                        }
                    }
                }
            }
        }
        return Result.success(list);
    }
    @ApiOperation("删除权限")
    @DeleteMapping("deleteItemById/{id}")
    public Result<Integer> deleteItemById(@PathVariable Integer id) {
        Integer res = authorityGroupService.deleteItemById(id);
        if (res == 1) {
            return Result.success(res);
        }
        return null;
    }

}
