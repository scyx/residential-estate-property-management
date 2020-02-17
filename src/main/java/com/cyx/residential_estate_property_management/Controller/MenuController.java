package com.cyx.residential_estate_property_management.Controller;

import com.cyx.residential_estate_property_management.Result.Result;
import com.cyx.residential_estate_property_management.Service.MenuService;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 15:44
 * 菜单权限Controller
 */
@Api(tags = "获取左侧菜单栏的接口",description = "提供左侧菜单栏的Rest Api")
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     * 根据权限动态获取左侧菜单列表 根据权限动态获取(待完成)
     * @return
     */
    @ApiOperation("获取左侧菜单")
    @GetMapping("getMenuList")
    public Result<List<MenuVo>> getMenuList() {
        List<MenuVo> list = menuService.getMenuList();
        for (int i = 0;i < list.size(); i++ ) {
            MenuVo m = list.get(i);
            int currentID = m.getPsid();
            m.setChildren(menuService.getChildrenById(currentID));
        }
        return Result.success(list);
    }
}
