package cn.jiayuli.allsome.config;

import cn.jiayuli.allsome.constant.DateTimeFormatConstant;
import cn.jiayuli.allsome.interceptor.ResponseResultInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

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
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = converter.getObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        // 针对于Date类型，文本格式化
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeFormatConstant.DEFAULT_DATE_TIME_FORMAT));
        objectMapper.setTimeZone(TimeZone.getTimeZone(DateTimeFormatConstant.DEFAULT_TIME_ZONE_GMT8));
        // 反序列化设置
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 针对于JDK新时间类。序列化时带有T的问题，自定义格式化字符串
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateTimeFormatConstant.DEFAULT_DATE_TIME_FORMAT)));
        javaTimeModule.addDeserializer(LocalDateTime.class,new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeFormatConstant.DEFAULT_DATE_TIME_FORMAT)));
        objectMapper.registerModule(javaTimeModule);
        // 设置格式化内容
        converter.setObjectMapper(objectMapper);
        converters.add(0, converter);
    }
}
