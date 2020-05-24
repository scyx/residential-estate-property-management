package com.cyx.residential_estate_property_management.Dao.Common;

import com.cyx.residential_estate_property_management.Bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 12:55
 */
@Mapper
public interface UserDao {
    String table = " user ";

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select * from" + table + "where username = #{username} and password = #{password}")
    public User login(User user);

    @Select("select * from user")
    List<User> getUserList(String query);

    @Update("update user set password = #{pswd} where id = #{id}")
    Integer resetPasswordByUserId(int id,String pswd);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(Integer id);

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Select("select count(*) from user where username = #{userName}")
    int checkUserNameisExist(String userName);

    @Select("select * from user where username = #{userName}")
    User getUserByUserName(String userName);

    @Update("update user set authority_group_id = #{groupId}," +
            "authority_group_name = (select authority_group_name from authority_group where authority_group.authority_group_id = #{groupId})" +
            " where id = #{userId}")
    Integer distributeGroup(Integer userId, Integer groupId);
}
