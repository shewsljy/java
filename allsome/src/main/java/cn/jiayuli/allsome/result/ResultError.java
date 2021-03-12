package cn.jiayuli.allsome.result;

import lombok.Data;

@Data
public class ResultError<T> {
    /**
     * 状态码，比如1000代表系统错误
     */
    private Integer code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String message;
    /**
     * 响应的时间戳
     */
    private Long timestamp;
    /**
     * 异常
     */
    private String exception;

    public ResultError() {
        this.timestamp = System.currentTimeMillis();
    }

    public ResultError(ResultCode resultCode) {
        this();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ResultError(ResultCode resultCode, Throwable throwable) {
        this(resultCode);
        this.exception = throwable.getClass().getName();
    }

    public static ResultError fail(ResultCode resultCode) {
        ResultError resultError = new ResultError(resultCode);
        return resultError;
    }

    public static ResultError fail(ResultCode resultCode, Throwable throwable) {
        ResultError resultError = new ResultError(resultCode,throwable);
        return resultError;
    }

    public static ResultError fail() {
        ResultError resultError = new ResultError(ResultCode.FAILED);
        return resultError;
    }

    public static ResultError fail(Integer code, String message) {
        ResultError resultError = new ResultError();
        resultError.setCode(code);
        resultError.setMessage(message);
        return resultError;
    }
}
