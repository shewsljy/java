package v1ch04.staticclass;

/**
 * @author jiayu
 * @description
 * @date 2018/2/9 11:37
 */
public class StaticTest {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/9 14:28
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Employee01", 4000);
        staff[1] = new Employee("Employee02", 5000);
        staff[2] = new Employee("Employee03", 6000);
        for (Employee e : staff) {
            System.out.println("Before setId, " + e.getName() + "'s salary is " + e.getSalary() + ", the Id is " + e.getId() + " and the classNextId is " + Employee.getNextId());
        }
        for (Employee e : staff) {
            e.setId();
            System.out.println("After setId, " + e.getName() + "'s salary is " + e.getSalary() + ", the Id is " + e.getId() + " and the classNextId is " + Employee.getNextId());
        }
    }
}

class Employee {
    //静态域 类静态变量
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;
    /**
     * @description 构造函数 默认空参数
     * 没有显式地给域赋予初值的时候，就会被自动地赋为默认值：
     * 实例域中的数值型数据设置为 0、 布尔型数据设置 为 false、 所有对象变量将设置为 null
     * @author jiayu
     * @date 2018/2/9 15:24
     * @param []
     * @return
     */
    public Employee() {}
    /**
     * @description 构造函数 带参数
     * @author jiayu
     * @date 2018/2/9 14:29
     * @param [s, d]
     * @return
     */
    public Employee(String s, double d) {
        name = s;
        salary = d;
        id = 99;
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

    public void setId() {
        id = nextId;
        nextId++;
    }
    //类静态方法 通过类名.getNextId()调用。虽然由类生成的对象名.getNextId()也可以调用，但是容易混淆，不推荐此类方式调用
    public static int getNextId() {
        return nextId;
    }
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/9 14:28
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        Employee e = new Employee();
        System.out.println(e.getName() + ", " + e.getSalary());
        System.out.println(e.getId() + ", " + Employee.nextId);
        Employee employee = new Employee("jiayu", 6000);
        System.out.println(employee.getName() + ", " + employee.getSalary());
        System.out.println(employee.getId() + ", " + Employee.nextId);
    }
}