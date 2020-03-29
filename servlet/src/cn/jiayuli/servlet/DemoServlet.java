package cn.jiayuli.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "demoServlet", urlPatterns = "/demoServlet")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getCharacterEncoding());
        Map<String, String[]> map = new HashMap<String, String[]>();
        map = request.getParameterMap();
        for(Map.Entry<String, String[]> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue()[0]);
        }
        //设置响应编码
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //writer();
        writer.println("Hello, Demo Servlet!");
        writer.println();
        writer.println("Hello, Demo Servlet!");
        writer.println("打印中文！");
        writer.append("打印中文！");
        writer.append("打印中文！");
        writer.append("打印中文！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
