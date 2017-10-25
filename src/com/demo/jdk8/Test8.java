package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Lee
 * date:2017-10-24
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println("Stream的创建方式");
        Stream stream1 = Stream.of("zhangsan","lisi","wangwu");

        String[] str2 = {"zhangsan","lisi","wangwu"};
        Stream stream2 = Stream.of(str2);

        List list3 = Arrays.asList("zhangsan","lisi","wangwu");
        Stream stream3 = list3.stream();

        System.out.println("part1----------------------------");
        IntStream.of(3,1,4,9).forEach(System.out::println);
        
        System.out.println("part2----------------------------");
        IntStream.range(1,4).forEach(System.out::println);
        System.out.println("---");
        IntStream.rangeClosed(1,4).forEach(System.out::println);

        System.out.println("part3----------------------------");
        List<Integer> partList3 = Arrays.asList(1,2,3);
        Integer sum3 = 0;
        for (Integer o : partList3) {
            sum3 += o * 2;
        }
        System.out.println("sum3:" + sum3);
        Integer sum33 = partList3.stream().map(integer -> integer * 2).reduce(0,Integer::sum);
        System.out.println("sum33:" + sum33);

        System.out.println("part4----------------------------");

        System.out.println("part5----------------------------");

        System.out.println("part6----------------------------");
        
    }
}
