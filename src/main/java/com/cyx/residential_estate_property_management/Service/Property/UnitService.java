package com.cyx.residential_estate_property_management.Service.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Unit;
import com.cyx.residential_estate_property_management.Dao.Property.UnitDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx
 * @data 2020/3/16 12:48
 */
@Service
public class UnitService {
    @Autowired
    UnitDao unitDao;
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    PageInfo<Unit> unitPageInfo;

    /**
     * 添加单元
     * @param house_id
     * @param unit
     * @return
     */
    public Integer addUnit(Integer house_id, Unit unit) {
        return unitDao.addUnit(house_id,unit);

    }

    /**
     * 获取单元列表
     * @param house_id
     * @return
     */
    public PageInfo<Unit> getUnitList(String query,Integer house_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        unitPageInfo = new PageInfo<>(unitDao.getUnitList(query,house_id));
        return unitPageInfo;
    }

    public Unit getUnitById(Integer unit_id) {
        return unitDao.getUnitById(unit_id);
    }

    public Integer save(Unit unit) {
        return baseMysqlCRUDManager.save(unit);
    }

    public Integer deleteUnitById(Integer id) {
       return unitDao.deleteUnitById(id);
    }
}
