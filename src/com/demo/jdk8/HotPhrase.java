package com.demo.jdk8;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lee on 2019-04-29.
 *
 * @author Lee
 */
public class HotPhrase {
    public static void main(String[] args) throws Exception{
        System.out.println("输入文件绝对路径>>>>>>>>>>>>>>>>>");

        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
//        String path = "C:\\Users\\Lee\\Desktop\\a.txt";

        System.out.println("输入高低频次排序(不输为从大小到，输入任意为从小到大)>>>>>>");
        Scanner scanner1 = new Scanner(System.in);
        String order = scanner1.nextLine();

        order = Optional.ofNullable(order).map(o -> {
            if (o.trim().equals("")) {
                return "desc";
            } else {
                return "asc";
            }
        }).orElseGet(() -> "desc");

        System.out.println("输入需要显示前几位");
        Scanner scanner2 = new Scanner(System.in);
        Integer limit = 10;
        try {
            limit = Integer.valueOf(scanner2.nextLine());
        } catch (Exception e) {
            limit = 10;
        }


        FileInputStream fileInputStream = new FileInputStream(new File(path));

        byte[] b = new byte[1024];
        int len = 0;

        //原始文本
        StringBuffer stringBuffer = new StringBuffer();

        while ((len = fileInputStream.read(b)) != -1) {
            stringBuffer.append(new String(b,0,len));
        }

        //去掉换行后的所有文本
        String allText = formatChar(stringBuffer.toString());

        //统计单词分组，所有单词都转小写
        Map<String, Integer> map = Stream.of(allText.split("\\s+")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.summingInt(s-> 1)));

        Map<String, Integer> sortData =null;

        if(order.equals("asc")){
            sortData =map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).limit(limit)
                    .collect(LinkedHashMap::new,(m,e) -> m.put(e.getKey(),e.getValue()),LinkedHashMap::putAll);
        }else{
            sortData = map.entrySet().stream().sorted(Comparator.comparingInt((Map.Entry<String,Integer> m) -> m.getValue()).reversed()).limit(limit)
                    .collect(LinkedHashMap::new,(m,e) -> m.put(e.getKey(),e.getValue()),LinkedHashMap::putAll);
        }

        sortData.forEach((k,v) -> {
            System.out.println(k + ":"  + v);
        });

        fileInputStream.close();
    }

    /**
     * 去掉标点及换行
     * @param str
     * @return
     */
    public static String formatChar(String str){
        return str.replace(",", "")
                .replace(".", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replaceAll("\\n+", " ");
    }

}
