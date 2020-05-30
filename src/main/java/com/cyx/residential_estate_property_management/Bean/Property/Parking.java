package com.cyx.residential_estate_property_management.Bean.Property;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author cyx
 * 停车场实体
 * @data 2020/4/20 16:48
 */
@Data
@Table(name = "Parking")
public class Parking {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 停车场编号
    @Column(name = "parking_number",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String parking_number;
    // 停车场面积
    @Column(name = "area",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String area;
    // 当前状态
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String status;
    // 车位主人
    @Column(name = "owner",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true)
    private String owner;
    // 车位主人电话
    @Column(name = "owner_telephone",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = true)
    private String owner_telephone;
}
