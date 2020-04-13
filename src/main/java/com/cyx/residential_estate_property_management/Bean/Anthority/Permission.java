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
    private int ps_id;
    private String ps_name;
    private int ps_pid;
    private String ps_c;
    private String ps_a;
    private int ps_level;
    private List<Permission> children;
    private String ps_api_path;

}
