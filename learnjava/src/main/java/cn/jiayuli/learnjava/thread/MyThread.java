package cn.jiayuli.learnjava.thread;

import cn.jiayuli.learnjava.design.singleton.EnumSingleton;
import cn.jiayuli.learnjava.design.singleton.HungrySingleton;
import cn.jiayuli.learnjava.design.singleton.LazySingleton;
import cn.jiayuli.learnjava.design.singleton.StaticInnerSingleton;

public class MyThread extends Thread{

    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("lazySingleton -- " + lazySingleton.hashCode());
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println("hungrySingleton -- " + hungrySingleton.hashCode());
        StaticInnerSingleton staticInnerSingleton = StaticInnerSingleton.getInstance();
        System.out.println("staticInnerSingleton -- " + staticInnerSingleton.hashCode());
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        System.out.println("enumSingleton -- " + enumSingleton.hashCode());

    }
}
