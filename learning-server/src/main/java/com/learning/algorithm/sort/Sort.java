package com.learning.algorithm.sort;
import java.util.List;

public class Sort {

    //打印数组
    static void printArray(int i, int[] array) {
        System.out.print("i=" + i + ": ");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static void printList(List<Integer> list) {
        for (Integer a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    static void swap(int[]a, int index1 , int index2){
        int temp = a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
        printArray(a);
    }

}
