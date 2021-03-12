package cn.jiayuli.allsome.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    //通用成功码
    SUCCESS(200, "成功"),

    //通用错误码
    FAILED(1000, "系统错误"),
    VALIDATE_FAILED(1001, "参数校验失败"),

    //用户错误
    USER_NOT_EXIST(2000,"用户不存在"),
    USER_LOGIN_FAIL(2001,"用户名或密码错误"),
    USER_NOT_LOGIN(2002,"用户还未登录,请先登录"),
    NO_PERMISSION(2003,"权限不足,请联系管理员");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
