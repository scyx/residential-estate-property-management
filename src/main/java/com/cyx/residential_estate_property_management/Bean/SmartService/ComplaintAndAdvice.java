package com.cyx.residential_estate_property_management.Bean.SmartService;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/4/19 14:41
 */
@Data
@Table(name = "ComplaintAndAdvice")
public class ComplaintAndAdvice {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 投诉人
    @Column(name = "person",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String person;
    // 投诉电话
    @Column(name = "telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String telephone;
    // 所属楼栋编号
    @Column(name = "house_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int house_id;
    // 所属楼栋编号
    @Column(name = "house_name",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String house_name;
    // 所属单元编号
    @Column(name = "unit_id",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private int unit_id;
    // 所属房屋编号
    @Column(name = "room_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int room_id;
    // 提交时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date create_date;
    // 类型
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String type;
    // 状态
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,defaultValue = "处理中",isNull = false)
    private String status;
    // 投诉内容
    @Column(name = "content",type = MySqlTypeConstant.LONGTEXT,length = 50,isNull = false)
    private String content;
}
