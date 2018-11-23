package cn.jiayuli.designpatterns.singleton;

public class SingleTonTest {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        SingleTon01.getInstance();
        System.out.println("-----------------------------------");
        SingleTon02.getInstance();
        System.out.println("-----------------------------------");
        SingleTon03.getInstance();
        System.out.println("-----------------------------------");
        SingleTon04.getInstance();
        System.out.println("-----------------------------------");
        SingleTon05.getInstance();
        System.out.println("-----------------------------------");
        SingleTon06.INSTANCE.getInstance();
        System.out.println("-----------------------------------");
        SingleTon07.getInstance();
        System.out.println("-----------------------------------");
    }
}
