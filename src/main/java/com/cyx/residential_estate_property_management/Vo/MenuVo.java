package com.cyx.residential_estate_property_management.Vo;

import java.util.List;

/**
 * @author cyx
 * @data 2020/1/7 14:29
 */
public class MenuVo {
    private int psid;
    private String name;
    private String path;
    private List<MenuVo> children;

    public List<MenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }

    public int getPsid() {
        return psid;
    }

    public void setPsid(int psid) {
        this.psid = psid;
    }

    public MenuVo(int psid, String name, String path) {
        this.psid = psid;
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
