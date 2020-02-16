package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Dao.HouseHoldDao;
import com.cyx.residential_estate_property_management.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyx
 * @data 2020/2/4 20:30
 */
@Service
public class WelcomeService {
    @Autowired
    HouseHoldDao houseHoldDao;
    public Result<Map<String, Integer>> getWelComeNum() {
        Map<String,Integer> map  = new HashMap<>();
        map.put("householdNum",houseHoldDao.getPeopleSum());
        return Result.success(map);
    }
}
