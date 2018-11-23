package cn.jiayuli.designpatterns.singleton;

public class SingleTon02 {

    //懒汉式：指全局的单例实例在第一次被使用时构建。
    //饿汉式：指全局的单例实例在类装载时构建。

    //第二种（懒汉，线程安全）
    private SingleTon02() {
        System.out.println("单例设计模式，第二种（懒汉，线程安全）");
        System.out.println("这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步。");
    }
    private static SingleTon02 instance;
    public static synchronized SingleTon02 getInstance() {
        if (instance == null) {
            instance = new SingleTon02();
        }
        return instance;
    }

}
