package com.cyx.residential_estate_property_management.Result;

/**
 * @author cyx
 * @data 2020/1/6 11:25
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造函数 用于成功的时候
     * @param data
     */
    private  Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    /**
     * 构造函数 用于失败的时候
     * @param codemsg
     */
    private Result(CodeMsg codemsg) {
        if (codemsg == null) {
            return;
        }
        this.code = codemsg.getCode();
        this.msg = codemsg.getMsg();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功的时候调用函数
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }


    /**
     * 成功的时候调用
     * @param cm
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(CodeMsg cm) {
        return new Result<T>(cm);
    }

    /**
     * 失败的时候调用
     * @param cm
     * @param <T>
     * @return
     */
    public static  <T> Result<T>  error(CodeMsg cm){
        return new Result<T>(cm);
    }

}
