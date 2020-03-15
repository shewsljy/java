package cn.jiayuli.springbootcxf.service.imp;

import cn.jiayuli.springbootcxf.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * ClassName: HelloServiceImpl <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
