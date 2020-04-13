package com.cyx.residential_estate_property_management.Service.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.SmartService.Notice;
import com.cyx.residential_estate_property_management.Dao.Smart_Service.NoticeDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int addNotice(Notice notice) {
        return baseMysqlCRUDManager.save(notice);
    }
}
