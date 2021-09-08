package cn.jiayuli.wechat.notify;

import cn.jiayuli.wechat.annotation.NotifyType;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotifyFactory implements ApplicationContextAware {

    /**
     * 策略列表
     */
    private Map<NotifyEnum, WeChatNotify> notifyMap = new HashMap<>();


    /**
     * 工厂获取事件执行策略对象
     *
     * @param notifyType
     * @return
     */
    public WeChatNotify loadWeChatNotify(NotifyEnum notifyType) {
        WeChatNotify notify = notifyMap.get(notifyType);
        return notify;
    }


    /**
     * 扫描带有NotifyType注解的bean组装成map
     * 新加策略时 在类上加入注解@NotifyType(...)即可
     * 支持枚举多个策略事件
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> notifyBeanMap = applicationContext.getBeansWithAnnotation(NotifyType.class);
        Map<NotifyEnum[], WeChatNotify> annoValueBeanMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : notifyBeanMap.entrySet()) {
            if (ArrayUtils.contains(entry.getValue().getClass().getInterfaces(),WeChatNotify.class)) {
                WeChatNotify weChatNotify = (WeChatNotify) entry.getValue();
                annoValueBeanMap.put(weChatNotify.getClass().getAnnotation(NotifyType.class).value(),weChatNotify);
            }
        }
        for (Map.Entry<NotifyEnum[], WeChatNotify> entry : annoValueBeanMap.entrySet()) {
            NotifyEnum[] notifyEnums = entry.getKey();
            for (NotifyEnum notifyEnum : notifyEnums) {
                notifyMap.put(notifyEnum,entry.getValue());
            }
        }
    }
}
