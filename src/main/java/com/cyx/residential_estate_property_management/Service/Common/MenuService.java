package com.cyx.residential_estate_property_management.Service.Common;

import com.cyx.residential_estate_property_management.Dao.Common.MenuDao;
import com.cyx.residential_estate_property_management.Vo.MenuVOO;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 15:45
 */
@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;

    /**
     * 获取一级菜单
     * @return
     */
    public List<MenuVo> getMenuListByGroupId(int groupId) {
//        return menuDao.getMenuListtest();
         return menuDao.getMenuListByGroupId(groupId);
    }

    public List<MenuVo> getPermissionList(String groupId) {
        return menuDao.getMenuList(groupId);
    }

    public List<String> getPathList(String groupId) {
        return menuDao.getPathList(groupId);
    }

    /**
     * 获取二级菜单
     * @param currentID
     * @return
     */
    public List<MenuVo> getChildrenById(int currentID) {
        return menuDao.getChildrenById(currentID);
    }
}
