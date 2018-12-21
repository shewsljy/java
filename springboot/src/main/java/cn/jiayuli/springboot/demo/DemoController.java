package cn.jiayuli.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class DemoController {

    @RequestMapping("/index")
    public String indexTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/index的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "index";
    }

    @RequestMapping("/list")
    public String listTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/list的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "list";
    }

    @RequestMapping("/map")
    public String mapTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/map的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "map";
    }

    @RequestMapping("/detail")
    public String detailTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/detail的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "detail";
    }

    @RequestMapping("/express")
    public String expressTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/express的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "express";
    }

    @RequestMapping("/invoice")
    public String invoiceTest(Model model) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("message", "这是/invoice的内容。。。");
        model.addAttribute("time", dateFormat.format(date));
        return "invoice";
    }
}
