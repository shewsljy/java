package cn.jiayuli.blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @author jiayu
 * @description
 * @date 2018/3/26 11:19
 */
@WebServlet(name = "LoginServlet",
            urlPatterns = "/LoginServlet"
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理LoginServlet的post()请求。。。");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        System.out.println("通过request获取到请求的账号密码分别为: " + userName + "，" + passWord);

        //取配置文件路径
        String configPath = this.getServletContext().getRealPath("/WEB-INF/config.properties");
        System.out.println("读取config配置文件，路径为:" + configPath);
        Properties properties = new Properties();
        //读配置文件里面的内容
        try {
            FileInputStream inputStream = new FileInputStream(configPath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("找不到config配置文件");
        }
        //通过key获取配置文件中的值
        System.out.println("config配置如下:");
        properties.list(System.out);
        String configUserName = properties.getProperty("config.username");
        String configPassWord = properties.getProperty("config.password");
        String configMysqlIp = properties.getProperty("mysql.ip");
        String configMysqlPort = properties.getProperty("mysql.port");
        String configMysqlDatabase = properties.getProperty("mysql.database");
        String configMysqlUser = properties.getProperty("mysql.user");
        String configMysqlPassWord = properties.getProperty("mysql.password");
        properties.clone();

        //两种辨别方式
        //配置文件查询登录的账号密码
        if (userName.equals(configUserName) && passWord.equals(configPassWord)) {
            System.out.println("在配置文件中匹配到账号密码信息，登录成功。");
            response.sendRedirect("successOfConfig.jsp");
        } else {
            System.out.println("在配置文件中未匹配到账号密码信息，连接mysql数据库查询账号信息。");
            //mysql数据库查询登录的账号密码
            //捕获mysq的jdbc驱动异常
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("找不到mysql的jdbc驱动");
                e.printStackTrace();
            }
            //连接url
            String url = "jdbc:mysql://" + configMysqlIp + ":" + configMysqlPort + "/" + configMysqlDatabase + "?characterEncoding=utf8&useSSL=true";
            System.out.println("连接mysql的url: " + url);
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = (Connection) DriverManager.getConnection(url, configMysqlUser, configMysqlPassWord);
                statement = (Statement) connection.createStatement();
                //sql查询账号密码
                String sql = "select * from users where username = '" + userName +"' and password = '"+ passWord +"'";
                resultSet = statement.executeQuery(sql);
                System.out.println("mysql查询语句: " + sql);
                if (resultSet.next()) {
                    System.out.println("在数据库中匹配到了该账号密码信息，跳转至登录成功页面。");
                    response.sendRedirect("successOfMysql.jsp");
                } else {
                    System.out.println("在数据库中也没有匹配到该账号密码信息，跳转至登录失败页面。");
                    response.sendRedirect("loginError.jsp");
                }
            } catch (SQLException e) {
                System.out.println("连接不上mysql，请检查mysql的连接配置，或查看mysql是否启动。跳转至登录失败页面");
                e.printStackTrace();
                response.sendRedirect("loginError.jsp");
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
