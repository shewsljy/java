package cn.jiayuli.serializable;

import java.io.Serializable;

/**
 * 对象序列化包括如下步骤：
 *         1） 创建一个对象输出流，它可以包装一个其他类型的目标输出流，如文件输出流；
 *         2） 通过对象输出流的writeObject()方法写对象。
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -4249731385519141349L;
    private int age;
    private String name;
    private String sex;
    private String tel;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
