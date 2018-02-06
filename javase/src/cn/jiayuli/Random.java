package cn.jiayuli;

/**
 * @author jiayu
 * @description
 * @date 2018/2/5 11:29
 */
public class Random {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/6 17:51
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        //随机浮点数[0.0, 1.0)
        double randomOfDouble = Math.random();
        //随机浮点数[0.0, 10.0) int()把double强制转化(小数直接舍去)为整数 取值范围[0, 10)
        int randomOfInt = (int)(randomOfDouble * 10);
        //生成一个两位数的随机数[10, 100) Math.random() * (最大值 - 最小值) + 最小值
        int randomInt = (int)(Math.random() * (100 - 10) + 10);
        System.out.println("randomOfDouble = " + randomOfDouble);
        System.out.println("randomOfInt = " + randomOfInt);
        System.out.println("randomInt = " + randomInt);
    }
}
