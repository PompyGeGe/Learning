package com.learning.Functionallnterface;

/**
 * @Description:
 * 函数式接口是java8为引入Lambda产生的
 */
@FunctionalInterface//此注解只是为了检测此接口符合函数式接口定义的规范
public interface Compute<T> {

    /**
     * 函数式接口只能有一个抽象方法
     */
    public abstract int add(int a, int b);

    /**
     * 多个默认方法; default关键词是Java8提出的，用于修饰接口里的方法。接口里被default修饰的方法可以写方法体。其他类实现此接口时就无需实现此方法了。
     */
    default int multiply(int a, int b) {
        return a * b;
    }

    default int divide(int a, int b) {
        return a / b;
    }

    /**
     * 定义静态内部接口
     */
    static interface IMessage{
        public String getContent();
    }

    /**
     * 定义静态方法，也是从java8引进的
     */
    public static void send(String str){
        System.out.println(str);
    }

    /**
     * interface和class的默认修饰符都是public, 而且指定时也只能指定为public！
     */
}
