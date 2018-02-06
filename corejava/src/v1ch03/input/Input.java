package v1ch03.input;

import java.util.Scanner;

/**
 * @author jiayu
 * @description
 * @date 2018/2/6 17:41
 */
public class Input {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/6 17:48
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {

        //构造一个Scanner对象，并与"标准输人流"System.in关联。
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        // nextLine() 读取输入的下一行内容，包含空格。next() 读取一个单词(以空白符作为分隔符)的内容
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        // nextInt() 读取并转换下一个表示整数的字符序列。
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}
