package com.demo.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {
	public static void main(String[] args) {
		for_test();
		for_newMethod();
		for_lambda();
		
//		Animal a = food -> {System.out.println(food);};
//		a.eat("鱼");
		Animal a = System.out::println;
		a.eat("肉");
		
		new Thread(() -> {System.out.print("123");}).start();
	}
	
	public static void for_test(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		for(Integer i : list){
			System.out.println(i);
		}
	}
	
	public static void for_newMethod(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		});
	}
	
	public static void for_lambda(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//		list.forEach(i -> System.out.println(i));
		list.forEach(System.out::println);
		Consumer c = System.out::println;
		
	}
}
