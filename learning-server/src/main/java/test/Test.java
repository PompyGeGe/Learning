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
        int a[] = {4, 5, 9};
        int b[] = {1, 7, 6, 1};
        System.out.println(add(a, b));
    }

    /**
     * 返回总数
     * @param a
     * @param b
     * @return
     */
    public static int add(int a[], int b[]){
        int maxIndex = a.length>b.length?a.length:b.length;
        int[]sum= new int[maxIndex];

        int i=maxIndex-1;
        while (i>0) {
            sum[i] = tenMi(maxIndex-1-i)*(getInt(a, i)+getInt(b, i));
            i--;
        }

        return sum(sum);
    }

    static int getInt(int array[], int i) {
        if (i >= array.length - 1) {
            return 0;
        }
        return array[i];
    }


    static int tenMi(int i){
        int sum=1;
        if (i == 0) {
            return sum;
        }

        while(i>=1){
            sum*=10;
            i--;
        }
        return sum;
    }

    static int sum(int array[]){
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }



}
