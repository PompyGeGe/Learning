package com.learning.abstractMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: 皮皮
 * @Date: 2022/1/8 17:39
 * @Description:
 */
@Slf4j
public class Test {


    public static void main(String[] args) throws ClassNotFoundException {
        //1.抽象方法不能创建实例
        //2.子类集成抽象类，并实其现抽象方法后可以被实例化
        new Child();
        //3.根据多态特性，一般有下边的用法
        Person p = new Child();
        System.out.println(p.getClass());//输出的类的名字是Child

        System.out.println(Class.forName("Person"));

    }
}
