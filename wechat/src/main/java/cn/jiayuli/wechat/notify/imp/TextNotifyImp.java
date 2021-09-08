package cn.jiayuli.wechat.notify.imp;

import cn.jiayuli.wechat.annotation.NotifyType;
import cn.jiayuli.wechat.util.XMLParseUtil;
import cn.jiayuli.wechat.notify.NotifyEnum;
import cn.jiayuli.wechat.notify.WeChatNotify;
import cn.jiayuli.wechat.util.MessageUtil;

import java.util.HashMap;
import java.util.Map;

@NotifyType({NotifyEnum.TEXT})
public class TextNotifyImp implements WeChatNotify {
    @Override
    public String weChatNotify(Map<String, String> xmlMap) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String toUserName = MessageUtil.addCData(xmlMap.get("FromUserName"));
        String fromUserName = MessageUtil.addCData(xmlMap.get("ToUserName"));
        String createTime = Long.toString(System.currentTimeMillis()/1000L);
        String msgType = MessageUtil.addCData(xmlMap.get("MsgType"));
        String content = xmlMap.get("Content");
        String reContent = MessageUtil.addCData("反弹 ：" + content);
        //对获取的文本进行分析
        //生成反回的文本
//        <xml>
//          <ToUserName><![CDATA[toUser]]></ToUserName>
//          <FromUserName><![CDATA[fromUser]]></FromUserName>
//          <CreateTime>12345678</CreateTime>
//          <MsgType><![CDATA[text]]></MsgType>
//          <Content><![CDATA[你好]]></Content>
//        </xml>
        map.put("ToUserName", toUserName);
        map.put("FromUserName",fromUserName);
        map.put("CreateTime",createTime);
        map.put("MsgType",msgType);
        map.put("Content",reContent);
        String result = XMLParseUtil.mapToXml(map);
        return result;
    }
}
