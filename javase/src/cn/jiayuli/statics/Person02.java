package cn.jiayuli.statics;

public class Person02 {
    /** static 用法02
     * 修饰成员方法
     * 方法本来就是存放在类的定义当中的，相比于修饰成员属性，修饰成员方法对于数据的存储上面并没有多大的变化
     * static修饰成员方法最大的作用，就是可以使用"类名.方法名"的方式操作方法，避免了先要new出对象的繁琐和资源消耗
     * 在一个static修饰的类中，不能使用非static修饰的成员变量和方法
     */

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        Person02.print("Hello Person02!");
    }
}
