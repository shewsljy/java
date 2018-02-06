package cn.jiayuli;

/**
 * @author jiayu
 * @description
 * @date 2018/2/2 15:19
 */
public class Final {
    //类中的常量
    static final double PI_VALUE_IN_CLASS = 3.144;

    /**
     * @description 
     * @author jiayu
     * @date 2018/2/6 17:50
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        //方法中的常量
        final double PI_VALUE_METHOD = 3.14;

        //访问当前方法中的常量
        System.out.println("Final类中main()方法常量:" + PI_VALUE_METHOD);
        //访问当前类中的常量
        System.out.println("Final类常量:" + PI_VALUE_IN_CLASS);
        //访问其他类中的常量
        System.out.println("OtherFinal类常量:" + OtherFinal.PI_VALUE_OUT_CLASS);
    }
}

class OtherFinal {
    //类中的常量，设置public后其他类可以通过`OtherFinal.常量名`访问
    public static final double PI_VALUE_OUT_CLASS = 3.1444;
}