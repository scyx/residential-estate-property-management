package com.cyx.residential_estate_property_management.Service.Repair;

import com.cyx.residential_estate_property_management.Bean.Repair.Repair;
import com.cyx.residential_estate_property_management.Dao.Repair.RepairDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyx
 * @data 2020/4/20 15:43
 */
@Service
public class RepairService {
    @Autowired
    RepairDao repairDao;
    public int addRepair(Repair repair) {
        return repairDao.addRepair(repair);
    }

    /**
     * 获取报修单列表
     * @param repairer
     * @param telephone
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Repair> getRepairList(String repairer, String telephone, String type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(repairDao.getRepairList(repairer,telephone,type));
    }

    /**
     * 获取报修单信息
     * @param id
     * @return
     */
    public Repair getRepairById(Integer id) {
        return repairDao.getRepairById(id);
    }
}
