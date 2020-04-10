package cn.jiayuli.learnjava.thread;

import cn.jiayuli.learnjava.design.singleton.LazySingleton;

public class MyThread extends Thread{

    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("lazySingleton -- " + lazySingleton.hashCode());
    }
}
