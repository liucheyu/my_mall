package com.liucheyu.common.exception;

public enum BizCodeEnum {
    UNKNOW_EXCEPTION(10000, "系統未知錯誤"),
    NOTVALID_EXCEPTION(10001, "格式參數錯誤");

    private int code;
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
