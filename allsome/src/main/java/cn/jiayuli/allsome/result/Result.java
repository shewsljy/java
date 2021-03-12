package cn.jiayuli.allsome.result;

import lombok.Data;

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
    /**
     * 响应的具体数据
     */
    private T data;

    public Result() {
        this.timestamp = System.currentTimeMillis();
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

}
