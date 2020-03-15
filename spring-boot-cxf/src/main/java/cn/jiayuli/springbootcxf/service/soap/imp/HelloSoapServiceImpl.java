package cn.jiayuli.springbootcxf.service.soap.imp;

import cn.jiayuli.springbootcxf.service.soap.HelloSoapService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * ClassName: HelloServiceImpl <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@WebService(serviceName = "HelloSoapService",//与接口中暴露出来的name一致
        targetNamespace = "http://soap.service.springbootcxf.jiayuli.cn",// 命名空间,一般是接口的包名倒序
        endpointInterface = "cn.jiayuli.springbootcxf.service.soap.HelloSoapService"// 接口地址
)
@Component
public class HelloSoapServiceImpl implements HelloSoapService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!(soap)";
    }
}
