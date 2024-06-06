package learning.algorithm.sort;

/**
 * @Author: 皮皮
 * @Date: 2024/5/20 16:11
 * @Description:
 */
public class Paixu extends  Sort{


    public static void sort(int[] arr) {

        int gap = 1;

            // 对每个子序列进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    printArray(arr);
                }
                arr[j] = temp;
            }
    }


    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        sort(arr);
    }




}
