package cn.jiayuli.string;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

    public static void main(String[] args){
        String a = "";
        String b = null;
        String c = " ";
        String d = " d";
        String e = "e";
        System.out.println("a.length() : " + a.length());
        //System.out.println("b.length() : " + b.length());
        System.out.println("c.length() : " + c.length());
        System.out.println("d.length() : " + d.length());
        System.out.println("e.length() : " + e.length());
        System.out.println("isEmpty(a) : "+ isEmpty(a));//true
        System.out.println("isEmpty(b) : "+ isEmpty(b));//true
        System.out.println("isEmpty(c) : "+ isEmpty(c));//false
        System.out.println("isEmpty(d) : "+ isEmpty(d));//false
        System.out.println("isEmpty(e) : "+ isEmpty(e));//false
        System.out.println("isBlank(a) : "+ isBlank(a));//true
        System.out.println("isBlank(b) : "+ isBlank(b));//true
        System.out.println("isBlank(c) : "+ isBlank(c));//true
        System.out.println("isBlank(d) : "+ isBlank(d));//false
        System.out.println("isBlank(e) : "+ isBlank(e));//false
    }
}
