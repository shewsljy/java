package cn.jiayuli.allsome.interceptor;

import cn.jiayuli.allsome.annotation.ResponseResult;
import cn.jiayuli.allsome.constant.DigestConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 判断是否在类对象上添加了注解
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
            // 设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                request.setAttribute(DigestConstant.RESPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
            } else {
                request.setAttribute(DigestConstant.RESPONSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
