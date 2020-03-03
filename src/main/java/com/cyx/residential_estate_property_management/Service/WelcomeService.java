package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Dao.HouseHoldDao;
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

    /**
     * 获取首页的几个人数
     * @return
     */
    public Result<Map<String, Integer>> getWelComeNum() {
        Map<String,Integer> map  = new HashMap<>();
        map.put("householdNum",houseHoldDao.getHouseholdSum());
        map.put("livePeopleNum",houseHoldDao.getLivePeopleSum());
        return Result.success(map);
    }
}
