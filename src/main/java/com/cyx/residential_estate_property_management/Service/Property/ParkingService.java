package com.cyx.residential_estate_property_management.Service.Property;

import com.cyx.residential_estate_property_management.Bean.Property.Parking;
import com.cyx.residential_estate_property_management.Dao.Property.ParkingDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyx
 * @data 2020/4/20 16:50
 */
@Service
public class ParkingService {
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    ParkingDao parkingDao;
    public int addParking(Parking parking) {
        return baseMysqlCRUDManager.save(parking);
    }

    public PageInfo<Parking> getParkingList(String parking_number, String status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(parkingDao.getParkingList(parking_number,status));
    }

    public Parking getParkingById(Integer id) {
        return parkingDao.getParkingById(id);
    }

    public int deleteParkingById(Integer id) {
        return parkingDao.deleteParkingById(id);
    }

    public Integer save(Parking parking) {
        return baseMysqlCRUDManager.save(parking);
    }
}
