package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Bean.House;
import com.cyx.residential_estate_property_management.Bean.HouseHold;
import com.cyx.residential_estate_property_management.Dao.HouseDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx 楼栋管理服务
 * @data 2020/3/1 15:11
 */
@Service
public class HouseService implements IgetList {
    @Autowired
    HouseDao houseDao;
    /**
     * 楼栋列表
     */
    List<House> list;
    /**
     * 分页组件
     */
    PageInfo<House> housePageInfo;
    /**
     * 添加楼栋
     * @param house 楼栋实体
     * @return
     */
    public int addHouse(House house) {
        return houseDao.addHouse(house);
    }

    /**
     * 查询楼栋列表
     * @param pageNum
     * @param pageSize
     * @param query
     * @param <T>
     * @return
     */
    @Override
    public <T> PageInfo getList(Integer pageNum, Integer pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtil.isEmpty(query)){
            list = houseDao.getHouseList();
        }else {
            list = houseDao.getHouseListByQuery(query);
        }
        housePageInfo = new PageInfo<House>(list);
        return housePageInfo;
    }
}
