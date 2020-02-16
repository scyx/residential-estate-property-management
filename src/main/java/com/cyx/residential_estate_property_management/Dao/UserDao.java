package com.cyx.residential_estate_property_management.Dao;

import com.cyx.residential_estate_property_management.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cyx
 * @data 2020/1/6 12:55
 */
@Mapper
public interface UserDao {
    String table = " user ";
    @Select("select * from" + table + "where username = #{username} and password = #{password}")
    public User login(User user);
}
