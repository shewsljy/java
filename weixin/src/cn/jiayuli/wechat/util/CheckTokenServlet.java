package cn.jiayuli.wechat.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@WebServlet(name = "CheckTokenServlet")
public class CheckTokenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    String TAG = "CheckTokenServlet";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("html/text; charset=UTF-8");

        String token = "WeChat";
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(TAG + ":signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr:" + echostr);

        String [] parms = new String[] {token, timestamp, nonce};
        Arrays.sort(parms);
        String parmsString = "";
        for (int i = 0; i < parms.length; i++) {
            parmsString = parmsString + parms[i];
        }
        String mParms = null;
        MessageDigest digest = null;
        try {
            digest = java.security.MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(parmsString.getBytes());
        byte messageDigest[] = digest.digest();
        StringBuffer hexString = new StringBuffer();
        // 字节数组转换为 十六进制 数
        for (int i = 0; i < messageDigest.length; i++) {
            String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        mParms = hexString.toString();// 加密结果

        /*
         * api要求： 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容， 则接入生效， 成为开发者成功，否则接入失败。
         */
        // 第三步： 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信接入成功。
        PrintWriter printWriter = response.getWriter();
        System.out.println(TAG + ":" + mParms + "---->" + signature);
        if (mParms.equals(signature)) {
            System.out.println(TAG + ":" + mParms + "---->" + signature);
            printWriter.write("echostr:" + echostr);
        } else {
            // 接入失败,不用回写
            System.out.println(TAG + "接入失败");
        }
    }
}
