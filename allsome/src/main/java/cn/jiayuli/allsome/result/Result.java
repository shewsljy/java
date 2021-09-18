package cn.jiayuli.allsome.result;

import cn.jiayuli.allsome.constant.DateTimeFormatConstant;
import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Result<T> {
    /**
     * 状态码，比如200代表响应成功
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

    private LocalDateTime datetime;
    /**
     * 响应的具体数据
     */
    private T data;

    public Result() {
        this.timestamp = System.currentTimeMillis();
        this.datetime = DateTimeUtil.getDataTimeOfTimestamp(timestamp);
    }

    public Result(ResultCode resultCode) {
        this();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Result(ResultCode resultCode,T data) {
        this(resultCode);
        this.data = data;
    }

    public static Result success() {
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result(ResultCode.SUCCESS,data);
        return result;
    }

    public static Result fail() {
        Result result = new Result(ResultCode.FAILED);
        return result;
    }

    public static Result fail(String message) {
        Result result = new Result(ResultCode.FAILED);
        result.setMessage(message);
        return result;
    }

    public static Result fail(ApiException apiException) {
        Result result = new Result();
        result.setCode(apiException.getCode());
        result.setMessage(apiException.getMessage());
        return result;
    }

}
