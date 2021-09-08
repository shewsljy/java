package cn.jiayuli.allsome.result;

import cn.jiayuli.allsome.exception.ApiException;
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

    public ResultError() {
        this.timestamp = System.currentTimeMillis();
    }

    public static ResultError fail(Integer code, String message) {
        ResultError resultError = new ResultError();
        resultError.setCode(code);
        resultError.setMessage(message);
        return resultError;
    }
    public static ResultError fail(ApiException exception) {
        ResultError resultError = new ResultError();
        resultError.setCode(exception.getCode());
        resultError.setMessage(exception.getMessage());
        return resultError;
    }
}
