package cn.jiayuli.allsome.config;

import cn.jiayuli.allsome.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * SpringMVC 需要手动添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ResponseResultInterceptor interceptor = new ResponseResultInterceptor();
        registry.addInterceptor(interceptor);
        //调用父类的拦截器继续Go
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
