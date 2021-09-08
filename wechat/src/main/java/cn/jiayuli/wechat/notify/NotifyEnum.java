package cn.jiayuli.wechat.notify;

import java.util.Objects;

public enum NotifyEnum {

    //菜单点击事件
    CLICK("event", "CLICK"),
    //点击菜单跳转链接时的事件推送
    VIEW("event", "VIEW"),
    //上报地理位置事件
    LOCATION("event", "LOCATION"),
    //关注
    SUBSCRIBE("event", "subscribe"),
    //取关
    UNSUBSCRIBE("event", "unsubscribe"),
    //已关注时的扫码事件
    SCAN("event", "SCAN"),
    //文字消息
    TEXT("text", null),
    //图片消息
    IMAGE("image", null),
    //语音消息
    VOICE("voice", null),
    //视频消息
    VIDEO("video", null),
    //小视频消息
    SHORTVIDEO("shortvideo", null),
    //地理位置消息
    location("location", null),
    //链接消息
    LINK("link", null),
    //默认回复消息
    DEFAULT("default", null);


    private String msgType;
    private String event;

    NotifyEnum(String msgType, String event) {
        this.msgType = msgType;
        this.event = event;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getEvent() {
        return this.event;
    }

    /**
     * 解析事件类型
     *
     * @param msgType
     * @param event
     * @return
     */
    public static NotifyEnum resolveEvent(String msgType, String event) {
        for (NotifyEnum notifyEnum : NotifyEnum.values()) {
            if (Objects.equals(msgType, notifyEnum.getMsgType()) && Objects.equals(event, notifyEnum.getEvent())) {
                return notifyEnum;
            }
        }
        return NotifyEnum.DEFAULT;
    }
}
