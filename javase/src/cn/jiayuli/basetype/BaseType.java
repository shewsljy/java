package cn.jiayuli.basetype;

public class BaseType {

    int i = 7;
    public void method(int i){
        System.out.println(i);
    }

    public static void main(String[] args){

        byte aByte = 12;
        short aShort = 30727;
        int aInt = 246;
        long aLong = 9223226798174374627L;
        char aChar = 'A';
        boolean aBoolean = true;
        float aFloat = 3.2f;
        double aDouble = 3.14;

        System.out.println(aInt);
        new BaseType().method(6);
        System.out.println(new BaseType().i);
    }
}
