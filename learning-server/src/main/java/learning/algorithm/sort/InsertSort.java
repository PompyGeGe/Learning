package learning.algorithm.sort;

/**
 * 插入排序
 */
class InsertSort extends Sort{

    public static void main(String[] args) {

        int[] a = {4, 10, 20, 3, 9, 7, 2, 20, 15, 6};

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

}
