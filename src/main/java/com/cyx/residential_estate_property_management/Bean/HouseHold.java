package com.cyx.residential_estate_property_management.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/1/7 17:40
 * 住户
 */

@Table(name = "household")
@Data
public class HouseHold {
    @Column(name = "household_id" ,type = MySqlTypeConstant.INT , length = 24,isKey = true,isAutoIncrement = true)
    private int household_id;

    @Column(name = "household_name" ,type = MySqlTypeConstant.VARCHAR , length = 50,isNull = false)
    private String household_name;

    @Column(name = "telephone", type = MySqlTypeConstant.VARCHAR , length = 50, isNull = false)
    private String telephone ;

    @Column(name = "gender",type = MySqlTypeConstant.VARCHAR,length = 1,isNull = false,isKey = false)
    private String gender;

    @Column(name = "address",type = MySqlTypeConstant.VARCHAR,length = 500,isNull = false)
    private String address;

    private int age;

    @Column(name = "is_f" ,type = MySqlTypeConstant.VARCHAR , length = 10,isNull = false)
    private String is_f;

    @Column(name = "f_id" ,type = MySqlTypeConstant.INT , length = 50,isNull = true)
    private int f_id;

    @Column(name = "create_user" ,type = MySqlTypeConstant.VARCHAR , length = 50,isNull = false)
    private String create_user;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday" ,type = MySqlTypeConstant.DATE , length = 50,isNull = false)
    private Date birthday;
}
