package com.cyx.residential_estate_property_management.Service.Common;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * @author cyx
 * @data 2020/3/2 15:27
 */
@Service
public interface IgetList {
    <T> PageInfo<T> getList(Integer pageNum, Integer pageSize, String query);
}
