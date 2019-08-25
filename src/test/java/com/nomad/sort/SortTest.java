package com.nomad.sort;

import org.junit.Test;

import java.util.*;

public class SortTest {

    @Test
    public void testSort1() {
        String input = "10,[20000000,40000000,40000000,40000000,20000000,10000000,25000000,25000000,25000000,26000000]";

        String[] split = input.split("\\[")[1].split("\\]")[0].split(",");

        //此处不能用HashMap : 存储顺序无序
        Map<String, Integer> salaries = new LinkedHashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (salaries.keySet().contains(split[i])){
                salaries.replace(split[i], salaries.get(split[i]) + 1);
            } else
                salaries.put(split[i], 1);
        }


        List<Map.Entry<String, Integer>> salariesList = new ArrayList<>(salaries.entrySet());

        //升序（默认） ： t0.compareTo(t1) ： t0 < or = or > t1 -1 or 0 or 1
        //降序 ： t1.compareTo(t0) ： t0 < or = or > t1  1 or 0 or -1
        //      或者重写Comparable的compareTo方法
        //      或者Comparator.compare 中return -****
        //      或者调用Comparator.reverse()方法
        //Comparator版本一
        /*Collections.sort(salariesList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> integerIntegerEntry, Map.Entry<String, Integer> t1) {
                return -integerIntegerEntry.getValue().compareTo(t1.getValue());
            }
        });

        //Comparator版本二
        //lambda表达式  jdk8
        Collections.sort(salariesList, (integerIntegerEntry, t1) -> {
            return -integerIntegerEntry.getValue().compareTo(t1.getValue());
        });*/

        //Comparator版本三
        //Comparator.comparing(方法引用)  Jdk8
        Collections.sort(
                salariesList,
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()  //会返回ReverseComparator :Collections私有内部类
        );

        /*salariesList.forEach(stringIntegerEntry -> {
            System.out.print(stringIntegerEntry.getKey() + ",");
        });*/

        int i = 0;
        for (; i < salariesList.size() - 1; i++) {
            System.out.print(salariesList.get(i).getKey() + ",");
        }
        System.out.println(salariesList.get(i).getKey());

        System.out.println(salariesList);
    }

}
