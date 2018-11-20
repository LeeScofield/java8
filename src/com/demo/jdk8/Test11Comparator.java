package com.demo.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lee on 2018-11-17.
 *
 * @author Lee
 */
public class Test11Comparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wang", "zhaoliu");

        System.out.println("按字符排序");
//        默认升序
        Collections.sort(list);
        System.out.println(list);

        System.out.println("按长度排序...");
        Collections.sort(list,(o1,o2) -> o1.length() - o2.length());
//      或
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);

        System.out.println("按长度倒序排序...");
//      Collections.sort(list,Comparator.comparingInt(o1 -> o1.length() ).reversed());
        Collections.sort(list,Comparator.comparingInt((String o1) -> o1.length() ).reversed());
        System.out.println(list);

        System.out.println("按长度排序,再按字符集排序...");
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);

        System.out.println("按长度排序,再按字符集倒序排序...");
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String::toLowerCase, Comparator.reverseOrder()));
        System.out.println(list);

        System.out.println("按长度排序,再按字符集倒序排序...上一比较结果俩俩比较结果为0再排序，否则顺序不变，此次结果与上次结果一样");
        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String::toLowerCase, Comparator.reverseOrder())
        .thenComparing(Comparator.reverseOrder()));
        System.out.println(list);



    }

}
