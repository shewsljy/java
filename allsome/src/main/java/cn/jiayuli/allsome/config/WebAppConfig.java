package cn.jiayuli.allsome.config;

import cn.jiayuli.allsome.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 手动添加ResponseResultInterceptor拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ResponseResultInterceptor interceptor = new ResponseResultInterceptor();
        registry.addInterceptor(interceptor);
        //调用父类的拦截器继续Go
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     *  处理返回类型为String时，Spring框架默认使用的类型转换器为StringHttpMessageConverter，会报错
     *  将MappingJackson2HttpMessageConverter的排序提前
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0,new MappingJackson2HttpMessageConverter());
    }
}
