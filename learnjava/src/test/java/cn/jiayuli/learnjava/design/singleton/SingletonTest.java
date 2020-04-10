package cn.jiayuli.learnjava.design.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonTest {
    @Test
    void lazySingletonTest() throws InterruptedException {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
    }
}
