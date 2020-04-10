package cn.jiayuli.learnjava.design.singleton;

public class StaticInnerSingleton {

    private static class StaticInner {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {

    }

    public static StaticInnerSingleton getInstance() {
        return StaticInner.INSTANCE;
    }
}
