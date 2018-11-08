package cn.jiayuli.spring.config;

import cn.jiayuli.spring.implement.CDPlayer;
import cn.jiayuli.spring.implement.SgtPeppers;
import cn.jiayuli.spring.interfaces.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 自动扫描 CDPlayer SgtPeppers 中带有组件标识"@Component"的类
//@ComponentScan(basePackageClasses = {CDPlayer.class, SgtPeppers.class})
public class CDPlayerConfig {
    //手动 @Bean告诉spring这个方法将会返回一个对象，该对象要注册为spring应用上下文中地bean
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }
//    //手动 @Bean告诉spring这个方法将会返回一个对象，该对象要注册为spring应用上下文中地bean
//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }
    //手动 @Bean告诉spring这个方法将会返回一个对象，该对象要注册为spring应用上下文中地bean
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
