package cn.jiayuli.honey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: IndexController <br>
 * Description: TODO
 *
 * @author jiayu
 * @date 2019/11/05
 * @version V1.0
 */
@Controller
public class IndexController {

    /**
     * MethodName: index <br>
     * Description: TODO
     *
     * @return java.lang.String
     * @author jiayu
     * @date 2019-11-06
     * @version V1.0
     */
    @RequestMapping
    public String index() {
        return "index";
    }
}
