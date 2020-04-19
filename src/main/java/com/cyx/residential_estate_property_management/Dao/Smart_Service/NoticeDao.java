package com.cyx.residential_estate_property_management.Dao.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/13 13:28
 */
@Mapper
public interface NoticeDao {
    /**
     * 发布公告
     * @param notice
     * @return
     */
    @Insert("insert into notice (title,type,publish_time,content) " +
            "values(#{notice.title},#{notice.type},current_timestamp,#{notice.content})")
    int save(@Param("notice") Notice notice);
    /**
     * 查询公告列表
     * @param notice_title
     * @param notice_type
     */
    List<Notice> getNoticeList(String notice_title, String notice_type);

    @Select("select id,title,publish_time,type,content from notice where id = #{id}")
    Notice getNoticeById(Integer id);

    @Delete("delete from notice where id = #{id}")
    Integer deleteNoticeById(Integer id);

    @Select("select id,title,publish_time,type,content from notice order by publish_time DESC limit 5")
    List<Notice> getNoticeList_welcome();
}
