package cn.jiayuli.allsome.handler;

import cn.jiayuli.allsome.annotation.ResponseResult;
import cn.jiayuli.allsome.constant.DigestConstant;
import cn.jiayuli.allsome.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ResponseControllerAdvice implements ResponseBodyAdvice {

    // 判断是否要执行 beforeBodyWrite 方法，true为执行，false不执行，有注解标记的时候处理返回值
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        // 判断请求是否有包装标记
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(DigestConstant.RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    // 对返回值做包装处理
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Result) {
            return (Result) o;
        } else if (o instanceof String) {
            return o;
        }
        return Result.success(o);
    }
}
