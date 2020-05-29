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

    /**
     * 获取用户列表
     * @param query
     * @return
     */
    @Select("select * from user")
    List<User> getUserList(String query);

    /**
     * 重置用户密码
     * @param id
     * @param pswd
     * @return
     */
    @Update("update user set password = #{pswd} where id = #{id}")
    Integer resetPasswordByUserId(int id,String pswd);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(Integer id);

    /**
     * 获取单个用户信息
     * @param id 用户id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    /**
     * 检查用户名是否存在
     * @param userName
     * @return
     */
    @Select("select count(*) from user where username = #{userName}")
    int checkUserNameisExist(String userName);

    @Select("select * from user where username = #{userName}")
    User getUserByUserName(String userName);

    /**
     * 更新用户的权限组
     * @param userId
     * @param groupId
     * @return
     */
    @Update("update user set authority_group_id = #{groupId}," +
            "authority_group_name = (select authority_group_name from authority_group where authority_group.authority_group_id = #{groupId})" +
            " where id = #{userId}")
    Integer distributeGroup(Integer userId, Integer groupId);

    @Select("select * from user where username = #{userName} and password = #{oldPassword}")
    User validOldPassword(String userName, String oldPassword);

    @Update("update user set password=#{newPassword} where username = #{userName} ")
    int changePassword(String userName, String newPassword);
}
