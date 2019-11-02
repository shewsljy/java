package cn.jiayuli.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    public String indexTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/index的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/index";
    }

    @RequestMapping("/list")
    public String listTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/list的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/list";
    }

    @RequestMapping("/map")
    public String mapTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/map的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/map";
    }

    @RequestMapping("/detail")
    public String detailTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/detail的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/detail";
    }

    @RequestMapping("/detail/express")
    public String expressTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/detail/express的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/detail/express";
    }

    @RequestMapping("/detail/invoice")
    public String invoiceTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/demo/detail/invoice的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "demo/detail/invoice";
    }

    @RequestMapping("/postForm")
    @ResponseBody
    public Map<String, Object> postForm(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        return map;
    }
}
