package com.cyx.residential_estate_property_management.Dao.Common;

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
    String api_table = " sp_permission_api ";
    String select_menu = "select a.ps_id,ps_name,ps_api_path from"+ p_table +
            " a left join"+api_table+" b on a.ps_id = b.ps_id ";

    @Select(select_menu + "where ps_level = '0'")
    List<MenuVo> getMenuList();

    @Select(select_menu + "where ps_pid = #{currentId} and ps_level = '1'")
    List<MenuVo> getChildrenById(int currentID);

}
