package com.cyx.residential_estate_property_management.Dao.Authority;


import com.cyx.residential_estate_property_management.Bean.Anthority.AuthorityGroup;
import com.cyx.residential_estate_property_management.Bean.Anthority.Authority_Group_Item;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/16 16:21
 * 权限组Dao
 */
@Mapper
public interface AuthorityGroupDao {

    /**
     * 获得权限组列表
     * @return
     */
    @Select("select * from Authority_Group")
    List<AuthorityGroup> getAuthorityGroupList();

    /**
     * 删除权限组
     * @param id
     * @return
     */
    @Delete("delete from Authority_Group where authority_group_id = #{id}")
    Integer deleteAuthorityGroupById(Integer id);

    /**
     * 给权限组添加权限
     * @param id 权限组id
     * @param authorityIdList 权限列表
     * @return
     */
    Integer addAuthorityByGroupId(@Param("id") String id, @Param("list") List<MenuVo> authorityIdList);

    /**
     * 获取权限组的权限
     * @param id 权限组id
     * @return
     */
    @Select("select * from Authority_Group_Item where authority_group_id = #{id} and ps_level = '1'")
    List<Authority_Group_Item> getAuthorityListByGroupId(String id);

    /**
     * 从权限组中删除权限
     * @param id
     * @return
     */
    @Delete("delete from Authority_Group_Item where id = #{id}")
    Integer deleteItemById(Integer id);

    /**
     * 获取权限组中所有权限
     * @param id
     * @return
     */
    @Select("select * from Authority_Group_Item where authority_group_id = #{id}")
    List<Authority_Group_Item> getAllAuthorityByGroupId(String id);

    //看当前列表是否已经有该权限了
    @Select("select count(*) from Authority_Group_Item where authority_group_id = #{groupId} and ps_id = #{authorityId}")
    int checkAuthorityExists(String groupId,String authorityId);
}
