package com.cyx.residential_estate_property_management.Bean.Household;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/1/7 17:40
 * 住户实体
 */

@Table(name = "household")
@Data
public class HouseHold {
    // 主键
    @Column(name = "household_id" ,type = MySqlTypeConstant.INT , length = 24,isKey = true,isAutoIncrement = true)
    private int household_id;
    // 住户名
    @Column(name = "household_name" ,type = MySqlTypeConstant.VARCHAR , length = 50,isNull = false)
    private String household_name;
    // 电话
    @Column(name = "telephone", type = MySqlTypeConstant.VARCHAR , length = 50, isNull = false)
    private String telephone ;
    // 性别
    @Column(name = "gender",type = MySqlTypeConstant.VARCHAR,length = 1,isNull = false,isKey = false)
    private String gender;
    // 地址
    @Column(name = "address",type = MySqlTypeConstant.VARCHAR,length = 500,isNull = false)
    private String address;

    //年龄
    private int age;
    // 是否业主
    @Column(name = "is_f" ,type = MySqlTypeConstant.VARCHAR , length = 10,isNull = false)
    private String is_f;
    // 从属业主的id
    @Column(name = "f_id" ,type = MySqlTypeConstant.INT , length = 50,isNull = true)
    private int f_id;
    // 创建用户
    @Column(name = "create_user" ,type = MySqlTypeConstant.VARCHAR , length = 50,isNull = false)
    private String create_user;
    // 出生日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday" ,type = MySqlTypeConstant.DATE , length = 50,isNull = false)
    private Date birthday;
}
