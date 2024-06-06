package learning.algorithm.sort;

/**
 * @Author: 皮皮
 * @Date: 2023/8/24 10:33
 * @Description:
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] a = {2, 6, 1, 3, 5, 15,4,7};

        for (int i = 0; i < a.length-1; i++) {

            for (int j = 0; j < a.length - 1; j++) {

                if (a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }

        for (int i : a) {
            System.out.println(i);
        }




    }

}
