package com.learning.algorithm.sort;

/**
 * @Author: 皮皮
 * @Date: 2024/6/25 11:25
 * @Description:
 * 归并排序
 */
public class MergeSort extends Sort{


    public static void main(String[] args) {

        int[]a={2,1};

        int[] sortedArray = new Solution().execute(a, 0, a.length-1);
        printArray(sortedArray);
    }


    static class Solution{

        /**
         * 开始归并
         */
        public int[] execute(int[] a, int start, int end){
            if (end-start==0) {
                int[] array=new int[1];
                array[0] = a[start];
                return array;
            }

            //1.对左数组归并(归并好的数组是有序的)
            int[] leftArray = execute(a, start, (start+end)/2);

            //2.对右数组归并(归并好的数组是有序的)
            int[] rightArray = execute(a, (start+end)/2+1, end);

            //合并左右数组，得到一个新的有序数组(需做排序操作)
            return mergeAndSort(leftArray, rightArray);
        }

        private int[] mergeAndSort(int[] leftArray, int[] rightArray) {

            int[] temp = new int[leftArray.length + rightArray.length];

            int i=0;//左数组上的指针
            int j=0;//右数组上的指针
            int t=0;//数组t上的指针

            //比较左数组和右数组，将较小的挪到temp数组里
            while (i < leftArray.length && j < rightArray.length && t < temp.length) {

                if (leftArray[i] < rightArray[j]) {
                    temp[t] = leftArray[i];
                    i++;
                    t++;
                } else {
                    temp[t] = rightArray[j];
                    j++;
                    t++;
                }
            }

            //如果数组a还有剩余的，则加到temp数组的尾巴
            if (i != leftArray.length) {
                while(i<leftArray.length){
                    temp[t] = leftArray[i];
                    i++;
                    t++;
                }

            }
            //如果数组b还有剩余的，则加到temp数组的尾巴
            if (j != rightArray.length) {
                while(j<rightArray.length){
                    temp[t] = rightArray[j];
                    j++;
                    t++;
                }
            }

            return temp;
        }

    }



}
