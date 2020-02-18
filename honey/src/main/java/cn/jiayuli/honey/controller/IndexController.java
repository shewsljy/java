package cn.jiayuli.honey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController <br>
 * Description: TODO
 *
 * @author jiayu
 * @date 2019/11/05
 * @version V1.0
 */
@RestController
@RequestMapping("/")
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
    @GetMapping
    public String index() {
        return "Hello World!";
    }
}
