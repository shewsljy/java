package cn.jiayuli.designpatterns.singleton;

public class SingleTon07 {

    //懒汉式：指全局的单例实例在第一次被使用时构建。
    //饿汉式：指全局的单例实例在类装载时构建。

    //第七种（双重校验锁）
    private SingleTon07() {
        System.out.println("单例设计模式，第七种（双重校验锁）");
        System.out.println("这个是第二种方式的升级版，俗称双重检查锁定，在JDK1.5之后，双重检查锁定才能够正常达到单例效果。");
    }
    private static volatile SingleTon07 instance;
    public static SingleTon07 getInstance() {
        if (instance == null) {
            synchronized (SingleTon07.class) {
                if (instance == null) {
                    instance = new SingleTon07();
                }
            }
        }
        return instance;
    }

}
