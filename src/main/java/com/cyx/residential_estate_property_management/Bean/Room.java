package com.cyx.residential_estate_property_management.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author cyx
 * @data 2020/4/1 15:01
 * 房屋实体
 */
@Data
@Table(name = "Room")
public class Room {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 房屋编号
    @Column(name = "room_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int room_id;
    // 所属楼栋编号
    @Column(name = "house_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int house_id;
    // 所属单元编号
    @Column(name = "unit_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int unit_id;
    // 层数
    @Column(name = "floor_num",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int floor_num;
    // 建筑面积
    @Column(name = "area",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int area;
    // 户型
    @Column(name = "room_num",type = MySqlTypeConstant.VARCHAR,length = 100,isNull = false)
    private String room_num;
    @Column(name = "hall_num",type = MySqlTypeConstant.VARCHAR,length = 100,isNull = false)
    private String hall_num;
    // 状态
    @Column(name = "status",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String status;
    // 备注
    @Column(name = "remark",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String remark;
}
