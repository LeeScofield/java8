package com.demo.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Test5 {
	public static void main(String[] args) {
		System.out.println("part1---------------------");
		Supplier<Test5Class> s = () -> new Test5Class("hello", 14);
		System.out.println(s.get().getName() + "=" + s.get().getAge()); 
		
		System.out.println("part2---------------------");
		IntSupplier ss = () -> 99;
		System.out.println(ss.getAsInt());
		
		System.out.println("part3---------------------");
		System.out.println(getMin(3,6 , (a,b) -> a - b));
		
		System.out.println("part4---------------------");
		System.out.println(getMax(3,6 , (a,b) -> a - b));
	}
	
	public static int getMin(int a ,int b,Comparator<Integer> c){
		return BinaryOperator.minBy(c).apply(a, b);
	}
	
	public static int getMax(int a ,int b,Comparator<Integer> c){
		return BinaryOperator.maxBy(c).apply(a, b);
	}
}

class Test5Class{
	private String name;
	private int age;
	
	public Test5Class(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}