package com.my.pdfvisaulstamp.enums;
/**
 * @author user
 */

public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS("0", "成功"),
    /**
     * 系统异常
     */
    ERROR("-1", "系统异常"),
    /**
     * 参数异常
     */
    PARAM_ERROR("1001", "参数异常"),
    /**
     * 文件已签字，请返回刷新查看
     */
    DOUBLE_CHECK_SIGN("F1008", "文件已签字，请返回刷新查看"),
    ;


    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
