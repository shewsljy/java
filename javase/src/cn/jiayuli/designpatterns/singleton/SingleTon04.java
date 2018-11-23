package cn.jiayuli.designpatterns.singleton;

public class SingleTon04 {

    //懒汉式：指全局的单例实例在第一次被使用时构建。
    //饿汉式：指全局的单例实例在类装载时构建。

    //第四种（饿汉，变种）
    private SingleTon04() {
        System.out.println("单例设计模式，第四种（饿汉，变种）");
        System.out.println("表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。");
    }
    private static SingleTon04 instance = null;
    static {
        instance = new SingleTon04();
    }
    public static SingleTon04 getInstance() {
        return instance;
    }

}
