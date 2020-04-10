package cn.jiayuli.learnjava.thread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + " : " + Thread.currentThread().getName());
    }
}
