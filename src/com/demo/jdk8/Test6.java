package com.demo.jdk8;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Test6 {
	public static void main(String[] args) {
		String str = "hello";
		Optional<String> strValue = Optional.of(str);

		System.out.println("part1-------------------");

		if(str != null){
			System.out.println(str);
		}

		System.out.println("part2-------------------");

		if(strValue.isPresent()){
			System.out.println(strValue.get());
		}

		System.out.println("part3-------------------");

		strValue.ifPresent(s -> System.out.println(s));

		System.out.println("part4-------------------");
		Optional<String> op = Optional.ofNullable(null);

		System.out.println(op.orElse("hahahaha"));
		System.out.println("part5-------------------");
		Optional<String> opt = Optional.ofNullable("nihao");

		System.out.println(op.orElseGet(() -> "hehehe"));
		System.out.println("part6-------------------");
		System.out.println(opt.map(m -> m + "123").orElseGet(() -> "world"));

        System.out.println("part7-------------------");

        Parent parent = new Parent();
//        List<Object> list = Arrays.asList("张三","李四");
//        parent.setList(list);

        Optional<Parent> parentVal = Optional.ofNullable(parent);
        System.out.println(parentVal.map(m -> m.getList()).orElse(Collections.emptyList()));

    }

    public void test(Optional optional){

    }

}

class Parent{
    private List<Object> list;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
