package com.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author LiuPeng
 * @description 字符串测试
 * @date 2018/8/6
 */
public class StringTest {

    private static String str = "abc...def...higk";
    public static void main(String[] args) {
        /*char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        int j = 0;
        for(int i = chars.length-1; i >= 0; i--){
            newChars[j++] = chars[i];
        }*/

       /* for(int i = 0; i < chars.length; i++){
            System.out.print(newChars[i]);
        }*/
       /* List<String> list = new LinkedList<>();
        String newStr = "";
        for (int i = 1; i < str.length(); i ++){
            if (".".equals(str.charAt(i))){

            }
        }*/
    }

    private void internTest(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        // true s1和s2都是在方法区中运行时常量池中，当已经存在了s1就不会再创建s2，
        String s3 = new String("abc");
        System.out.println(s1 == s3);
        // false; s3是在堆内存中开辟的新空间
        System.out.println(s1 == s3.intern());
        // true intern()相当于先检查“abc"在常量池中是否存在，
        // 存在则返回这个字符串的引用，否则将这个字符串添加到字符串常量池中最后返回引用
    }


}
