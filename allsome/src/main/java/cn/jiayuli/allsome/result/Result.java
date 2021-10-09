package cn.jiayuli.allsome.result;

import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.util.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Result<T> {
    /**
     * 状态码，比如200代表响应成功
     */
    @JacksonXmlProperty(localName = "Code")
    @JsonProperty("Code")
    private Integer code;
    /**
     * 响应信息，用来说明响应情况
     */
    @JacksonXmlProperty(localName = "Message")
    @JsonProperty("Message")
    private String message;
    /**
     * 响应的时间戳
     */
    @JacksonXmlProperty(localName = "Timestamp")
    @JsonProperty("Timestamp")
    private Long timestamp;
    /**
     * 响应的时间
     */
    @JacksonXmlProperty(localName = "Datetime")
    @JsonProperty("Datetime")
    private LocalDateTime datetime;
    /**
     * 响应的时间
     */
//    @JacksonXmlProperty(localName = "Date")
//    @JsonProperty("Date")
//    private Date date;
    /**
     * 响应的具体数据
     */
    @JacksonXmlProperty(localName = "Data")
    @JsonProperty("Data")
    private T data;

    public Result() {
        this.timestamp = System.currentTimeMillis();
        this.datetime = DateTimeUtil.getDataTimeOfTimestamp(timestamp);
//        this.date = new Date(timestamp);
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

    public static <T> Result<T> success() {
        return new Result<T>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(ResultCode.FAILED);
    }

    public static <T> Result<T> fail(String message) {
        Result result = new Result<T>(ResultCode.FAILED);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fail(ApiException apiException) {
        Result result = new Result<T>();
        result.setCode(apiException.getCode());
        result.setMessage(apiException.getMessage());
        return result;
    }

}
