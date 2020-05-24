package com.cyx.residential_estate_property_management.Vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单的Vo
 * @author cyx
 * @data 2020/1/7 14:29
 */
public class MenuVo {
    private int id;
    private int psid;
    private int authority_group_id;
    private String label;
    private String path;
    private int ps_level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthority_group_id() {
        return authority_group_id;
    }

    public void setAuthority_group_id(int authority_group_id) {
        this.authority_group_id = authority_group_id;
    }


    public MenuVo(int psid, String label, String path, int ps_level) {
        this.psid = psid;
        this.label = label;
        this.path = path;
        this.ps_level = ps_level;
    }
    private Boolean disabled;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public int getPs_level() {
        return ps_level;
    }

    public void setPs_level(int ps_level) {
        this.ps_level = ps_level;
    }

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
