package cn.jiayuli.exception;

public class EncryptUtilTest {

    public static void main(String[] args) {

        // signature=a34eb935230aa5c28ce4964c167d92342d7cc325
        // echostr=8898899053199204292
        // timestamp=1545967556
        // nonce=1708159955
        String token = "token_wechat_dev";
        String signature = "ad3fb6ea35d7160429f6ec962ec44421ddc02361";
        String timestamp = "1546061557";
        String nonce = "709988138";
        // token timestamp nonce 放入数组中
        String[] array = new String[] {token, timestamp, nonce};

        // 将数组通过SHA1加密生成strEncrypt，与微信给予的signature对比，相同则发返回echostr给微信
        try {
            String strEncrypt = EncryptUtil.SHA1Encrypt(array);
            if (signature.equals(strEncrypt)) {
                System.out.println("校验通过");
            }
        }catch (AesException e) {
            e.printStackTrace();
            System.out.println("异常代码：" + e.getCode());
        }
    }
}
