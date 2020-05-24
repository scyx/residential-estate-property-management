package com.cyx.residential_estate_property_management.Bean.Anthority;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author cyx
 * @data 2020/4/29 13:47
 */
@Table(name = "Authority_Group_Item")
@Data
public class Authority_Group_Item {
    @Column(name = "id" ,type = MySqlTypeConstant.INT , length = 24,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "authority_group_id" ,type = MySqlTypeConstant.INT , length = 24,isNull = false)
    private int authority_group_id;
    @Column(name = "ps_id" ,type = MySqlTypeConstant.INT , length = 24 ,isNull = false)
    private int ps_id;
    @Column(name = "ps_level" ,type = MySqlTypeConstant.INT , length = 24 ,isNull = false)
    private int ps_level;
    @Column(name = "label" ,type = MySqlTypeConstant.VARCHAR , length = 24 ,isNull = false)
    private String label;
}
