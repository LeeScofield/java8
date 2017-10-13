package com.demo.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test3 {
	public static void main(String[] args) {
		
		System.out.println("part1------------------");
		List<String> list = Arrays.asList("a","b","hello");
		
		list.stream().map(i -> i.toUpperCase()).forEach(i -> System.out.println(i));
		
		System.out.println("part2--------------------");
		
		list.stream().map(String::toUpperCase).forEach(i -> System.out.println(i));
		
		System.out.println("part3--------------------");
		
		Function<String , String> fun = String::toUpperCase;
		System.out.println(fun.apply("hello"));
		
		System.out.println("part4-------------------");
		System.out.println(calc1(3, v -> v+1));
		
		System.out.println("part5------------------");
		System.out.println(calc2(2, v -> v + 1, v -> v * 2));
		
		System.out.println("part6------------------");
		System.out.println(calc3(2, v -> v + 1, v -> v * 2));
	
		System.out.println("part7------------------");
		System.out.println(calc4(1,3,(v1,v2) -> v1 + v2));
		
		System.out.println("part8------------------");
		System.out.println(calc5(1,3,(v1,v2) -> v1 + v2 ,v -> v + 3) );
	}
		
	
	public static Integer calc1(Integer a ,Function<Integer, Integer> fun){
		return fun.apply(a);
	}
	
	public static Integer calc2(int a ,Function<Integer, Integer> fun1,Function<Integer, Integer> fun2){
		return  fun1.compose(fun2).apply(a);
	}
	
	public static Integer calc3(int a ,Function<Integer, Integer> fun1,Function<Integer, Integer> fun2){
		return  fun1.andThen(fun2).apply(a);
	}
	
	public static Integer calc4(int a ,int b ,BiFunction<Integer, Integer, Integer> biFun){
		return biFun.apply(a, b);
	}
	
	public static Integer calc5(int a ,int b ,BiFunction<Integer, Integer, Integer> biFun,Function<Integer, Integer> fun){
		return biFun.andThen(fun).apply(a, b);
	}
}
