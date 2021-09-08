package cn.jiayuli.allsome.exception;

import cn.jiayuli.allsome.result.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException{
    /**
     * 错误状态码
     */
    private Integer code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String message;

    public ApiException() {
        super();
    }

    public ApiException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ApiException(ResultCode resultCode, Throwable throwable) {
        super(resultCode.getMessage(), throwable);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ApiException(String message) {
        super(message);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    public ApiException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = ResultCode.FAILED.getCode();
        this.message = message;
    }

    /**
     * 避免对api异常进行昂贵且无用的堆栈跟踪
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
