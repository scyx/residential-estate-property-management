package com.cyx.residential_estate_property_management.Bean.Fee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * 费用设置项
 * @data 2020/4/26 15:09
 */
@Data
@Table(name = "feesettingitem")
public class FeeSettingItem {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "fee_type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String fee_type;
    @Column(name = "fee_project",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String fee_project;
    @Column(name = "fee_sign",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String fee_sign;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_time",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date start_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date end_time;
    // 计算公式
    @Column(name = "calculation_formula",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String calculation_formula;
    @Column(name = "unit_price",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true,defaultValue = "-")
    private String unit_price;
    //固定费用/附加费用
    @Column(name = "add_cost",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String add_cost;
}
