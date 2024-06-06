package learning.algorithm.sort;

/**
 * 2024-05-17
 */
public abstract class Test extends Sort{


    public static void main(String[] args) {
        int[] b = {20,19,18,17,16,15,14,13,12,11,10,9,8, 7, 6, 5, 4, 3, 2, 1};
//        int[] b = {6, 5, 4, 3, 2, 1};
//        int[] b = {8,7,6, 5, 4, 3, 2, 1};

        //bubble(b);

        //choose1(a);
        //choose2(a);

        //insert(a);

        //hell3(b);

        fast();

    }

    /**
     * 冒泡排序
     */
    static void bubble(int a[]){
        //冒泡，从大到小排序，小的冒到上面去
        for (int i = 0; i < a.length; i++) {//i代表循环次数 0->length-1
            for(int j = 0; j < a.length-1-i; j++){//j代表每次循环 的数组索引
                if (a[j]>a[j+1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    //从数组尾部处理
    static void choose1(int a[]){

        int maxIndex = 0;

        for (int i = 0; i < a.length-1; i++) {
            for(int j = 0; j < a.length-i; j++){//j代表每次循环 的数组索引
                if (a[j]>a[maxIndex]) {
                    maxIndex=j;
                }
            }
            swap(a, a.length-1-i, maxIndex);
            printArray(a);
        }
    }

    //从数组头部处理
    static void choose2(int a[]){

        for (int i = 0; i < a.length-1; i++) {
            int minIndex = i;

            for(int j = i; j < a.length; j++){//j代表每次循环 的数组索引
                if (a[j]<a[minIndex]) {
                    minIndex=j;
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
        for (int i = 0; i < a.length-1; i++) {
            //a[j]放到a[0]-a[i]的合适位置
            int j = i + 1;
            while(j>=1 && a[j]<a[j-1]){
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

        while(inc>=1){
            for (int i = 0; i <= a.length -1- inc; i++) {//子序列的首元素位置
                distanceSort(a, i, inc);
            }
            inc=inc/2;
        }
    }

    //增量为inc的插入排序
    static void distanceSort(int a[], int start, int inc) {
        for(int i=start; i+inc<=a.length-1; i=i+inc){
            int j = i;//记录i当前的位置
            while(j>=0 && a[j+inc]<a[j]){
                swap(a, j + inc, j);
                j-=inc;
            }
        }
    }

    /**
     * 希尔排序2
     */
    static void shell2(int a[]) {
        //初始增量
        int gap = a.length / 2;

        while(gap>=1){
            //i为跨度为gap的有序序列的后面第一个元素
            for (int i = gap; i - gap >=0 && i<a.length; i++) { //和常规的插入排序不同，此还没处理完序列剩余的，就以i+1递增处理别的序列去了
                for (int j = i; j >= gap && a[j] < a[j - gap]; j = j - gap) {
                    swap(a, j, j-gap);
                }

            }
            gap=gap/2;
        }

    }

    /**
     * 希尔排序3(有点绕，不建议)
     */
    static void shell3(int a[]) {
        //初始增量
        int gap = a.length / 2;

        while(gap>=1){
            //i为跨度为gap的有序序列的最后一个元素
            for (int i = 0; i<=a.length-2 && i+gap<=a.length-1; i++) { //和常规的插入排序不同，此还没处理完序列剩余的，就以i+1递增处理别的序列去了
                for (int j = i+gap; j >= gap && a[j] < a[j-gap]; j = j - gap) {
                    swap(a, j, j-gap);
                }
            }
            gap=gap/2;
        }
    }


    /**
     * 快排
     */
    static void fast() {

//        int a[] = {1, 4, 2, 3, 5, 9, 6, 8, 7, 10};
        int a[] = {45,80,55,40,42,85};

        int i=0;
        int j = a.length - 1;
        int space = 0;
        int init = a[space];

        while (i <= j) {

            if(a[j]>=init && j>0){
                j--;
            }else  if(a[j]<init && j>0){
                a[space]=a[j];
                space=j;
                j--;
            }

            if(a[i]<=init && i<a.length-1){
                i++;
            }else if(a[i]>init && i<a.length-1){
                a[space]=a[i];
                space=i;
                i++;
            }

        }

        a[space] = init;

        printArray(a);
    }


}
