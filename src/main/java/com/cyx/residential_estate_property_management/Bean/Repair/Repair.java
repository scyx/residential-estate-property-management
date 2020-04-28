package com.cyx.residential_estate_property_management.Bean.Repair;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/4/20 15:37
 */
@Data
@Table(name = "repair")
public class Repair {
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "repairer",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String repairer;
    @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String telephone;
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String type;
    @Column(name = "room",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String room;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "submit_time",type = MySqlTypeConstant.DATETIME,isNull = false)
    private Date submit_time;
    @Column(name = "repair_man",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true)
    private String repair_man;
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false,defaultValue = "未处理")
    private String status;
    @Column(name = "repair_content",type = MySqlTypeConstant.LONGTEXT,isNull = false)
    private String repair_content;
}
