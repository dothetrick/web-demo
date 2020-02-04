package com.yourcom.proname.vo;

/**
 * 统一结果返回vo
 */
public class CommonResVo<T> {
    //状态码
    private Integer code;

    //信息
    private String msg;

    //返回类型，泛型
    private T data;

    public static <T> CommonResVo<T> success(T data) {
        return new CommonResVo<T>(200, "", data);
    }

    public static CommonResVo<Object> fail(Integer code, String msg) {
        return new CommonResVo<Object>(code, msg, null);
    }

    public static <T> CommonResVo<T> fail(Integer code, String msg, T data) {
        return new CommonResVo<T>(code, msg, data);
    }

    public CommonResVo() {
    }

    public CommonResVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
