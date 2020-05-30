package com.cyx.residential_estate_property_management.Bean.Property;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * 楼栋实体
 * @author cyx
 * @data 2020/3/1 14:55
 */
@Data
@Table(name = "House")
public class House {
    /**
     * 楼栋编号
     */
    @Column(name = "house_id",type = MySqlTypeConstant.INT,length = 24,isKey = true,isAutoIncrement = true,isNull = false)
    private int house_id;

    /**
     * 楼栋名称
     */
    @Column(name = "house_name",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String house_name;

    /**
     * 创建员工
     */
    @Column(name = "create_user",type = MySqlTypeConstant.VARCHAR,length = 20,isNull = false)
    private String create_user;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date create_date;

    /**
     * 楼栋备注
     */
    @Column(name = "remark",type = MySqlTypeConstant.VARCHAR,length = 500,isNull = false)
    private String remark;
}
