package learning.algorithm.sort;

/**
 * 选择排序
 */
class SelectSort extends Sort{

    public static void main(String[] args) {

        int[] array = {4, 10, 20, 3, 9, 7, 2, 20, 15, 6};

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { //防止自己和自己换
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

            printArray(i, array);
        }

    }

}
