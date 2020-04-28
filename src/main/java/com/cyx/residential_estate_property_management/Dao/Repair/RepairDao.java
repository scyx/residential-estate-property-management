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
    @Insert("insert into repair (repairer,telephone,type,submit_time,room,repair_content) " +
            "values (#{r.repairer},#{r.telephone},#{r.type},current_timestamp,#{r.room},#{r.repair_content})")
    int addRepair(@Param("r") Repair reparir);


    List<Repair> getRepairList(String repairer, String telephone, String type);

    @Select("select * from repair where id = #{id}")
    Repair getRepairById(Integer id);
}
