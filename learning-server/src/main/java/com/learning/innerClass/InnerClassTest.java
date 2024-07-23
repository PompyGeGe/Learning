package com.learning.innerClass;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: 皮皮
 * @Date: 2022/2/14 21:55
 * @Description:
 */
@Slf4j
@Data
public class InnerClassTest {

    static class InnerClass{

        static String str;

        void show(){
            System.out.println();
        }

        static void showNew(){
            System.out.println();
        }

    }


    public static void main(String[] args) {

        /**
         * 静态内部类的用法：
         */

        //创建静态内部类实例，用于调用非静态方法
        InnerClass innerClass = new InnerClassTest.InnerClass();
        innerClass.show();

        //直接调用静态内部类的静态成员变量
        String s = InnerClassTest.InnerClass.str;

        //直接调用静态内部类的静态成员方法
        InnerClassTest.InnerClass.showNew();
    }


}
