package cn.jiayuli.controller.demo;

import cn.jiayuli.common.client.service.demo.DemoSIDSV;
import cn.jiayuli.common.client.vo.demo.DemoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: DemoController <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/11/14
 */
@Controller
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoSIDSV demoSIDSV;

    @RequestMapping("/demo")
    @ResponseBody
    public String demoIndex(){
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
        logger.warn("warn");
        logger.trace("trace");
        DemoVO demoVO = demoSIDSV.queryAppName();
        String appName = demoVO.getAppName();
        return appName;
    }
}
