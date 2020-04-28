package com.cyx.residential_estate_property_management.Bean.Property;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author cyx
 * @data 2020/4/20 16:48
 */
@Data
@Table(name = "parking")
public class Parking {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 房屋编号
    @Column(name = "parking_number",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String parking_number;
    // 所属楼栋编号
    @Column(name = "area",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String area;
    // 所属单元编号
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String status;
}
