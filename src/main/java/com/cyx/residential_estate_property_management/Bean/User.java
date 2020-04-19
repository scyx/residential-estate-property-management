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
@Table(name = "user")
@Data
public class User {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String username;
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String password;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String name;
    @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String telephone;
    @Column(name = "gender",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String gender;
}
