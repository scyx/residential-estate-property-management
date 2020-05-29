package com.cyx.residential_estate_property_management.Service.Fee;

import com.cyx.residential_estate_property_management.Bean.Fee.FeeSettingItem;
import com.cyx.residential_estate_property_management.Dao.Fee.FeeDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyx
 * @data 2020/4/26 15:07
 */
@Service
public class FeeService {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    FeeDao feeDao;

    public int addFeeSettingItem(FeeSettingItem feeSettingItem) {
        return baseMysqlCRUDManager.save(feeSettingItem);
    }

    /**
     * 获取费用项列表
     * @param feeProject
     * @param feeType
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<FeeSettingItem> getFeeSettingItemList(String feeProject, String feeType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(feeDao.getFeeSettingItemList(feeProject,feeType));
    }

    /**
     * 删除费用项
     * @param id
     * @return
     */
    public int deleteFeeSettingItemById(Integer id) {
        return feeDao.deleteFeeSettingItemById(id);
    }

    /**
     * 获取费用项信息
     * @param id
     * @return
     */
    public FeeSettingItem getFeeSettingItemById(Integer id) {
        return feeDao.getFeeSettingItemById(id);
    }

    /**
     * 保存费用项设置
     * @param feeSettingItem
     * @return
     */
    public int saveFeeSettingItem(FeeSettingItem feeSettingItem) {
        return baseMysqlCRUDManager.save(feeSettingItem);
    }
}
