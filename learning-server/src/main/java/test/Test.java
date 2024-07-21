package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: 皮皮
 * @Date: 2024/6/3 18:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(new Test().getClass().getClassLoader().getResource("StudentMapper.xml").getPath());
    }



}
