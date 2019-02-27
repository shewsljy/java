package cn.jiayuli.finals;

public class FinalTest {
    final int f1 = 1;
    final int f2;
    public FinalTest(){
        f2 = 2;
    }

    public void finalFunc(final int i, final Value value) {
        /** 02 修饰方法参数
         * 在参数前面添加final关键字，它表示在整个方法中，不能改变参数的值
         * 03 修饰方法，表示该方法无法被重写，private和final关键字还有一点联系，这就是类中所有的private方法都隐式地指定为是final
         * 04 修饰类，表示该类无法被继承
         */
        //i = 5; //不能改变i的值
        //value = new Value(5); //不能改变value的值
        value.v = 5; // 可以改变value引用对象的值
        System.out.println(value.toString());
    }

    public static void main(String[] args){
        /** 01 修饰数据
         * 基本类型和引用类型时，final关键字的效果存在细微差别
         * final修饰基本类型时，赋值过后的基本类型不可改变，对于成员变量来讲，必须在声明时或者构造方法中对它赋值
         * final修饰引用变量时，只是限定了引用变量的引用不可改变，即不能将value3再次引用另一个Value对象
         * 但是引用的对象的值(value3.v)是可以改变的
         */
        final int value1 = 1;
        //value1 = 11;//不能改变value1的值
        final double value2;
        value2 = 2.0;
        //value2 = 22.0;//不能改变value2的值
        final Value value3 = new Value(1);
        //value3 = new Value(3);//不能改变value3的值
        value3.v = 3;//可以改变value3引用的对象的值
        System.out.println(value3.toString());

        new FinalTest().finalFunc(11, new Value(11));
    }
}
