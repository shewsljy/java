package cn.jiayuli.wechat.controller;

import cn.jiayuli.wechat.config.WXConfig;
import cn.jiayuli.wechat.constant.WXConstant;
import cn.jiayuli.wechat.crypt.WXBizMsgCrypt;
import cn.jiayuli.wechat.util.XMLParseUtil;
import cn.jiayuli.wechat.notify.NotifyEnum;
import cn.jiayuli.wechat.notify.NotifyFactory;
import cn.jiayuli.wechat.notify.WeChatNotify;
import cn.jiayuli.wechat.util.CryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private WXConfig wxConfig;

    @Autowired
    private NotifyFactory notifyFactory;

    /**
     * 公众号接入signature确认
     *
     * @param timestamp    时间戳
     * @param nonce        随机数
     * @param signature 消息体签名
     * @param echostr 初次接入配置所需
     * @return
     */
    @GetMapping("/event")
    public Object getSignature(@RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "signature") String signature,
                           @RequestParam(value = "echostr") String echostr) {
        log.info("Msg接收到的请求: signature={}, timestamp={}, nonce={}, echostr={}", signature, timestamp, nonce, echostr);
        //此处用于公众平台配置的初步接入
        String mySignature = CryptUtil.signature(wxConfig.getToken(),timestamp,nonce);
        if (StringUtils.hasLength(mySignature) && mySignature.equals(signature)) {
            log.info("校验微信signature一致，signature={}",signature);
            return echostr;
        } else {
            log.info("校验微信signature不一致，signature={}",signature);
            return null;
        }
    }

    /**
     * 公众号消息和事件推送
     *
     * @param timestamp    时间戳
     * @param nonce        随机数
     * @param signature 消息体签名
     * @param postData 消息体
     * @return
     */
    @PostMapping("/event")
    public Object getMessage(@RequestParam(value = "timestamp",required = false) String timestamp,
                           @RequestParam(value = "nonce",required = false) String nonce,
                           @RequestParam(value = "signature",required = false) String signature,
                           @RequestBody() String postData) {
        log.info("Msg接收到的请求: signature={}, timestamp={}, nonce={}, postData={}", signature, timestamp, nonce, postData);
        WXBizMsgCrypt pc = wxConfig.getWxBizMsgCrypt();
        log.info("wxConfig={}",wxConfig);
        //签名校验 数据解密
        try {
            Map<String, String> map = new HashMap<>();

//            // 验证安全签名
//            String mySignature = CryptUtil.signature(wxConfig.getToken(), timestamp, nonce);
//            // 和URL中的签名比较是否相等
//            if (!StringUtils.hasLength(mySignature) || !mySignature.equals(signature)) {
//                log.info("校验微信signature不一致，signature={}",signature);
//                return null;
//            }
            map = XMLParseUtil.xmlToMap(postData);
            log.info("postDataMap={}",map.toString());
            //判断是否有密文
            if (map.containsKey(WXConstant.NODE_ENCRYPT)) {
                //解密
                String decryptStr = pc.decrypt(map.get(WXConstant.NODE_ENCRYPT));
                map = XMLParseUtil.xmlToMap(decryptStr);
                log.info("decryptStrMap : {}",map.toString());
            }
            //获取推送事件类型  可以拿到的事件: 1 关注/取消关注事件  2:扫描带参数二维码事件 3: 用户已经关注公众号 扫描带参数二维码事件 ...等等
            NotifyEnum notifyEnum = NotifyEnum.resolveEvent(map.get(WXConstant.MESSAGE_TYPE), map.get(WXConstant.EVENT_TYPE));
            WeChatNotify infoType = notifyFactory.loadWeChatNotify(notifyEnum);
            //执行具体的策略 得到给微信的响应信息 微信有重试机制  需要考虑幂等性
            String result = infoType.weChatNotify(map);
            log.info("Msg响应的POST结果: 授权策略对象: [{}] 解密后信息: [{}] 返回给微信的信息: [{}]", infoType.getClass().getSimpleName(), map, result);
            return result;
        }catch (Exception e) {
            log.error("程序出差啦！");
            e.printStackTrace();
            return null;
        }
    }

}
