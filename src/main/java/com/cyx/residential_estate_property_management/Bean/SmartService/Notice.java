package com.cyx.residential_estate_property_management.Bean.SmartService;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author cyx
 * @data 2020/4/13 13:24
 */
@Data
@Table(name = "Notice")
public class Notice {
    // 主键
    @Column(name = "id",type = MySqlTypeConstant.INT,length = 50,isNull = false,isKey = true,isAutoIncrement = true)
    private int id;
    // 公告标题
    @Column(name = "title",type = MySqlTypeConstant.VARCHAR,length = 100,isNull = false)
    private String title;
    // 公告类型
    @Column(name = "type",type = MySqlTypeConstant.VARCHAR,length = 50,isNull = false)
    private String type;
    // 发布时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "publish_time",type = MySqlTypeConstant.DATETIME,length = 50,isNull = false)
    private Date publish_time;
    // 内容
    @Column(name = "content",type = MySqlTypeConstant.LONGTEXT,isNull = false)
    private String content;
}
