package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Bean.Unit;
import com.cyx.residential_estate_property_management.Dao.UnitDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
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
    public List<Unit> getUnitList(Integer house_id) {
        return unitDao.getUnitList(house_id);
    }

    public Unit getUnitById(Integer unit_id) {
        return unitDao.getUnitById(unit_id);
    }

    public Integer save(Unit unit) {
        return baseMysqlCRUDManager.save(unit);
    }

    public Integer deleteById(Integer id) {
       return unitDao.deleteById(id);
    }
}
