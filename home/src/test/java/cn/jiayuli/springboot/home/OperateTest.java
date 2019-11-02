package cn.jiayuli.springboot.home;

import org.junit.Test;

import java.util.Random;

public class OperateTest {

    @Test
    public void bitTest(){
        System.out.println("1 & 2 = ?");
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(2));
//        System.out.println("1 & 2 = " + (1&2));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(2 << 1));
        System.out.println(Integer.toBinaryString(2 << 2));
        System.out.println(Integer.toBinaryString(2 >> 1));
        System.out.println(Integer.toBinaryString(2 >> 2));
    }

    @Test
    public void switchTest(){
        Random random = new Random(23);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.print((char)c + ", " + c + ": ");
            switch (c) {
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    System.out.println("vowel");
                    break;
                case 'y' :
                case 'w' :
                    System.out.println("Sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }
}
