package com.cyx.residential_estate_property_management.Vo;

/**
 * @author cyx
 * @data 2020/5/5 0:34
 */
public class MenuVOO {
    private int id;
    private int authority_group_id;
    private int ps_id;
    private String label;
    private String ps_api_path;
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

    public int getPs_id() {
        return ps_id;
    }

    public void setPs_id(int ps_id) {
        this.ps_id = ps_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPs_api_path() {
        return ps_api_path;
    }

    public void setPs_api_path(String ps_api_path) {
        this.ps_api_path = ps_api_path;
    }

    public int getPs_level() {
        return ps_level;
    }

    public void setPs_level(int ps_level) {
        this.ps_level = ps_level;
    }
}
