package cn.jiayuli.serializable;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) throws Exception {
        //序列化Person对象
        System.out.println("序列化Person对象");
        SerializablePerson();
        //Person对象反序列化
        System.out.println("Person对象反序列化");
        Person person = SerializdisablePerson();
        System.out.println(person.toString());
    }

    private static void SerializablePerson() throws FileNotFoundException, IOException {
        Person person = new Person();
        person.setName("admin");
        person.setAge(45);
        person.setSex("男");
        person.setTel("123456789");
        // ObjectOutputStream 对象输出流，将Person对象存储到 personFile.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(
                        new File("/Users/jiayu/Develop/codes/java/javase/personFile.txt")
                )
        );
        outputStream.writeObject(person);
        System.out.println("Person对象序列化成功！");
        outputStream.close();
    }

    private static Person SerializdisablePerson() throws IOException, Exception {
        // ObjectInputStream 对象输入流，将存储到 personFile.txt文件中的数据读取出来，生成Person对象，完成反序列化操作
        ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(
                        new File("/Users/jiayu/Develop/codes/java/javase/personFile.txt")
                )
        );
        Person person = (Person) inputStream.readObject();
        System.out.println("Person对象反序列化成功！");
        inputStream.close();
        return person;
    }
}
