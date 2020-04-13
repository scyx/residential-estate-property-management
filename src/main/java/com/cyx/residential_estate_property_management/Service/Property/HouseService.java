package com.cyx.residential_estate_property_management.Service.Property;

import com.cyx.residential_estate_property_management.Bean.Property.House;
import com.cyx.residential_estate_property_management.Dao.Property.HouseDao;
import com.cyx.residential_estate_property_management.Service.IgetList;
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
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
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

    /**
     * 根据id获取具体楼栋信息
     * @param id
     * @return
     */
    public House getHouseById(Integer id) {
        return houseDao.getHouseById(id);
    }

    /**
     * 根据id删除楼栋
     */
    public Integer deleteHouseById(Integer id) {
        return houseDao.deleteHouseById(id);
    }

    /**
     * 保存楼栋修改信息
     * @param house
     * @return
     */
    public Integer save(House house) {
        return baseMysqlCRUDManager.save(house);
    }
}
