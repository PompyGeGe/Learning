package com.learning.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/7/12 16:02
 * @Description:
 */
public class Test<V> {

    public void printList(List<V> list) {
        for (V item : list) {
            System.out.println(item);
        }
    }

    public void test(Test<V> example){
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");


        example.printList((List<V>) stringList); // 传递一个String类型的List

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        example.printList((List<V>) integerList); // 传递一个Integer类型的List
    }


    public static void main(String[] args) {
        Test example = new Test();
        example.test(example);

    }
}
