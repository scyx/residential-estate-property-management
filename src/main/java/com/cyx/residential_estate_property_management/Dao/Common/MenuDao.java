package com.cyx.residential_estate_property_management.Dao.Common;

import com.cyx.residential_estate_property_management.Vo.MenuVOO;
import com.cyx.residential_estate_property_management.Vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 15:46
 */
@Mapper
public interface MenuDao {
    String p_table = " sp_permission ";
    String select_menu = "select ps_id,ps_name,ps_api_path,ps_level from"+ p_table;
    String test_select_menu = "SELECT ps_id,ps_name,ps_api_path,ps_level FROM sp_permission WHERE ps_id IN (SELECT ps_id FROM authority_group_item ";

    @Select(select_menu + "where ps_level = '0'")
    List<MenuVo> getMenuList(String id);

    @Select(select_menu + "where ps_pid = #{currentId} and ps_level = '1'")
    List<MenuVo> getChildrenById(int currentID);

    @Select(test_select_menu + "WHERE authority_group_id = #{groupId}) AND ps_level = '0'")
    List<MenuVo> getMenuListByGroupId(int groupId);

    @Select(select_menu + "where ps_level = '0'")
    List<MenuVo> getMenuListtest();

    @Select("SELECT ps_api_path from sp_permission " +
            "WHERE ps_id IN (SELECT ps_id FROM authority_group_item WHERE authority_group_id =#{groupId} )")
    List<String> getPathList(String groupId);
}
