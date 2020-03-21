package cn.jiayuli.springbootcxf.service.imp;

import cn.jiayuli.springbootcxf.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * ClassName: DemoServiceImpl <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String printDemo(String name) {
        return "Demo, " + name + "!";
    }
}
