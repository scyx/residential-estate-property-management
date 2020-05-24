package com.cyx.residential_estate_property_management.Controller.Commom;

import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.Common.MenuService;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 15:44
 * 菜单权限Controller
 */
@Api(tags = "获取左侧菜单栏的接口")
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     * 根据权限动态获取左侧菜单列表
     * @return
     */
    @ApiOperation("获取左侧菜单")
    @GetMapping("getMenuList/{id}")
    public Result<List<MenuVo>> getMenuList(@PathVariable ("id")int id) {
        List<MenuVo> list = menuService.getMenuListByGroupId(id);
        for (int i = 0;i < list.size(); i++ ) {
            MenuVo m = list.get(i);
            int currentID = m.getPsid();
            m.setChildren(menuService.getChildrenById(currentID));
        }
        return Result.success(list);
    }

    @ApiOperation("获取路径列表")
    @GetMapping("getPathList/{id}")
    public Result<List<String>> getPathList(@PathVariable ("id")String id) {
        List<String> list = menuService.getPathList(id);
        return Result.success(list);
    }
}
