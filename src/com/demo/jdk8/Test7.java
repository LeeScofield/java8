package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Lee
 */
public class Test7 implements MyInter1, MyInter2{
	@Override
	public void sayHello(){
		MyInter2.super.sayHello();
	}

	public static void main(String[] args) {
		Person7 p1 = new Person7("zhaoda", 25);
		Person7 p2 = new Person7("wanger",19);
		Person7 p3 = new Person7("zhangsan",46);
		Person7	p4 = new Person7("lisi",23);


		List<Person7> list = Arrays.asList(p1,p2,p3,p4);
		System.out.println("part1-------------");

		list.sort((a , b) -> Person7.sortByAge(a, b));
		list.forEach(a -> System.out.println(a.getAge()));
		System.out.println("静态方法引用");
		list.sort(Person7::sortByAge);
		list.forEach(a -> System.out.println(a.getAge()));
		
		System.out.println("part2-------------");
		SortUtil7 sort = new SortUtil7();
		list.sort((a,b) -> sort.sortByAge(a, b));
		list.forEach(a -> System.out.println(a.getAge()));
		System.out.println("实例方法引用");
		list.sort(sort::sortByAge);
		list.forEach(a -> System.out.println(a.getAge()));
		list.forEach(System.out::println);
		System.out.println("类的实例方法引用");
		list.sort(Person7::objectSortByAge);
		list.forEach(a -> System.out.println(a.getAge()));

		System.out.println("类的构造方法引用");
		Test7 t = new Test7();
		System.out.println(t.getString(() -> "123"));
		System.out.println("----");
		System.out.println(t.getString(String::new));
		System.out.println(t.getString2("hehe", String::new));
		t.sayHello();
	}
	
	public String getString(Supplier<String> supplier){
		return supplier.get() + " hello";
	}
	public String getString2(String p, Function<String, String> f){
		return f.apply(p) + " hello";
	}
}

class Person7{
	private String name;
	private Integer age;

	public Person7(String name, Integer age) {
		super();
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
	
	public static int sortByAge(Person7 p1,Person7 p2){
		return p1.getAge() - p2.getAge();
	}

	public static int sortByName(Person7 p1,Person7 p2){
		return p1.getName().compareToIgnoreCase(p2.getName());
	}

	public int objectSortByAge(Person7 p){
		return this.age - p.getAge();
	}
	
}

class SortUtil7{
	public int sortByAge(Person7 p1,Person7 p2){
		return p1.getAge() - p2.getAge();
	}

	public int sortByName(Person7 p1,Person7 p2){
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}

interface MyInter1{
	default void sayHello(){
		System.out.println("hello");
	}
}

interface MyInter2{
	default void sayHello(){
		System.out.println("你好");
	}
}
