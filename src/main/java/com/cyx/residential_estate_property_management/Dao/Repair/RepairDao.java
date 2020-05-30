package com.cyx.residential_estate_property_management.Dao.Repair;

import com.cyx.residential_estate_property_management.Bean.Repair.Repair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/20 15:43
 */
@Mapper
public interface RepairDao {
    /**
     * 添加报修单
     * @param reparir
     * @return
     */
    @Insert("insert into Repair (repairer,telephone,type,submit_time,room,repair_content) " +
            "values (#{r.repairer},#{r.telephone},#{r.type},current_timestamp,#{r.room},#{r.repair_content})")
    int addRepair(@Param("r") Repair reparir);

    /**
     * 获取报修列表
     * @param repairer
     * @param telephone
     * @param type
     * @return
     */
    List<Repair> getRepairList(String repairer, String telephone, String type);

    /**
     * 获取报修单详情
     * @param id
     * @return
     */
    @Select("select * from Repair where id = #{id}")
    Repair getRepairById(Integer id);
}
