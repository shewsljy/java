package cn.jiayuli.wechat.notify;

import java.util.Map;

public interface WeChatNotify {

    /**
     * 上层事件推送策略抽象接口
     *
     * @param xmlMap 微信推送的参数数据
     * @return  返回给微信的回复信息 如：接收到用户发消息事件，我们给他返回“我收到啦”
     * @throws Exception
     */
    public String weChatNotify(Map<String, String> xmlMap) throws Exception;

}
