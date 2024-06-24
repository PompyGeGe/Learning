package learning.algorithm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/6/23 15:10
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println(finonaqi(list, 6));
        System.out.println(climbStairs(6));
    }


    public static int climbStairs(int n) {
        double d = Math.sqrt(5);
        return (int)Math.round(Math.pow((1 + d) / 2, n + 1) / d);
    }


    public static int finonaqi(List<Integer> list, int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        //i作为指针
        int i=2;

        while (i <= n-1) {
            //把指针i的值放入list里
            list.add(list.get(i - 1) + list.get(i - 2));
            i++;
        }

        return list.get(n - 1);
    }
}
