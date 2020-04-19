package com.cyx.residential_estate_property_management.Service.Smart_Service;

import com.cyx.residential_estate_property_management.Bean.SmartService.ComplaintAndAdvice;
import com.cyx.residential_estate_property_management.Dao.Smart_Service.ComplaintAndAdviceDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyx
 * @data 2020/4/19 14:53
 */
@Service
public class ComplaintAndAdviceService {

    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    ComplaintAndAdviceDao complaintAndAdviceDao;

    public  PageInfo<ComplaintAndAdvice> getComplaintAndAdviceList(String complaint_person,String complaint_type, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(complaintAndAdviceDao.getComplaintAndAdviceList(complaint_person,complaint_type));
    }

    public int add(ComplaintAndAdvice complaintAndAdvice) {
        return complaintAndAdviceDao.addComplaintAndAdvice(complaintAndAdvice);
    }

    public Integer deleteComplaintById(Integer id) {
        return complaintAndAdviceDao.deleteComplaintById(id);
    }

    public ComplaintAndAdvice getComplaintById(Integer id) {
        return complaintAndAdviceDao.getComplaintById(id);
    }

    public Integer saveComplaintAndAdvice(ComplaintAndAdvice complaintAndAdvice) {
        return baseMysqlCRUDManager.save(complaintAndAdvice);
    }
}
