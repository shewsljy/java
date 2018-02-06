package v1ch03.string;

/**
 * @author jiayu
 * @description
 * @date 2018/2/6 15:58
 */
public class StringLearn {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/6 17:48
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {

        //subtring 截取字符创 输出：Hel
        String hello = "Hello!";
        String subhel = hello.substring(0, 3);
        System.out.println(subhel);
        //+ 拼接字符串，将前后两个字符串连接起来 输出：Hello World!
        String a = "Hello";
        String b = " World!";
        String c = a + b;
        System.out.println(c);
        //join 拼接多个字符串，以某个字符将各个字符串连接起来 输出：S/M/L/XL
        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println(all);

        //length() 返回字符串的长度
        String greeting = "Hello";
        int n = greeting.length();// n的值为5
        System.out.println(n);

        //codePointCount(int startlndex, int endlndex) 返回 startlndex 和 endludex- l 之间的代码点数量
        int cpCount = greeting.codePointCount(0, greeting.length());// cpCount的值为5
        System.out.println(cpCount);

        //charAt(int index) 返回给定位置的代码单元。除非对底层的代码单元感兴趣， 否则不需要调用这个方法。
        char first = greeting.charAt(0); // first 为 'H'
        System.out.println(first);
        char last = greeting.charAt(4); // last 为 'o'
        System.out.println(last);

        //offsetByCodePoints(int startlndex, int cpCount) 返回从 startlndex 代码点开始， 位移 cpCount 后的码点索引。
        int index = greeting.offsetByCodePoints(0,0); //拿到'H'的码点索引
        System.out.println(index);
        //codePointAt( int Index) 返回从给定位置开始的码点
        int cp = greeting.codePointAt(index); //'H'对应ASCII码位
        System.out.println(cp);

        //构建一个空的字符串构建器
        StringBuilder builder = new StringBuilder();
        //需要添加一部分内容时，就调用 append() 方法
        builder.append('H');//char
        builder.append("ello, World!");//string
        //构建字符串时就凋用 toString 方法， 将可以得到一个 String 对象， 其中包含了构建器中的字符序列
        String completedString = builder.toString();
        //输出 Hello, World!
        System.out.println(completedString);
    }
}
