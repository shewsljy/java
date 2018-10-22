package cn.jiayuli.constructor;

import org.junit.Test;

public class testConstructorExtend {
    @Test
    public void testSonClass() {
        System.out.println("son00:子类无参");
        SonClass son00 = new SonClass();
        System.out.println("son00:子类调用继承的父类say方法");
        son00.say();
        System.out.println("son00:子类调用重写父类的sayOverride方法");
        son00.sayOverride();
        System.out.println("son01:子类一个参");
        SonClass son01 = new SonClass(1);
        System.out.println("son01:子类调用继承的父类say方法");
        son01.say();
        System.out.println("son01:子类调用重写父类的sayOverride方法");
        son01.sayOverride();
        System.out.println("son02:子类两个参");
        SonClass son02 = new SonClass(2, "son02");
        /*System.out.println("son02:子类调用继承的父类say方法");
        son02.say();
        System.out.println("son02:子类调用重写父类的sayOverride方法");
        son02.sayOverride();*/
    }
}
