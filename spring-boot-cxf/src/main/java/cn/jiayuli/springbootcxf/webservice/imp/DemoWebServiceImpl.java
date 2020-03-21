package cn.jiayuli.springbootcxf.webservice.imp;

import cn.jiayuli.springbootcxf.webservice.DemoWebService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * ClassName: DemoWebServiceImpl <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/16
 */
@WebService
        (
        serviceName = "demoWebService",//与接口中暴露出来的name一致
        targetNamespace = "http://webservice.springbootcxf.jiayuli.cn/"
        ,// 命名空间,一般是接口的包名倒序
        portName = "demoWebServicePort"
        ,//
        endpointInterface = "cn.jiayuli.springbootcxf.webservice.DemoWebService"// 接口地址
)
@Component
public class DemoWebServiceImpl implements DemoWebService {

    @Override
    public String sayDemo(String name) {
        return "Demo, " + name + "!(This is a webService .)";
    }
}
