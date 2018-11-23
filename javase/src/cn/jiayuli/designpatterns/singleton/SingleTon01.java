package cn.jiayuli.designpatterns.singleton;

public class SingleTon01 {

    //懒汉式：指全局的单例实例在第一次被使用时构建。
    //饿汉式：指全局的单例实例在类装载时构建。

    //第一种（懒汉，线程不安全）
    private SingleTon01 () {
        System.out.println("单例设计模式，第一种（懒汉，线程不安全）");
        System.out.println("这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。");
    }
    private static SingleTon01 instance;
    public static SingleTon01 getInstance() {
        if (instance == null) {
            instance = new SingleTon01();
        }
        return instance;
    }

}
