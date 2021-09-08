package cn.jiayuli.wechat.config;

import cn.jiayuli.wechat.service.WXService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RefreshToken implements InitializingBean {

    @Autowired
    private WXService wxService;

    /**
     * 刷新token的定时线程
     */
//    private ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1,
//            new BasicThreadFactory().Builder().namingPattern("refresh-wx-access-token-%d").daemon(true).build());

    @Override
    public void afterPropertiesSet() {
        //scheduledPool.scheduleAtFixedRate(() -> wxService.refreshToken(),0, 7000, TimeUnit.SECONDS);
    }
}
