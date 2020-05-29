package com.cyx.residential_estate_property_management.Bean.Anthority;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/1/16 16:16
 * 权限组
 * 权限组
 */

@Table(name = "authority_group")
@Data
public class AuthorityGroup {
    // 主键
    @Column(name = "authority_group_id" ,type = MySqlTypeConstant.INT , length = 24,isKey = true,isAutoIncrement = true)
    private int authority_group_id;
    // 组名
    @Column(name = "authority_group_name" ,type = MySqlTypeConstant.VARCHAR , length = 50,isNull = false)
    private String authority_group_name;
    // 类型
    @Column(name = "type", type = MySqlTypeConstant.INT , length = 50, isNull = false)
    private int type ;
    // 创建时间
    @Column(name = "create_date" , type = MySqlTypeConstant.DATETIME , length = 100,isNull = false)
    private Date create_date;
    // 描述
    @Column(name = "description" , type = MySqlTypeConstant.VARCHAR , length = 100,isNull = false)
    private String description;
}
