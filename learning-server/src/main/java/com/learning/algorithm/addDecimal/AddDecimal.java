package com.learning.algorithm.addDecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/6/3 18:41
 * @Description: 十进制加法
 */
public class AddDecimal {

    /**
     * 两个十进制的数，用数组保存，输出它们之和
     * 注意：数组的第一个元素存的最高位，最后一个元素存的最低位。用进位法算的话，得先从个位开始算。
     * @param args
     */
    public static void main(String[] args) {
        //int a[] = {4, 5, 9};
        int a[] = {9, 4, 5, 9};
        int b[] = {1, 7, 6, 1};
        System.out.println(new Solution1().add(a, b));
        System.out.println(new Solution2().add(a, b));
    }

    /**
     * 简单的解法，实际上没有用到进制
     */
    static class Solution1{
        /**
         * 返回总数
         * @param a
         * @param b
         * @return
         */
        public int add(int a[], int b[]){
            int maxIndex = a.length>b.length?a.length:b.length;
            int[]sumArray = new int[maxIndex];

            int n = maxIndex-1;//控制整个循环
            int i = a.length-1;//控制a数组指针的移动
            int j = b.length-1;//控制b数组指针的移动
            int s = maxIndex-1;//控制sum数组指针的移动


            //以sum数组为标准，移动其指针
            while (n>=0) {
                //每个数组的都从最后一个元素开始处理(也可以从每个数组的第一个元素处理)
                sumArray[s] = tenMi(maxIndex-1-s)*(getInt(a, i)+getInt(b, j));

                n--;

                i--;
                j--;
                s--;
            }

            return sum(sumArray);
        }
    }

    /**
     * 标准的解法，用到了进位
     * 此方案必须先从个位开始算
     */
    static class Solution2{
        /**
         * 返回总数
         * @param a
         * @param b
         * @return
         */
        public int add(int a[], int b[]){
            int maxIndex = a.length>b.length?a.length:b.length;
            int[] sumArray = new int[maxIndex + 1];

            //控制循环结束
            int n = sumArray.length-1;;

            //数组a的个位的位置
            int i=a.length-1;
            //数组b的个位的位置
            int j=b.length-1;
            //数组sum的个位的位置
            int s=sumArray.length-1;

            //上一位的进位数
            int carry = 0;

            while (n>=0) {
                //当前位的总数
                int currentSum = getInt(a, i) + getInt(b, j) + carry;//carry是上一位的进位数
                //当前位的进位数(其实最大的就是1)
                carry = currentSum/10;

                //余数才是我们想要的
                sumArray[s] = currentSum % 10;

                n--;

                i--;
                j--;
                s--;
            }

            return arrayToStr(sumArray);
        }

        public int arrayToStr(int[] array){
            String str="";
            for (int i =0; i<array.length; i++) {
                str += array[i];
            }
            return Integer.parseInt(str);
        }

    }




    static int getInt(int array[], int i) {
        if (i < 0 || i>=array.length) {
            return 0;
        }
        return array[i];
    }


    static int tenMi(int i){
        int sum=1;
        if (i == 0) {
            return 1;
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

    static int sum(List<Integer> list){
        int sum=0;
        for (Integer i : list) {
            sum+=i;
        }
        return sum;
    }




}
