package com.cyx.residential_estate_property_management.Service.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.Property.House;
import com.cyx.residential_estate_property_management.Bean.Property.Room;
import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import com.cyx.residential_estate_property_management.Dao.Smart_Service.NoticeDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx
 * @data 2020/4/13 13:28
 */
@Service
public class NoticeService {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    NoticeDao noticeDao;
    // 公告列表
    List<Notice> list;
    // 分页组件
    PageInfo<Notice> noticePageInfo;

    /**
     * 添加公告
     * @param notice
     * @return
     */
    public int addNotice(Notice notice) {
        return noticeDao.save(notice);
    }

    public PageInfo<Notice> getNoticeList(String notice_title, String notice_type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        list = noticeDao.getNoticeList(notice_title, notice_type);
        noticePageInfo = new PageInfo<>(list);
        return noticePageInfo;
    }

    public Notice getNoticeById(Integer id) {
        return noticeDao.getNoticeById(id);
    }

    public Integer save(Notice notice) {
        return baseMysqlCRUDManager.save(notice);
    }

    public Integer deleteNoticeById(Integer id) {
        return noticeDao.deleteNoticeById(id);
    }
}
