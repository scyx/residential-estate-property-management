package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Bean.HouseHold;
import com.cyx.residential_estate_property_management.Dao.HouseHoldDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/7 19:06
 */
@Service
public class HouseHoldService {
    @Autowired
    HouseHoldDao houseHoldDao;
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;

    PageInfo<HouseHold> houseHoldpageInfo;
    List<HouseHold> list;

    /**
     * 获取住户列表
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    public PageInfo<HouseHold> getHouseHoldList(Integer pageNum,
                                                 Integer pageSize,
                                                 String query) {
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtil.isEmpty(query)){
            list = houseHoldDao.getHouseHoldList();
        }else {
            list = houseHoldDao.getHouseHoldListByQuery(query);
        }
        houseHoldpageInfo = new PageInfo<HouseHold>(list);
        return houseHoldpageInfo;
    }

    /**
     * 添加住户
     * @param houseHold
     * @return
     */
    public int addHouseHold(HouseHold houseHold) {
        return baseMysqlCRUDManager.save(houseHold);
    }

    /**
     * 根据id获取住户详细信息
     * @param id
     * @return
     */
    public HouseHold getHouseHoldById(Integer id) {
        return houseHoldDao.getHouseHoldById(id);
    }

    /**
     * 保存住户
     * @param houseHold
     * @return
     */
    public int save(HouseHold houseHold) {
        return baseMysqlCRUDManager.save(houseHold);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer deleteHouseHoldById(Integer id) {
        return houseHoldDao.deleteHouseHoldById(id);
    }

    /**
     * 根据业主id选出业主成员
     * @param id
     * @return
     */
    public List<HouseHold> getMembersByHouseHoldId(Integer id) {
        return houseHoldDao.getMembersByHouseHoldId(id);
    }


    /**
     * 获取业主列表
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    public PageInfo<HouseHold> getHouseHoldIsFList(Integer pageNum,
                                                Integer pageSize,
                                                String query) {
        if(StringUtil.isEmpty(query)){
            PageHelper.startPage(pageNum,pageSize);
            list = houseHoldDao.getHouseHoldIsFList();
            houseHoldpageInfo = new PageInfo<HouseHold>(list);
            return houseHoldpageInfo;
        }
        list = houseHoldDao.getHouseHoldIsFListByQuery(query);
        houseHoldpageInfo = new PageInfo<>(list);
        return houseHoldpageInfo;
    }

    /**
     * 添加业主成员
     * @param id 业主id
     * @param houseHold 业主成员信息
     * @return
     */
    public Integer addMemberByHouseHoldId(Integer id, HouseHold houseHold) {
        return houseHoldDao.addMemberByHouseHoldId(id,houseHold);
    }
}
