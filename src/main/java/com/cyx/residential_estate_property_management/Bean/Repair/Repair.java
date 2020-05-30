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
@Table(name = "Repair")
public class Repair {
    // 修理单id
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 报修人
    @Column(name = "repairer",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String repairer;
    // 电话
    @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String telephone;
    // 类型
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String type;
    // 房屋编号
    @Column(name = "room",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String room;
    // 提交日期
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "submit_time",type = MySqlTypeConstant.DATETIME,isNull = false)
    private Date submit_time;
    // 修理师傅
    @Column(name = "repair_man",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true)
    private String repair_man;
    // 状态
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false,defaultValue = "未处理")
    private String status;
    // 保修内容
    @Column(name = "repair_content",type = MySqlTypeConstant.LONGTEXT,isNull = false)
    private String repair_content;
}
