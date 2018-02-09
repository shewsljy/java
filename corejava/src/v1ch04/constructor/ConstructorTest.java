package v1ch04.constructor;

import java.util.Random;

/**
 * @author jiayu
 * @description
 * @date 2018/2/9 10:27
 */
public class ConstructorTest {
    /**
     * @description 静态域/初始化静态块 跟 对象初始化块区别
     * @author jiayu
     * @date 2018/2/9 17:47
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        //Employee employee = new Employee();
        EmployeeExtends employeeExtends = new EmployeeExtends();
    }
}

class Employee {
    //静态域 属于类不属于实例
    private static int staticId;

    //实例域的初始化 在执行构造器之前， 先执行赋值操作。
    //当一个类的所有构造器都希望把相同的值赋予某个特定的实例域时，这种方式特别有用。
    private String name = "实例域初始化雇员名称";
    //没有初始化类中的域，将在构造器中显式/默认初始化
    private double salary;
    private int id;
    private int blockId;

    //静态初始化块 属于类不属于实例，随机一个1000以内的整数
    static {
        System.out.println("静态初始化块前，staticId=" + staticId + "(应该是0)");
        Random generator = new Random();
        staticId = generator.nextInt(1000);
        System.out.println("静态初始化块后，staticId=" + staticId + "(随机一个1000以内的整数)");
    }

    //对象初始化块(initialization block) 属于实例对象，首先运行初始化块，然后才运行构造器的主体部分。
    //这种机制不是必需的，也不常见。通常会直接将初始化代码放在构造器中。
    //将当前的静态域值赋值给实例对象
    {
        System.out.println("对象初始化块前，blockId=" + blockId + "(应该是0)");
        blockId = staticId;
        System.out.println("对象初始化块后，blockId=" + blockId + "(应该跟静态初始化块后的staticId一致)");
        staticId++;
        System.out.println("对象初始化块后，staticId=" + staticId + "(应该比静态初始化块后的staticId值大1)");
    }

    //如果多个方法(返回类型不在判断的条件范围)有相同的名字、不同的参数，便产生了重载。
    //默认空构造器 如果先前没有显式地给域赋予初值，就会被自动地赋为默认值：
    //实例域中的数值型数据设置为 0、 布尔型数据设置 为 false、 所有对象变量将设置为 null
    public Employee() {}
    //初始化salary的构造器
    public Employee(double s) {
        salary = s;
    }
    //初始化name的构造器
    public Employee(String n) {
        name = n;
    }
    //初始化salary和name的构造器
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    //初始化id的构造器，并调用同类下 初始化salary和name的构造器
    public Employee(int id) {
        this("name id", 1111111);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public int getBlockId() {
        return blockId;
    }
    /**
     * @description 构造器用法
     * @author jiayu
     * @date 2018/2/9 17:47
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        /*
        * 调用构造器的具体处理步骤:
        * 1 ) 所有数据域被初始化为默认值(0、 false 或 null)
        * 2 ) 按照在类声明中出现的次序， 依次执行所有域初始化语句和初始化块。
        * 3 ) 如果构造器第一行调用了第二个构造器， 则执行第二个构造器主体。
        * 4 ) 执行这个构造器的主体。
        */
        Employee employee = new Employee();
        System.out.println(employee.getName() + ", " + employee.getSalary() + ", " + employee.getBlockId());
        Employee employeeSalary = new Employee(23456D);
        System.out.println(employeeSalary.getName() + ", " + employeeSalary.getSalary());
        Employee employeeName = new Employee("name");
        System.out.println(employeeName.getName() + ", " + employeeName.getSalary());
        Employee employeeNameAndSalary = new Employee("name salary", 123);
        System.out.println(employeeNameAndSalary.getName() + ", " + employeeNameAndSalary.getSalary());
        Employee employeeId = new Employee(234);
        System.out.println(employeeId.getName() + ", " + employeeId.getSalary() + ", " + employeeId.getId());
    }
}

class EmployeeExtends extends Employee {
    //静态初始化块 属于类不属于实例，随机一个1000以内的整数
    static {
        System.out.println("子类EmployeeExtends的静态初始化块");
    }

    //对象初始化块(initialization block) 属于实例对象，首先运行初始化块，然后才运行构造器的主体部分。
    //这种机制不是必需的，也不常见。通常会直接将初始化代码放在构造器中。
    //将当前的静态域值赋值给实例对象
    {
        System.out.println("子类EmployeeExtends的对象初始化块");
    }
}