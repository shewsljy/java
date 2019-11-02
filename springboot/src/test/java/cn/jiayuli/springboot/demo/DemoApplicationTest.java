package cn.jiayuli.springboot.demo;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {

    @Test
    public void contextLoads() {

    }

    @Autowired
    VelocityEngine velocityEngine;

    @Test
    public void velocityTest() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", "这是DemoTest的内容。。。");
        model.put("time", dateFormat.format(date));
        System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/demo/index.vm", "UTF-8", model));
    }
}
