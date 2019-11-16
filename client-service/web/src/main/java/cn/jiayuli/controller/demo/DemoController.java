package cn.jiayuli.controller.demo;

import cn.jiayuli.common.client.service.demo.DemoSIDSV;
import cn.jiayuli.common.client.vo.demo.DemoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: DemoController <br>
 * Description: Demo
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
    public String demoIndex(Model model){
        logger.info("demo info");
        logger.debug("demo debug");
        logger.error("demo error");
        logger.warn("demo warn");
        logger.trace("demo trace");
        DemoVO demoVO = demoSIDSV.queryAppName();
        String appName = demoVO.getAppName();
        model.addAttribute("demoVO",demoVO);
        model.addAttribute("appName",appName);
        return "/demo/index";
    }

    @RequestMapping("/demoBody")
    @ResponseBody
    public String demoBodyIndex(){
        logger.info("demoBody info");
        logger.debug("demoBody debug");
        logger.error("demoBody error");
        logger.warn("demoBody warn");
        logger.trace("demoBody trace");
        DemoVO demoVO = demoSIDSV.queryAppName();
        String appName = demoVO.getAppName();
        return appName;
    }
}
