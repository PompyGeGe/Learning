package com.learning.privateConstructor;

import lombok.Data;

/**
 * 私有构造函数的好处：
 *     私有构造方法无法在外部类里使用，导致本类无法在外部用new被实例化。 结合static的getPerson方法使用，可以达到只给外部提供一个实例的效果。
 */
@Data
public class Person {
    private Person(){}

    private static Person instance = new Person();

    public static Person getPerson(){
        return instance;
    }
}
