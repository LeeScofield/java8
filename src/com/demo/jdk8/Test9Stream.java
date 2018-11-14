package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lee on 2018-11-12.
 *
 * @author Lee
 */
public class Test9Stream {
    public static void main(String[] args) {
        System.out.println("part1----------------------------");
        //将stream中的单词去重
        Stream<String> stream1 = Stream.of("happy new", "new year", "happy year","new happy");

        stream1.map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
        //或
//        stream1.flatMap(item -> Arrays.asList(item.split(" ")).stream()).distinct().collect(Collectors.toList())
//        .forEach(System.out::println);
        System.out.println("part2----------------------------");
        //笛卡尔集，二个集合中数据交叉拼接
        List<String> list1 = Arrays.asList("hello","world","today");
        List<String> list2 = Arrays.asList("a","b","c");

        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("part3----------------------------");
        Student s1 = new Student("zhangsan", 30);
        Student s2 = new Student("lisi", 26);
        Student s3 = new Student("wangwu",30);
        Student s4 = new Student("lisi",22);

        //根据姓名分组
        List<Student> list3 = Arrays.asList(s1, s2, s3, s4);
        Map<String,List<Student>> map3 = list3.stream().collect(Collectors.groupingBy(Student::getName));
        map3.forEach((key,value) -> System.out.println(key+":"+value));

        System.out.println("part4----------------------------");
        //查看根据姓名分组后每组多少数量
        List<Student> list4 = Arrays.asList(s1, s2, s3, s4);
        Map<String,Long> map4 = list4.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        map4.forEach((key,value) -> System.out.println(key+":"+value));

        System.out.println("part5----------------------------");
        //查看根据姓名分组后，每个组平均年龄
        List<Student> list5 = Arrays.asList(s1, s2, s3, s4);
        Map<String,Double> map5 = list5.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getAge)));
        map5.forEach((key,value) -> System.out.println(key+":"+value));

        System.out.println("part6----------------------------");
        //查看根据年龄分区，25岁以上为一个区，分区类似于分组，但是只有二个，一个true,一个false,
        List<Student> list6 = Arrays.asList(s1, s2, s3, s4);
        Map<Boolean,List<Student>> map6 = list6.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 25));
        map6.forEach((key,value) -> System.out.println(key+":"+value));

    }
}


class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}