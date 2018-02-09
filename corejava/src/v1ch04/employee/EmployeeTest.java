package v1ch04.employee;

import java.time.LocalDate;

/**
 * @author jiayu
 * @description
 * @date 2018/2/9 10:30
 */
public class EmployeeTest {
    /**
     * @description
     * @author jiayu
     * @date 2018/2/9 11:05
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Employee01", 4000, 2015, 7, 4);
        staff[1] = new Employee("Employee02", 5000, 2014, 8, 5);
        staff[2] = new Employee("Employee03", 6000, 2015, 9, 6);
        for (Employee e: staff) {
            System.out.println("Employee's name is " + e.getName() + ", salary is " + e.getSalary() + " and hireday is " + e.getHireDay() + ".");
            e.raiseSalary(5);
        }
        System.out.println("After raise salary by 5% :");
        for (Employee e: staff) {
            System.out.println("Now employee's name is " + e.getName() + ", salary is " + e.getSalary() + " and hireday is " + e.getHireDay() + ".");
        }
    }
}

class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    /**
     * @description 构造函数，在new class()时调用
     * @author jiayu
     * @date 2018/2/9 11:07
     * @param [s, d, year, month, day]
     * @return
     */
    public Employee(String s, double d, int year, int month, int day) {
        name = s;
        salary = d;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary = salary + raise;
    }
}