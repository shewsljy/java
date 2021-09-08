package cn.jiayuli.wechat.constant;

public class WXConstant {

    /**
     * 微信公众号xml ENCRYPT节点
     */
    public static final String NODE_ENCRYPT = "Encrypt";

    /**
     * 微信公众号xml根节点
     */
    public static final String ROOT_XML = "xml";
    /**
     * 微信公众号默认返回
     */
    public static final String RESULT_SUCCESS = "success";

    /**
     * 微信公众号消息类型
     */
    public static final String MESSAGE_TYPE = "MsgType";

    /**
     * 微信公众号事件类型
     */
    public static final String EVENT_TYPE = "Event";

    /**
     * 消息加密密钥由43位字符组成
     */
    public static final Integer ENCODING_AES_KEY_LENGTH = 43;

    /**
     * 微信公众号字符编码utf-8
     */
    public static final String CHARSET_UTF8 = "utf-8";

    /**
     * 微信公众号access_token_key 用于保存在redis中的key
     */
    public static final String ACCESS_TOKEN_KEY = "wechat:accessToken:%s";

    /**
     * 获取微信公众号的access_token
     */
    public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图片消息
     */
    public static final String MESSAtGE_IMAGE = "image";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * 小视频消息
     */
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    /**
     * 地理位置消息
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * 事件推送消息
     */
    public static final String MESSAGE_EVENT = "event";
    /**
     * 事件推送消息中,事件类型，subscribe(订阅)
     */
    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
    /**
     * 事件推送消息中,事件类型，unsubscribe(取消订阅)
     */
    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件推送消息中,上报地理位置事件
     */
    public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
     */
    public static final String MESSAGE_EVENT_CLICK = "CLICK";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
     */
    public static final String MESSAGE_EVENT_VIEW = "VIEW";

}
