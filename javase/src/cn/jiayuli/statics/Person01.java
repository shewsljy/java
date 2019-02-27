package cn.jiayuli.statics;

public class Person01 {
    /** static 用法01
     * 修饰成员变量，static关键字可以修饰成员变量和方法，来让它们变成类的所属
     * 给Person的对象创建一个唯一id以及记录总数的作用，其中count由static修饰，是Person类的成员属性
     * 每次创建一个Person对象，构造函数就会使该属性自加1然后赋给对象的id属性，这样，count属性记录了创建Person对象的总数，
     * 由于count使用了private修饰，所以从类外面无法随意改变
     */
    private static int count = 0;
    int id;
    String name;
    int age;

    public Person01() {
        id = ++count;
    }

    public String toString() {
        return "Id:" + id + ", Name:" + name + ", Age:" + age;
    }

    public static void main(String[] args) {
        Person01 p1 = new Person01();
        p1.name = "zhangsan";
        p1.age = 10;
        Person01 p2 = new Person01();
        p2.name = "lisi";
        p2.age = 12;
        System.out.println(p1);
        System.out.println(p2);
    }
}
