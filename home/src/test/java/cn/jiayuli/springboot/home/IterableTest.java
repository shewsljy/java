package cn.jiayuli.springboot.home;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class IterableTest {

    @Test
    public void ListTest() {
        List<String> list1 = new ArrayList<String>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        List<String> list2 = Arrays.asList("one","two");
        try {
            list2.add("three");
        }catch (Exception e){
            Assert.assertEquals(e.getClass(), UnsupportedOperationException.class);
            System.out.println("捕获 UnsupportedOperationException 异常");
        }
        //for循环遍历
        System.out.println("for循环遍历:");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + ",");
        }
        System.out.println();
        //迭代器遍历
        System.out.println("迭代器遍历:");
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
        //foreach遍历
        System.out.println("foreach遍历:");
        for (String str : list1){
            System.out.print(str + ",");
        }
        System.out.println();
    }

    @Test
    public void MapTest() {
        Map<String, String> mapStr = new HashMap<String, String>();
        mapStr.put("1","001");
        mapStr.put("2","002");
        mapStr.put("3","003");
        mapStr.put("4","004");
        mapStr.put("5","005");
        Collection<String> collection = mapStr.values();
        System.out.println(collection);
        System.out.println(mapStr.isEmpty());
        System.out.println(mapStr.containsKey("1"));
        System.out.println(mapStr.containsValue("001"));
        //keySet()迭代器遍历
        System.out.println("keySet()迭代器遍历: ");
        Set<String> stringSet = mapStr.keySet();
        Iterator<String> stringIterator = stringSet.iterator();
        while (stringIterator.hasNext()){
            String key = stringIterator.next();
            String value = mapStr.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
        //entrySet()迭代器遍历
        System.out.println("entrySet()迭代器遍历: ");
        Set<Map.Entry<String, String>> stringEntrySet = mapStr.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = stringEntrySet.iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String, String> entry = entryIterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
        //foreach keySet
        System.out.println("foreach keySet 遍历: ");
        for (String key : mapStr.keySet()){
            String value = mapStr.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
        //foreach entrySet
        System.out.println("foreach entrySet 遍历: ");
        for (Map.Entry<String, String> entry : mapStr.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
