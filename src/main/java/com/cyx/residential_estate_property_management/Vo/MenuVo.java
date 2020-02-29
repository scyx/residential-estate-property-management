package com.cyx.residential_estate_property_management.Vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单的Vo
 * @author cyx
 * @data 2020/1/7 14:29
 */
@Data
public class MenuVo {
    private int psid;
    private String name;
    private String path;
    private List<MenuVo> children;
}
