package cn.jiayuli.honey.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * ClassName: MoneyUtil <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/11/06
 */
public class MoneyUtil {

    /**
     * MethodName: convertYuanToCent <br>
     * Description: 按照设置的精度把元转为分
     *
     * @param yuanStr
     * @param scale
     * @return long
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static long convertYuanToCent(String yuanStr,int scale){

        try {
            return (new BigDecimal(yuanStr).setScale(scale).multiply(new BigDecimal(100))).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * MethodName: convertYuanToCent <br>
     * Description: 把元转为分
     *
     * @param yuanStr
     * @return long
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static long convertYuanToCent(String yuanStr){

        try {
            return (new BigDecimal(yuanStr).multiply(new BigDecimal(100))).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * MethodName: convertCentToYuan <br>
     * Description: 把分转为元
     *
     * @param cent
     * @return java.lang.String
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static String convertCentToYuan(long cent){

        try {
            String result = (new BigDecimal(cent).divide(new BigDecimal(100))).toString();
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * MethodName: convertCentToYuan <br>
     * Description: 把分转为元
     *
     * @param centStr
     * @return java.lang.String
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static String convertCentToYuan(String centStr){

        try {
            String result = (new BigDecimal(centStr).divide(new BigDecimal(100))).toString();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * MethodName: buildBigDecimal <br>
     * Description: 生成BigDecimal，只支持int,long,String,double类型
     *
     * @param value 只支持int,long,String,double类型
     * @return java.math.BigDecimal
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static BigDecimal buildBigDecimal(Object value){

        BigDecimal result=null;
        try {
            if (value==null) {
                return new BigDecimal(0);
            }

            if (value instanceof String) {
                String valueStr=(String)value;
                if (StringUtils.isEmpty(valueStr)) {
                    valueStr="0";
                }
                result=new BigDecimal(valueStr);
            }else if (value instanceof Double) {
                result=new BigDecimal((double)value);
            }else if (value instanceof Integer) {
                result=new BigDecimal((int)value);
            }else if(value instanceof Long) {
                result = new BigDecimal((long) value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return result;
    }

    /**
     * MethodName: convertDoubleToString <br>
     * Description: 按照传入的精度，四色五入获取参数value的double值
     *
     * @param value 只支持int,long,String,double类型
     * @param newScale 精度,保留newScale位小数
     * @return java.lang.String
     * @author jiayu
     * @date 2019-11-12
     * @version V1.0
     */
    public static String convertDoubleToString(Object value,int newScale){

        BigDecimal bigDecimal=buildBigDecimal(value).setScale(newScale,BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }

    public static void main(String[] args) {

        System.out.println(convertCentToYuan(2222222222222222222L));
        System.out.println(convertYuanToCent("0.01"));
        System.out.println(convertYuanToCent("0"));
        System.out.println(convertYuanToCent("0.00"));
        System.out.println(convertYuanToCent("0.000"));
        System.out.println(convertYuanToCent("100"));
        System.out.println(convertYuanToCent("100.0"));
        System.out.println(convertYuanToCent("100.00"));
        System.out.println(convertYuanToCent("100.0505"));
        System.out.println(convertYuanToCent("100.05"));
        System.out.println(convertYuanToCent("100.5"));
        System.out.println(convertYuanToCent("100.50"));

        System.out.println(buildBigDecimal(37.94));
        System.out.println(buildBigDecimal(37.94).doubleValue());
        System.out.println(buildBigDecimal("37.945").doubleValue());
        System.out.println(convertDoubleToString(.945666, 3));


        System.out.println(buildBigDecimal(2.80000000).doubleValue()==buildBigDecimal("2.80000000000000").doubleValue());
    }
}
