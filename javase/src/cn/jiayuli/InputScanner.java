package cn.jiayuli;
import java.util.Scanner;
/**
 * @author jiayu
 * @description
 * @date 2018/2/5 10:48
 */
public class InputScanner {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/5 11:30
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int inputOfInt = input.nextInt();
        System.out.println("输入的整数值为:" + inputOfInt);
        System.out.println("请输入一个浮点数:");
        Double inputOfDouble = input.nextDouble();
        System.out.println("输入的浮点值为:" + inputOfDouble);
        System.out.println("请输入一个字符串:");
        String inputOfString = input.next();
        System.out.println("输入的字符串值为:" + inputOfString);
        System.out.println("请输入一个字符:");
        String inputOfChar = input.next();
        char subtringOfString = inputOfChar.charAt(0);
        System.out.println("输入的字符值为:" + subtringOfString);
        System.out.println("请输入一个布尔值:");
        Boolean inputOfBoolean = input.nextBoolean();
        System.out.println("输入的布尔值为:" + inputOfBoolean);
    }
}
