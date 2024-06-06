package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: 皮皮
 * @Date: 2024/6/3 18:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");

        Consumer consumer=item-> System.out.println(item);

        Consumer consumer1= new Consumer(){

            @Override
            public void accept(Object o) {
                System.out.println("你没得="+o.toString());

            }
        };


        consumer1.accept("你你你");
    }
}
