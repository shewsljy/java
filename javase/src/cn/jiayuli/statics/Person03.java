package cn.jiayuli.statics;

public class Person03 {
    Book book1 = new Book("book1成员变量初始化");
    static Book book2;

    /**
     * static 用法03
     * 静态块用法，将多个类成员放在一起初始化，使得程序更加规整，其中理解对象的初始化过程非常关键
     * Person类中组合了四个Book成员变量，两个是普通成员，两个是static修饰的类成员。
     * 当new一个Person对象时，static修饰的成员变量首先被初始化，随后是普通成员，最后调用Person类的构造方法完成初始化。
     * static修饰的类成员，在程序运行过程中，只需要初始化一次即可，不会进行多次的初始化。
    */
    static {
        book2 = new Book("static成员book2成员变量初始化");
        book4 = new Book("static成员book4成员变量初始化");
    }

    public Person03(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4;

    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }

    public static void main(String[] args) {
        Person03.funStatic();
        System.out.println("****************");
        Person03 p1 = new Person03("p1初始化");
    }
}
