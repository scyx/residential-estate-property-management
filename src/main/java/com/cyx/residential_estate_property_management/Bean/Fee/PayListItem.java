package com.cyx.residential_estate_property_management.Bean.Fee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/4/28 16:10
 */
@Data
@Table(name = "PayListItem")
public class PayListItem {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "fee_type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String fee_type;
    @Column(name = "fee_project",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String fee_project;
    @Column(name = "pay_person",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String pay_person;
    @Column(name = "pay_cycle",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String pay_cycle;
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false,defaultValue = "未付款")
    private String status;
    @Column(name = "should_pay",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String should_pay;
    @Column(name = "actually_pay",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String actually_pay;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "pay_time",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date pay_time;
}
