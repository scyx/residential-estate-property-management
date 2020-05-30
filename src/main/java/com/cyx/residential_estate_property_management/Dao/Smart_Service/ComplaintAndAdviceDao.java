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
    /**
     * 添加投诉或建议
     * @param complaintAndAdvice
     * @return
     */
    @Insert("insert into ComplaintAndAdvice " +
            "(telephone,type,content,person,house_id,house_name,unit_id,room_id,create_date)" +
            "values (#{c.telephone},#{c.type},#{c.content},#{c.person}," +
            "#{c.house_id},#{c.house_name},#{c.unit_id},#{c.room_id},current_timestamp)")
    int addComplaintAndAdvice(@Param("c") ComplaintAndAdvice complaintAndAdvice);

    /**
     * 获取投诉建议列表
     * @param complaint_person
     * @param complaint_type
     * @return
     */
    List<ComplaintAndAdvice> getComplaintAndAdviceList(String complaint_person,String complaint_type);

    /**
     * 删除投诉或建议
     * @param id
     * @return
     */
    @Delete("delete from ComplaintAndAdvice where id = #{id}")
    Integer deleteComplaintById(Integer id);

    /**
     * 查看投诉建议信息
     * @param id
     * @return
     */
    @Select("select * from ComplaintAndAdvice where id = #{id}")
    ComplaintAndAdvice getComplaintById(Integer id);
}
