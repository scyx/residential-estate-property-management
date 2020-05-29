package com.cyx.residential_estate_property_management.Bean.Anthority;

import lombok.Data;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/6 15:42
 * 权限
 */
@Data
public class Permission {
    // 主键
    private int ps_id;
    // 权限名称
    private String ps_name;
    // 父权限id
    private int ps_pid;
    private String ps_c;
    private String ps_a;
    // 登记
    private int ps_level;
    // 孩子权限
    private List<Permission> children;
    // 路径
    private String ps_api_path;

}
