package cn.jiayuli.springbootcxf.config;

import cn.jiayuli.springbootcxf.webservice.DemoWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * ClassName: CxfConfig <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@Configuration
public class CxfConfig {

    @Autowired
    private DemoWebService demoWebService;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint demo() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),demoWebService);
        endpoint.publish("/demo");
        return endpoint;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean("cxfServletRegistration")
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }

}