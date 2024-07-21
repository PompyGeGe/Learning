package com.learning.Functionallnterface;

/**
 * @Author: 皮皮
 * @Date: 2024/6/30 10:34
 * @Description:
 */
@FunctionalInterface
public interface PrintInterface<T> {
    
    abstract void print(T t);

}
