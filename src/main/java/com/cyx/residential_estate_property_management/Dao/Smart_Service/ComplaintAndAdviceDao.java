package com.cyx.residential_estate_property_management.Dao.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.SmartService.ComplaintAndAdvice;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/19 14:54
 */
@Mapper
public interface ComplaintAndAdviceDao {
    @Insert("insert into complaintandadvice " +
            "(telephone,type,content,person,house_id,house_name,unit_id,room_id,create_date)" +
            "values (#{c.telephone},#{c.type},#{c.content},#{c.person}," +
            "#{c.house_id},#{c.house_name},#{c.unit_id},#{c.room_id},current_timestamp)")
    int addComplaintAndAdvice(@Param("c") ComplaintAndAdvice complaintAndAdvice);

    List<ComplaintAndAdvice> getComplaintAndAdviceList(String complaint_person,String complaint_type);

    @Delete("delete from complaintandadvice where id = #{id}")
    Integer deleteComplaintById(Integer id);

    @Select("select * from complaintandadvice where id = #{id}")
    ComplaintAndAdvice getComplaintById(Integer id);
}
