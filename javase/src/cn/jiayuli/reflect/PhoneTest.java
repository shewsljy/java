package cn.jiayuli.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: PhoneTest <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/12/11
 */
public class PhoneTest {

    public static void main(String[] args) throws Exception {
        //正常调用
        System.out.println("正常调用:");
        Phone phone1 = new Phone();
        System.out.println("phone1的价格默认初始值：" + phone1.getPrice());
        phone1.setPrice(5000);
        System.out.println("phone1的价格设置为：" + phone1.getPrice());
        System.out.println("#####################");
        //使用反射调用
        System.out.println("使用反射调用:");
        //获取类的 Class 对象实例
        // 1。使用 Class.forName 静态方法。当知道某类的全路径名时，可以使用此方法获取 Class 类对象。用的最多，但可能抛出 ClassNotFoundException 异常。
        Class clz1 = Class.forName("cn.jiayuli.reflect.Phone");
        // 2。直接通过 类名.class 的方式得到，该方法最为安全可靠，程序性能更高。这说明任何一个类都有一个隐含的静态成员变量 class。这种方法只适合在编译前就知道操作的 Class。
        Class clz2 = Phone.class;
        // 3。通过对象调用 getClass() 方法来获取，通常应用在：比如你传过来一个 Object类型的对象，而我不知道你具体是什么类，用这种方法。
        Class clz3 = phone1.getClass();
        // 一个类在 JVM 中只会有一个 Class 实例，即我们对上面获取的 clz1、clz2和clz3进行 equals 比较，发现都是true。
        if (clz1.equals(clz2) && clz1.equals(clz3)){
            Class clz = clz1;
            //通过反射创建类对象
            // 1。通过 Class 对象的 newInstance() 方法，只能使用默认的无参数构造方法初始化。
            Object phone2 = Phone.class.newInstance();
            //获取方法的 Method 对象
            Method getPriceMethod = clz.getMethod("getPrice");
            System.out.println("phone2的价格默认初始值：" + getPriceMethod.invoke(phone2));
            Method setPriceMethod = clz.getMethod("setPrice", int.class);
            setPriceMethod.invoke(phone2, 6000);
            System.out.println("phone2的价格设置为：" + getPriceMethod.invoke(phone2));
            // 2。通过 Constructor 对象的 newInstance() 方法，可以选择特定构造方法初始化。
            //根据 Class 对象实例获取 Constructor 对象
            Constructor constructor1 = clz.getConstructor();
            Constructor constructor2 = clz.getConstructor(String.class, int.class);
            //使用 Constructor 对象的 newInstance 方法获取反射类对象
            Object phone3 = constructor1.newInstance();
            Object phone4 = constructor2.newInstance("华为", 8000);
            System.out.println("phone3的价格默认初始值：" + getPriceMethod.invoke(phone3));
            setPriceMethod.invoke(phone3, 7000);
            System.out.println("phone3的价格设置为：" + getPriceMethod.invoke(phone3));
            System.out.println("phone4的价格默认初始值：" + getPriceMethod.invoke(phone4));
            setPriceMethod.invoke(phone4, 9000);
            System.out.println("phone4的价格设置为：" + getPriceMethod.invoke(phone4));
            System.out.println("#####################");
            //通过反射获取类属性、方法、构造器
            System.out.println("通过反射获取类属性(不包括私有属性)：");
            Field[] fields = clz.getFields();
            for (Field field : fields){
                System.out.println(field.getName());
            }
            System.out.println("#####################");
            System.out.println("通过反射获取类属性(包括私有属性)：");
            Field[] declaredFields = clz.getDeclaredFields();
            for (Field field : declaredFields){
                System.out.println(field.getName());
            }
            System.out.println("#####################");
            System.out.println("通过反射获取类方法(不包括私有属性)：");
            Method[] methods = clz.getMethods();
            for (Method method : methods){
                System.out.println(method.getName());
            }
            System.out.println("#####################");
            System.out.println("通过反射获取类方法(包括私有方法)：");
            Method[] declaredMethods = clz.getDeclaredMethods();
            for (Method method : declaredMethods){
                System.out.println(method.getName());
            }
        }
    }
}
