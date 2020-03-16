package cn.jiayuli.springbootcxf.service.soap.imp;

import cn.jiayuli.springbootcxf.service.soap.DemoSoapService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * ClassName: DemoSoapServiceImpl <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/16
 */
@WebService(serviceName = "demoSoapService",//与接口中暴露出来的name一致
        targetNamespace = "http://soap.service.springbootcxf.jiayuli.cn",// 命名空间,一般是接口的包名倒序
        endpointInterface = "cn.jiayuli.springbootcxf.service.soap.DemoSoapService"// 接口地址
)
@Component
public class DemoSoapServiceImpl implements DemoSoapService {

    @Override
    public String sayDemo(String name) {
        return "Demo, " + name + "!(soap)";
    }
}
