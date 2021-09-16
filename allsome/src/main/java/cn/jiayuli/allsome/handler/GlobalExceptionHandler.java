package cn.jiayuli.allsome.handler;

import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception){
        ApiException apiException = new ApiException(exception.getMessage());
        log.error("发生 Exception 异常！异常代码是: " + apiException.getCode());
        log.error("发生 Exception 异常！异常原因是: " + apiException.getMessage());
        return Result.fail(apiException);
    }

    @ExceptionHandler(ApiException.class)
    public Result handlerApiException(ApiException apiException){
        log.error("发生 ApiException 异常！异常代码是: " + apiException.getCode());
        log.error("发生 ApiException 异常！异常原因是: " + apiException.getMessage());
        return Result.fail(apiException);
    }
}
