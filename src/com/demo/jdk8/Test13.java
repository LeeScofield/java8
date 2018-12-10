package com.demo.jdk8;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by Lee on 2018-12-03.
 *
 * @author Lee
 */
public class Test13 {

    public static void getCustomer(Consumer<Integer> consumer){
        consumer.accept(10);
    }

    public static void main(String[] args) {
        /**
         * 在Spliterator类中，有一个原生接口类OfPrimitive，它的特定化类OfDouble\OfInt\OfLong，拿OfInt来说
         * 在源码670行，return tryAdvance((IntConsumer) action);，其中Consumer与IntConsumer是二个没有任何继续关系的接口
         * 这是如何做强制类型转换的，看如下：
         */
        Consumer<Integer> customer = t -> System.out.println(t);

        IntConsumer intConsumer = t -> System.out.println(t);

        System.out.println(customer instanceof  Consumer);
        System.out.println(intConsumer instanceof  IntConsumer);

        getCustomer(customer); //面象对象方式传参
//        getCustomer(intConsumer);
        getCustomer(intConsumer::accept); //函数式方式传参
        /**
         * 以面象对象的方法传参，由于Consumer和IntConsumer无继续关系，所以getCustomer(intConsumer);会报错
         * 如果像getCustomer中传入的参数是一种行为的话，编译器认为它是通过的，因为传入的这种行为会符合lambda表达式的要求
         */

    }
}
