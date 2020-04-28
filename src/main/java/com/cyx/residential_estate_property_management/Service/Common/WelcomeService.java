package com.cyx.residential_estate_property_management.Service.Common;

import com.cyx.residential_estate_property_management.Dao.Household.HouseHoldDao;
import com.cyx.residential_estate_property_management.Dao.Property.ParkingDao;
import com.cyx.residential_estate_property_management.Dao.Property.RoomDao;
import com.cyx.residential_estate_property_management.Dao.Smart_Service.NoticeDao;
import com.cyx.residential_estate_property_management.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页的服务 主要用于查询业主 住户 房屋 车位的数量以及最新公告
 * @author cyx
 * @data 2020/2/4 20:30
 */
@Service
public class WelcomeService {
    @Autowired
    HouseHoldDao houseHoldDao;
    @Autowired
    RoomDao roomDao;
    @Autowired
    NoticeDao noticeDao;
    @Autowired
    ParkingDao parkingDao;
    /**
     * 获取首页的几个人数
     * @return
     */
    public Result<Map<String, Object>> getWelComeNum() {
        Map<String,Object> map  = new HashMap<>();
        map.put("householdNum",houseHoldDao.getHouseholdSum());
        map.put("livePeopleNum",houseHoldDao.getLivePeopleSum());
        map.put("roomNum",roomDao.getRoomCount());
        map.put("parkingNum",parkingDao.getParkingNum());
        map.put("parkingNum_notSale",parkingDao.getParkingNum_NotSale());
        map.put("roomNum_notSale",roomDao.getRoomNotSaleCount());
        map.put("noticeList",noticeDao.getNoticeList_welcome());
        return Result.success(map);
    }
}
