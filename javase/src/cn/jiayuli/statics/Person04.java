package cn.jiayuli.statics;

import static cn.jiayuli.statics.Person02.*;

public class Person04 {
    /** static 用法04
     * 静态导包
     * 不同于非static导入，采用static导入包后，在不与当前类的方法名冲突的情况下，无需使用“类名.方法名”的方法去调用类方法了
     * 直接可以采用"方法名"去调用类方法，就好像是该类自己的方法一样使用即可
     */

    public static void main(String[] args) {
        print("Hello Person04!");
    }
}
