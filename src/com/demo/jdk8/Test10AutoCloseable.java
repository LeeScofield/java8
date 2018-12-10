package com.demo.jdk8;

/**
 * Created by Lee on 2018-11-28.
 *
 * @author Lee
 */
public class Test10AutoCloseable {

    public static void main(String[] args) throws Exception {

        /**
         *  jdk1.7提供了AutoCloseable接口，会在try(){}后自动调用接口中的close方法
         */
        try(Test10 t = new Test10()){
            t.sayHello();
        }
    }

}

class Test10 implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("close invoked!");
    }

    public void sayHello(){
        System.out.println("hello");
    }
}