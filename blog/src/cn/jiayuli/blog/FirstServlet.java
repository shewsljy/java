package cn.jiayuli.blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiayu
 * @description 传统的Servlet(3.0之前)写法，相关的映射在部署描述文件 web.xml 中
 * @date 2018/2/27 11:40
 */
public class FirstServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理FirstServlet的post()请求。。。");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("处理FirstServlet的post()请求。Hello! 第一个Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理FirstServlet的get()请求。。。");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().append("处理FirstServlet的get()请求。Hello! 第一个Servlet");
    }
}
