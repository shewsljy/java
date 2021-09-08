package cn.jiayuli.wechat.service;

import cn.jiayuli.wechat.config.WXConfig;
import cn.jiayuli.wechat.constant.WXConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXService {

    @Autowired
    private WXConfig wxConfig;

    /**
     * 刷新微信公众号的access_token
     * https请求:
     *       https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     * 微信返回数据:
     *       {"access_token":"ACCESS_TOKEN","expires_in":7200}
     * @return
     */
//    public String refreshToken() {
//        String redisKey = String.format(WXConstant.ACCESS_TOKEN_KEY,wxConfig.getAppID());
//        String url = String.format(WXConstant.WX_ACCESS_TOKEN_URL,wxConfig.getAppID(),wxConfig.getSecret());
//        //HttpClient工具根据项目自行修改
//        HttpClientUtil.HttpResult result = HttpClientUtil.getInstance().post(url,"");
//        log.info("获取微信公众号的access_token: {}", result.getContent());
//        String accessToken = JSON.parseObject(result.getContent()).getString("access_token");
//        //redis工具根据项目自行修改
//        CacheUtils.set(redisKey, accessToken, 7200);
//        return accessToken;
//    }
}
