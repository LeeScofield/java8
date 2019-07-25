package com.demo.jdk8;

import java.util.HashMap;
import java.util.Map;

public class TestMac {
    public static void main(String[] args) {
        System.out.println("苹果提交测试！win加测试");

//        List<String> list = Arrays.asList("a", "c", "bb");
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        List<String> list2 = (List<String>) Collections.unmodifiableCollection(list1);
//        list1.add("kkk");
//        System.out.println(list1);

//        List list = new ArrayList();
//        list.add("wyp");
//        list.add("good");
//
//        List unmodifiableList = Collections.unmodifiableList(list);

        Map<String,Integer> map=new HashMap<>();
        map.put("A", 1000);
        map.put("B", 2000);
        map.put("C", 3000);


        map.computeIfAbsent("D",v -> 333);

        System.out.println(map);

        // add new key value ("A",99), if key "A" exist in map then do function  "(X,Y) -> (Y+X)" ,the function return value will replace the oldvalue.
//        map.merge("A", 99, (X,Y) -> (Y+X));
//        Integer newValue2 = map.merge("A", 888, (X,Y) -> Y);
//        // add new key value ("D",666), if key "D" not exist in map then insert the key value to map
//        Integer newValue3 = map.merge("D", 666, (X,Y) -> Y);
//        Integer newValue4 = map.merge(null, 777, (X,Y) -> Y);
//        Integer newValue5 = map.merge(null, 5555, (X,Y) -> Y);

//        Collectors


//        for(String s:map.keySet()){
//            System.out.println(s+" : "+map.get(s));
//        }
    }
}
