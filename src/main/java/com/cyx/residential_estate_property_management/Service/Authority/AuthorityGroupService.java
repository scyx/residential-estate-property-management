package com.cyx.residential_estate_property_management.Service.Authority;

import com.cyx.residential_estate_property_management.Bean.Anthority.AuthorityGroup;
import com.cyx.residential_estate_property_management.Bean.Anthority.Authority_Group_Item;
import com.cyx.residential_estate_property_management.Dao.Authority.AuthorityGroupDao;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author cyx
 * @data 2020/1/16 16:20
 * 权限组服务
 */
@Service
public class AuthorityGroupService {
    @Autowired
    AuthorityGroupDao authorityGroupDao;
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;

    /**
     * 获取权限组列表
     * @return
     */
    public List<AuthorityGroup> getAuthorityGroupList() {
        return authorityGroupDao.getAuthorityGroupList();
    }

    /**
     * 添加权限组
     * @param name
     * @param description
     * @return
     */
    public Integer addAuthorityGroupList(String name, String description) {
        AuthorityGroup authorityGroup = new AuthorityGroup();
        authorityGroup.setAuthority_group_name(name);
        authorityGroup.setCreate_date(new Date());
        authorityGroup.setDescription(description);
        authorityGroup.setType(1);
        return baseMysqlCRUDManager.save(authorityGroup);
    }

    /**
     * 删除权限组
     * @param id
     * @return
     */
    public Integer deleteAuthorityGroupById(Integer id) {
        return authorityGroupDao.deleteAuthorityGroupById(id);
    }

    public Integer addAuthorityByGroupId(String id, List<MenuVo> authorityIdList) {
        Iterator<MenuVo> iterator = authorityIdList.iterator();
        while (iterator.hasNext()) {
            MenuVo menuVo = iterator.next();
            if (authorityGroupDao.checkAuthorityExists(id,String.valueOf(menuVo.getPsid())) > 0) {
                iterator.remove();
            }
        }
        return authorityGroupDao.addAuthorityByGroupId(id,authorityIdList);
    }

    public List<Authority_Group_Item> getAuthorityListByGroupId(String id) {
        return authorityGroupDao.getAuthorityListByGroupId(id);
    }

    public List<Authority_Group_Item> getAllAuthorityByGroupId(String id) {
        return authorityGroupDao.getAllAuthorityByGroupId(id);
    }

    public Integer deleteItemById(Integer id) {
        return authorityGroupDao.deleteItemById(id);
    }
}
