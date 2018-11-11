package com.demo.jdk8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Lee
 * date:2017-10-24
 */
public class Test8Stream {
    public static void main(String[] args) {
        System.out.println("Stream的创建方式");
        Stream stream1 = Stream.of("zhangsan", "lisi", "wangwu");

        String[] str2 = {"zhangsan", "lisi", "wangwu"};
        Stream stream2 = Stream.of(str2);

        List list3 = Arrays.asList("zhangsan", "lisi", "wangwu");
        Stream stream3 = list3.stream();

        System.out.println("part1----------------------------");
        IntStream.of(3, 1, 4, 9).forEach(System.out::println);

        System.out.println("part2----------------------------");
        IntStream.range(1, 4).forEach(System.out::println);
        System.out.println("---");
        IntStream.rangeClosed(1, 4).forEach(System.out::println);

        System.out.println("part3----------------------------");
        List<Integer> partList3 = Arrays.asList(1, 2, 3);
        Integer sum3 = 0;
        for (Integer o : partList3) {
            sum3 += o * 2;
        }
        System.out.println("sum3:" + sum3);
        Integer sum33 = partList3.stream().map(integer -> integer * 2).reduce(0, Integer::sum);
        System.out.println("sum33:" + sum33);

        System.out.println("part4----------------------------");
        Stream<String> stream4 = Stream.of("list1", "list2", "list3");
        List<String> list4 = stream4.collect(() -> new ArrayList<String>(), (newlist,ele) -> newlist.add(ele),
                (newList1, newList2) -> newList1.addAll(newList2));

        list4.forEach(System.out::println);
        System.out.println("---");

        Stream<String> stream44 = Stream.of("list1", "list2", "list3");
        List<String> list44 = stream44.collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
        list44.forEach(System.out::println);
        System.out.println("---");

        Stream<String> stream444 = Stream.of("list1", "list2", "list3");
        List<String> list444 = stream444.collect(Collectors.toList());
        list444.forEach(System.out::println);
        System.out.println(list444.getClass().getName());

        System.out.println("part5----------------------------");
        Stream<String> stream5 = Stream.of("list1", "list2", "list3");
        List<String> list5 = stream5.collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list5.getClass().getName());

        System.out.println("part6----------------------------");
        Stream<String> stream6 = Stream.of("list1", "list2", "list3");
        String str6 = stream6.collect(Collectors.joining());
        System.out.println(str6);

        System.out.println("part7----------------------------");
        Stream<List<Integer>> stream7 = Stream.of(Arrays.asList(1,2), Arrays.asList(3), Arrays.asList(4,5));
        List<Integer> list7 = stream7.flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(list7);

        System.out.println("part8----------------------------");
//        Stream stream8 = Stream.empty();
        Stream stream8 = Stream.generate(UUID.randomUUID()::toString);
        stream8.findFirst().ifPresent(System.out::println);

        System.out.println("part9----------------------------");
        Stream.iterate(1,i -> i + 2).limit(3).forEach(System.out::println);

        System.out.println("part10----------------------------");
        Stream.iterate(1, i -> i + 1).limit(5).skip(2).forEach(System.out::println);

        System.out.println("part11----------------------------");
        IntStream.of(1,1,3,4,5,6,4).distinct().forEach(System.out::println);

        System.out.println("part12----------------------------");
        IntStream.of(1,2,3,4,5).max().ifPresent(System.out::println);

        System.out.println("part13----------------------------");
        IntSummaryStatistics intSummaryStatistics = IntStream.of(1, 2, 3, 4, 5).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
    }
}
