package cn.jiayuli.learnjava.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadTest {

    @Test
    void myThreadTest() {
        for (int i = 0; i < 10000; i++) {
            new MyThread().start();
        }
    }

//    @Test
//    void myRunnableTest() {
////        MyRunnable myRunnable = new MyRunnable();
////        new Thread(myRunnable).start();
//    }
}
