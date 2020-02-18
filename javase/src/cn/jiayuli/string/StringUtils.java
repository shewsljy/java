package cn.jiayuli.string;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

    public static void main(String[] args){
        Map<String, String> putMap = new HashMap<String, String>();
        putMap.put("A","A");
        putMap.put("B","B");
        putMap.put("A","A");
        putMap.put("A","A");
        putMap.put("A","A");
        putMap.put("A","A");
        int aaa = putMap.size();
        putMap.remove("C");

        String a = "";
        String b = null;
        String c = " ";
        String d = " d";
        String e = "e";
        System.out.println("a.length() : " + a.length());
        //System.out.println("b.length() : " + b.length());
        System.out.println("c.length() : " + c.length());
        System.out.println("d.length() : " + d.length());
        System.out.println("e.length() : " + e.length());
        System.out.println("isEmpty(a) : "+ isEmpty(a));//true
        System.out.println("isEmpty(b) : "+ isEmpty(b));//true
        System.out.println("isEmpty(c) : "+ isEmpty(c));//false
        System.out.println("isEmpty(d) : "+ isEmpty(d));//false
        System.out.println("isEmpty(e) : "+ isEmpty(e));//false
        System.out.println("isBlank(a) : "+ isBlank(a));//true
        System.out.println("isBlank(b) : "+ isBlank(b));//true
        System.out.println("isBlank(c) : "+ isBlank(c));//true
        System.out.println("isBlank(d) : "+ isBlank(d));//false
        System.out.println("isBlank(e) : "+ isBlank(e));//false

        String aString = "28800,8900,31900,3900";
        String[] aArray = aString.split(",");
        for (int i = 0; i < aArray.length; i++) {
            System.out.println(aArray[i]);
        }
        String bString = "28800,";
        String[] bArray = bString.split(",");
        for (int i = 0; i < bArray.length; i++) {
            System.out.println(bArray[i]);
        }
        String cString = "288.00,89.00,319.00,39.00";
        System.out.println(cString.substring(0,cString.length()));

        Long ab = 2800L;
        System.out.println(String.valueOf(ab));
        System.out.println(ab.toString());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" --  归属省份 ");
        int index = stringBuilder.indexOf(" 归属省份 ");
        stringBuilder.delete(index,index+6);
        stringBuilder.append(" 归属地市 |");
        int del = stringBuilder.lastIndexOf("|");
        stringBuilder.delete(del,del+1);
        System.out.println(stringBuilder.toString());

        Map<String, String> map = new HashMap<String, String>();
        Timestamp nowDate = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sm = new SimpleDateFormat("MM");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        SimpleDateFormat sh = new SimpleDateFormat("HH");
        SimpleDateFormat si = new SimpleDateFormat("mm");
        SimpleDateFormat ss = new SimpleDateFormat("ss");
        map.put("YEAR", sy.format(nowDate));
        map.put("MONTH", sm.format(nowDate));
        map.put("DAY", sd.format(nowDate));
        map.put("HOURS", sh.format(nowDate));
        map.put("MINUTES", si.format(nowDate));
        map.put("SECONDS", ss.format(nowDate));

        Map<String, String> params = new HashMap<String, String>();
        params.put("CHNL_ID","591TEST");
        params.put("SHOP_ID","SHOPTEST");
        map.putAll(params);
        System.out.println("ssss");

        String arrayStr1 = "[\"11\"]";
        String arrayStr5 = "[\"11\",\"76\",\"31\",\"51\",\"59\"]";
        String[] array1 = arrayStr1.split(",");
        String[] array5 = arrayStr5.split(",");
        System.out.println("ssss");
        Map<String, String> provinceMap = new HashMap<String, String>();
        provinceMap.put("11","aaa");
        provinceMap.put("76","bbb");
        provinceMap.put("31","ccc");
        provinceMap.put("51","ddd");
        provinceMap.put("59","eee");
        provinceMap.put("13","fff");
        List<String> provinceList1 = new ArrayList<String>();
        if (array1.length != 0){
            for (String str : array1){
                for (String key : provinceMap.keySet()){
                    if (str.contains(key)){
                        provinceList1.add(key);
                    }
                }
            }
        }
        List<String> provinceList5 = new ArrayList<String>();
        if (array5.length != 0){
            for (String str : array5){
                for (String key : provinceMap.keySet()){
                    if (str.contains(key)){
                        provinceList5.add(key);
                    }
                }
            }
        }
        System.out.println("ssss");
    }
}
