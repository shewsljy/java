package cn.jiayuli.allsome.config;

import cn.jiayuli.allsome.interceptor.ResponseResultInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${spring.jackson.date-format}")
    private String pattern;

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
     * 时间处理
     * 使用此方法, 以下 spring-boot: jackson时间格式化 配置 将会失效
     * spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
     * spring.jackson.time-zone=GMT+8
     * 原因: 会覆盖 @EnableAutoConfiguration 关于 WebMvcAutoConfiguration 的配置
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //localDateTime格式化
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer dateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern));
        LocalDateTimeSerializer dateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
        module.addDeserializer(LocalDateTime.class, dateTimeDeserializer);
        module.addSerializer(LocalDateTime.class, dateTimeSerializer);

        //json
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper jsonObjectMapper = Jackson2ObjectMapperBuilder.json().modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();
        //json date时间格式化
        jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonObjectMapper.setDateFormat(new SimpleDateFormat(pattern));

        //json 设置格式化内容
        jsonConverter.setObjectMapper(jsonObjectMapper);

        //xml
        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        ObjectMapper xmlObjectMapper = Jackson2ObjectMapperBuilder.xml().modules(module)
                //.defaultUseWrapper(false)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();

        //xml date时间格式化
        xmlObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlObjectMapper.setDateFormat(new SimpleDateFormat(pattern));

        //设置响应xml含有 <?xml version='1.0' encoding='UTF-8'?>
        ((XmlMapper)xmlObjectMapper).configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION,true);

        //xml 设置格式化内容
        xmlConverter.setObjectMapper(xmlObjectMapper);

        converters.add(0, jsonConverter);
        converters.add(1, xmlConverter);
    }

    /**
     * url通过format=xml,format=json来响应返回的格式
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        WebMvcConfigurer.super.configureContentNegotiation(
                configurer.favorParameter(true)
                        .parameterName("format")
                        .defaultContentType(MediaType.APPLICATION_JSON)
        );
    }
}
