package cn.jiayuli.exception;

public class MyException extends Exception {
    public MyException() {
        System.out.println("MyException的无参构造函数");
    }
    public MyException(String message) {
        super(message);
        System.out.println("MyException的有参构造函数");
    }
}
