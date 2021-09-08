package cn.jiayuli.wechat.notify.imp;

import cn.jiayuli.wechat.annotation.NotifyType;
import cn.jiayuli.wechat.constant.WXConstant;
import cn.jiayuli.wechat.notify.NotifyEnum;
import cn.jiayuli.wechat.notify.WeChatNotify;

import java.util.Map;

@NotifyType({NotifyEnum.DEFAULT})
public class DefaultNotifyImp implements WeChatNotify {
    @Override
    public String weChatNotify(Map<String, String> xmlMap) throws Exception {
        return WXConstant.RESULT_SUCCESS;
    }
}
