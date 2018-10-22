package cn.jiayuli.exception;

import org.junit.Test;

public class testException{
    @Test
    public void testArithmeticException() {
        try {
            System.out.println("测试10/0异常");
            int i = 10 / 0;
            System.out.println("此信息打印则表示测试10/0无异常");
        }
        catch (ArithmeticException e) {
            System.out.println("Caught Exception:");
            System.out.println("e.getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("e.getMessage():" + e.getMessage());
            System.out.println("e.toString():" + e.toString());
            System.out.println("e.printStackTrace():");
            e.printStackTrace();
        }
        finally {
            System.out.println("run finally 10");
        }
    }

    @Test
    public void testMyException() {
    try {
        System.out.println("测试testThrows()异常");
        testThrows();
        System.out.println("此信息打印则表示测试testThrows()无异常");
    }
    catch (MyException e) {
        System.out.println("Catch My Exception");
        e.printStackTrace();
    }
    finally {
        System.out.println("run finally testThrows()");
    }
    }

    public void testThrows() throws MyException {
        try {
            System.out.println("测试5/0异常");
            int i = 5 / 0;
            System.out.println("此信息打印则表示测试5/0无异常");
        }
        catch (ArithmeticException e) {
            throw new MyException("This is MyException");
        }
        finally {
            System.out.println("run finally 5");
        }
    }
}
