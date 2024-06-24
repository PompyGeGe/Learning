package learning.algorithm.sort;

/**
 * 2024-05-17
 * 自我测试
 */
public class SortSelfTest extends Sort {

    /**
     * 冒泡排序
     */
    static void bubble(int a[]) {
        //冒泡，从大到小排序，小的冒到上面去
        for (int i = 0; i < a.length; i++) {//i代表循环次数 0->length-1
            for (int j = 0; j < a.length - 1 - i; j++) {//j代表每次循环 的数组索引
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    //从数组尾部处理
    static void choose1(int a[]) {

        int maxIndex = 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i; j++) {//j代表每次循环 的数组索引
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(a, a.length - 1 - i, maxIndex);
            printArray(a);
        }
    }

    //从数组头部处理
    static void choose2(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;

            for (int j = i; j < a.length; j++) {//j代表每次循环 的数组索引
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
            printArray(a);
        }
    }

    /**
     * 插入排序
     */
    static void insert(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            //a[j]放到a[0]-a[i]的合适位置
            int j = i + 1;
            while (j >= 1 && a[j] < a[j - 1]) {
                swap(a, j, j - 1);
                j--;
                printArray(a);
            }
        }
    }

    /**
     * 希尔排序1
     */
    static void shell1(int a[]) {
        //初始增量
        int inc = a.length / 2;

        while (inc >= 1) {
            for (int i = 0; i <= a.length - 1 - inc; i++) {//子序列的首元素位置
                distanceSort(a, i, inc);
            }
            inc = inc / 2;
        }
    }

    //增量为inc的插入排序
    static void distanceSort(int a[], int start, int inc) {
        for (int i = start; i + inc <= a.length - 1; i = i + inc) {
            int j = i;//记录i当前的位置
            while (j >= 0 && a[j + inc] < a[j]) {
                swap(a, j + inc, j);
                j -= inc;
            }
        }
    }

    /**
     * 希尔排序2
     */
    static void shell2(int a[]) {
        //初始增量
        int gap = a.length / 2;

        while (gap >= 1) {
            //i为跨度为gap的有序序列的后面第一个元素
            for (int i = gap; i - gap >= 0 && i < a.length; i++) { //和常规的插入排序不同，此还没处理完序列剩余的，就以i+1递增处理别的序列去了
                for (int j = i; j >= gap && a[j] < a[j - gap]; j = j - gap) {
                    swap(a, j, j - gap);
                }

            }
            gap = gap / 2;
        }

    }

    /**
     * 希尔排序3(有点绕，不建议)
     */
    static void shell3(int a[]) {
        //初始增量
        int gap = a.length / 2;

        while (gap >= 1) {
            //i为跨度为gap的有序序列的最后一个元素
            for (int i = 0; i <= a.length - 2 && i + gap <= a.length - 1; i++) { //和常规的插入排序不同，此还没处理完序列剩余的，就以i+1递增处理别的序列去了
                for (int j = i + gap; j >= gap && a[j] < a[j - gap]; j = j - gap) {
                    swap(a, j, j - gap);
                }
            }
            gap = gap / 2;
        }
    }


    /**
     * 快排-挖坑法
     * 下面写的好像有问题
     */
    static void fast() {

        int a[] = {5, 7, 9, 3, 8, 6, 4, 2, 1};
//        int a[] = {45,80,55,40,42,85};

        int i = 0;
        int j = a.length - 1;
        int hole = 0;
        int init = a[hole];

        while (i <= j) {

        }

        a[hole] = init;

        printArray(a);
    }

    public static int sum=0;

    /**
     * 【快速排序思路】：
     * 思路：选取数组的第一个元素为基准元素，经过一系列操作，使其落到数组的合适的位置（左边的元素比它小，右边的元素比它大）
     *      然后再递归，让其左子数组和右子数组以同样的方式进行下去
     *
     * 整体分三大步：
     * 1.处理自身数组
     * 2.处理左子数组
     * 3.处理右子数组
     *
     * 每次操作，考虑到左子数组和右子数组，i和j共移动（或和基准元素比较）的次数为大致数组长度n-1(因为j从右边左移，i从左边右移，直到两者相等)
     * 这样的操作的次数为树的高度。比如[1,2,3,4,5,6,7]的i和j的移动总次数为：
     *        (原数组)6次
     * (左子数组为3)2次   (右子数组长度为4)3次   --共5次
     * ...   ...  ...   ...
     * 直到子数组长度<=1停止
     *
     * （参考：https://blog.csdn.net/m0_73868817/article/details/130000934）
     *
     * Hoare法
     */
    static void quickSort_Hoare() {

        int a[] = {5, 7, 9, 3, 8, 6, 4, 2, 1};
//        int a[] = {1,2,3,4,5,6,7,8,9};
//        int a[] = {9, 8,7,6,5,4,3,2,1};

        int start = 0;
        int end = a.length - 1;

        quickSort(a, start, end);

        System.out.println(sum);
    }

    /**
     *
     * @param a
     * @param start
     * @param end
     */
    static void quickSort(int a[], int start, int end) {

        /**
         * 这个限制很重要，右指针和左指针的间隔>=1时才有效，即end-start>=1，即end>start才生效！
         */
        if (start >= end) {
            return;
        }

        //设置初始值
        int i = start;
        int j = end;
        int baseIndex = start;

        while (i != j) {

            /**
             * 思路：
             * 当前循环里：
             * 1.右指针先动
             * 2.右指针向左移动，直到找到比基准元素小的元素终止，或i和j重合时终止
             * 3.左指针向右移动，直到找到比基准元素大的元素为止，或i和j重合时终止
             * 4.交换i和j的元素
             */
            while (a[j] >= a[baseIndex] && i != j) {
                j--;
                sum++;
            }

            while (a[i] <= a[baseIndex] && i != j) {
                i++;
                sum++;
            }

            //交换i和j指针的元素位置
            swap(a, i, j);
        }
        //i的位置就是基准元素最终的位置
        swap(a, i, baseIndex);
        //以5为基准元素，第一趟排序的结果是：4 1 2 3 5 6 8 9 7

        quickSort(a, start, i-1);
        quickSort(a, i + 1, end);
    }

    /**
     * 快速排序-用栈来模拟递归
     * @param a
     */
    public static void quick_sort_stack(int a[]){







    }


}
