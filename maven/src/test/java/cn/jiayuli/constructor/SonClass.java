package cn.jiayuli.constructor;

public class SonClass extends FatherClass {
    public SonClass() {
        //super();
        this(1);
        //super(0);
        //super(0, "0");
        System.out.println("子类 无参 构造函数");
    }
    public SonClass(int a){
        //super();
        super();
        //super(1,"1");
        System.out.println("子类 一个参数(int)构造函数:sub(int)a = "+a);
    }
    public SonClass(int a,String b){
        //super();
        //super(1);
        super(1,"1");
        System.out.println("子类 两个参数(int,String)构造函数:sub(int)i = "+a+",sub(String)j = "+b);
    }
    @Override
    public void sayOverride() {
        System.out.println("子类sayOverride方法");
        System.out.println("子类sayOverride方法中通过super.say()调用父类say()方法");
        super.say();
    }
}
