package cn.jiayuli.allsome.handler;

import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.result.ResultCode;
import cn.jiayuli.allsome.result.ResultError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResultError handlerThrowable(Throwable e, HttpServletRequest request) {
//        log.error("发生未知异常！原因是: ", e);
//        ResultError resultError = ResultError.fail(ResultCode.FAILED, e);
//        return resultError;
//    }
    @ExceptionHandler(ApiException.class)
    public ResultError handlerApiException(ApiException apiException){
        log.error("发生未知异常！异常代码是: " + apiException.getCode());
        log.error("发生未知异常！异常原因是: " + apiException.getMessage());
        //return ResultError.fail(apiException.getCode(),apiException.getMessage());
        return ResultError.fail(apiException);
    }
}
