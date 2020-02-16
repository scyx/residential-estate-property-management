package com.cyx.residential_estate_property_management.Dao;

import com.cyx.residential_estate_property_management.Bean.AuthorityGroup;
import com.cyx.residential_estate_property_management.Bean.HouseHold;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
    @Select("select * from authority_group")
    List<AuthorityGroup> getAuthorityGroupList();

    /**
     * 删除权限组
     * @param id
     * @return
     */
    @Delete("delete from authority_group where authority_group_id = #{id}")
    Integer deleteAuthorityGroupById(Integer id);

}
