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
    USER_NOT_EXIST(2000,"账户不存在"),
    USER_EXIST(2001,"账户已存在"),
    USER_LOGIN_PW_FAIL(2002,"账号密码错误"),
    USER_NOT_LOGIN(2003,"用户还未登录,请先登录"),
    USER_CHANGE_PW_FAIL(2004,"账户密码更改失败"),
    USER_CREATE_FAIL(2005,"账户创建失败"),
    USER_LOCKED(2006,"账户已锁定"),
    USER_LOGIN_COUNT_FAIL(2007,"账号密码错误次数过多"),
    USER_LOGIN_FAIL(2008,"账号密码登录失败"),

    NO_PERMISSION(3000,"权限不足,请联系管理员");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
