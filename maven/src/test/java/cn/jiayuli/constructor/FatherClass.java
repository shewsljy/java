package cn.jiayuli.constructor;

public class FatherClass {
    public FatherClass() {
        this(1);
        System.out.println("父类 无参 构造函数");
    }
    public FatherClass(int i){
        System.out.println("父类 一个参数(int)构造函数:super(int)i = "+i);
    }
    public FatherClass(int i,String j){
        System.out.println("父类 两个参数(int,String)构造函数:super(int)i = "+i+",super(String)j = "+j);
    }
    public void say() {
        System.out.println("父类say方法");
    }
    public void sayOverride() {
        System.out.println("父类sayOverride方法");
    }
}
