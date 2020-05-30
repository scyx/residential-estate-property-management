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
    @Insert("insert into Notice (title,type,publish_time,content) " +
            "values(#{notice.title},#{notice.type},current_timestamp,#{notice.content})")
    int save(@Param("notice") Notice notice);
    /**
     * 查询公告列表
     * @param notice_title
     * @param notice_type
     */
    List<Notice> getNoticeList(String notice_title, String notice_type);

    /**
     * 查看公告信息
     * @param id
     * @return
     */
    @Select("select id,title,publish_time,type,content from Notice where id = #{id}")
    Notice getNoticeById(Integer id);

    /**
     * 删除公告
     * @param id
     * @return
     */
    @Delete("delete from Notice where id = #{id}")
    Integer deleteNoticeById(Integer id);

    /**
     * 获取公告数量
     * @return
     */
    @Select("select id,title,publish_time,type,content from Notice order by publish_time DESC limit 5")
    List<Notice> getNoticeList_welcome();
}
