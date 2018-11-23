package cn.jiayuli.designpatterns.singleton;

public class SingleTon03 {

    //懒汉式：指全局的单例实例在第一次被使用时构建。
    //饿汉式：指全局的单例实例在类装载时构建。

    //第三种（饿汉）
    private SingleTon03() {
        System.out.println("单例设计模式，第三种（饿汉）");
        System.out.println("这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用getInstance方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果。");
    }
    private static SingleTon03 instance = new SingleTon03();
    public static SingleTon03 getInstance() {
        return instance;
    }

}
