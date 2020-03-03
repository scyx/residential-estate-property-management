package com.cyx.residential_estate_property_management.Result;

/**
 * @author cyx
 * @data 2020/1/6 11:25
 */
public class CodeMsg {
    private int code;
    private String msg;


    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"登录失败！用户名或密码错误");
    public static CodeMsg ADD_HOUSEHOLD_SUCCESS = new CodeMsg(200,"添加成功！");
    public static CodeMsg SUBMIT_EDIT_SUCCESS = new CodeMsg(200,"修改信息成功！");
    public static CodeMsg ADD_MEMBER_SUCCESS = new CodeMsg(200,"添加业主成员成功！");
    public static CodeMsg ADD_MEMBER_FAIL = new CodeMsg(500200,"添加业主成员失败！");
    public static CodeMsg HOUSEHOLD_NOT_CHANGE = new CodeMsg(200,"信息无变化！");
    public static CodeMsg SUBMIT_EDIT_FAIL = new CodeMsg(200,"修改信息失败！");
    public static CodeMsg DELETE_SUCCESS = new CodeMsg(200,"删除成功！");
    public static CodeMsg DELETE_FAIL = new CodeMsg(500219,"删除失败！");
    public static CodeMsg ADD_HOUSEHOLD_FAIL = new CodeMsg(500216,"添加失败！");
    public static CodeMsg GET_HOUSEHOLDBYID_FAIL = new CodeMsg(500217,"获取住户信息失败！");
    public static CodeMsg HOUSEHOLDBYID_NOT_EXIST = new CodeMsg(500218,"住户不存在");
    public static CodeMsg ADD_HOUSE_SUCCESS = new CodeMsg(200,"添加成功！");
    public static CodeMsg ADD_HOUSE_FAIL = new CodeMsg(200,"添加失败！");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
