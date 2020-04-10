package cn.jiayuli.learnjava.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadTest {

    @Test
    void myThreadTest() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            new MyThread().start();
        }
        long end = System.currentTimeMillis();
        System.out.println("LazySingleton time is : " + (end-begin));
    }

//    @Test
//    void myRunnableTest() {
////        MyRunnable myRunnable = new MyRunnable();
////        new Thread(myRunnable).start();
//    }
}
