package cn.jiayuli.springboot.appbase;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppBaseController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpSession session;
    @Autowired
    protected ServletContext servletContext;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static final String CONTENTTYPE_HTML = "text/html";
    public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CHARTSET_UTF8 = "utf-8";

    /**
     * 从Request获取参数的String值
     * @param name
     * @return
     */
    final protected String getParam(String name) {
        return request.getParameter(name);
    }

    /**
     * 从Request获取参数列表的String值
     * @param name
     * @return
     */
    final protected String[] getParams(String name) {
        return request.getParameterValues(name);
    }

    /**
     * 从Request获取参数的long值
     * @param name
     * @param defaultValue
     * @return
     */
    final protected long getParamLong(String name, long defaultValue) {
        String valueStr = request.getParameter(name);
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try {
            return Long.valueOf(valueStr);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 从Request获取参数Map
     * @return
     */
    final protected Map<String,String> getParamMap() {
        Map<String, String> m = new HashMap<String, String>();
        Iterator<String> keys = request.getParameterMap().keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            m.put(key, getParam(key));
        }
        return m;
    }
}
