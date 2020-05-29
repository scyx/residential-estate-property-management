package com.cyx.residential_estate_property_management.Bean.Property;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * @author cyx
 * @data 2020/3/5 16:57
 * 单元 实体
 */
@Data
@Table(name = "unit")
public class Unit {
    /**
     * 主键
     */
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 20,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    /**
     * 单元编号
     */
    @Column(name = "unit_id",type = MySqlTypeConstant.INT,length = 50,isNull = false)
    private int unit_id;
    /**
     * 楼栋id，即属于哪个楼栋
     */
    @Column(name = "house_id",type = MySqlTypeConstant.INT,length = 20,isNull = false)
    private int house_id;
    /**
     * 总层数
     */
    @Column(name = "level",type = MySqlTypeConstant.INT,length = 20,isNull = false)
    private int level;
    /**
     * 是否有电梯
     */
    @Column(name = "has_lift",type = MySqlTypeConstant.VARCHAR,length = 20,isNull = false)
    private String has_lift;
    /**
     * 创建员工
     */
    @Column(name = "create_user",type = MySqlTypeConstant.VARCHAR,length = 20,isNull = false)
    private String create_user;
    /**
     * 备注
     */
    @Column(name = "remark",type = MySqlTypeConstant.VARCHAR,length = 500,isNull = false)
    private String remark;
}
