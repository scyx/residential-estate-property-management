package com.cyx.residential_estate_property_management.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author cyx
 * @data 2020/1/6 10:54
 * 用户
 */
@Table(name = "User")
@Data
public class User {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 用户名
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String username;
    // 密码
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String password;
    // 姓名
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String name;
    // 电话
    @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String telephone;
    // 性别
    @Column(name = "gender",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String gender;
    // 拥有的权限组id
    @Column(name = "authority_group_id",type = MySqlTypeConstant.INT,length = 50,isNull = true)
    private int authority_group_id;
    // 拥有的权限组名称
    @Column(name = "authority_group_name",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true)
    private String authority_group_name;
}
