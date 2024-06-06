package learning.algorithm.sort;


/**
 * 希尔排序
 * 问题： 为什么不用把整个序列划分为挨着的子序列(比如87654321, 划分成[8765][4321])，在每个子序列里去排序呢？
 *       每个子序列的元素排好后，只是在自己的序列里是有序的，但在最终的位置仍然比较远。比如排好序后[5678][1234]中的1离最终的位置(0位置)还是较远
 * 而希尔排序是以固定增量的元素分为一组，以增量跳跃的方式，将元素离其最终位置较近。
 * 其核心思想是："将元素排到离其最终位置较近的地方，减少后续排序操作"。
 * 举个最简单的例子：87654321序列 。  1<->8 2<->7  3<->6  4<->5 只需进行4次交换(都交换到了最近的位置)，就可以将序列拍好了。
 */
class ShellSort extends Sort {

    public static void main(String[] args) {

        int[] array = {2, 10, 20, 3, 9, 7, 5, 25, 15, 6};

        //1.设置跨度数组元素：简单地设置为原数组长度的一半
        for (int gap = array.length / 2; gap >= 1; gap = gap / 2) {
            System.out.println("\ngap=" + gap+":");
            //2.数组首元素的范围是0到gap,且加了gap后不能超过数组长度：
            for (int i=0; i<gap;i++) {  //(本来还要i+gap<array.length，但gap最大为数组长度的一半，i<gap，所以恒成立)
                //3:i的指针向右移，每次移动都对应一个数组，对每个数组进行插入排序，首元素坐标为i,跨度为gap,数组为array
                insertSort(i, gap, array);
                printArray(array);
            }
        }
    }

    /**
     * 插入排序:
     * 首元素坐标为i,跨度为gap,数组为array
     */
    static void insertSort(int i, int gap, int[] array) {//{2, 10, 20, 3, 9, 7, 5, 20, 15, 6};
        for (int j = i; j<array.length-1; j=j+gap) {  //j的初始值为i，指针向后移动，增长gap个位置
            for(int k=j; k>=0 && k+gap<=array.length-1 ; k=k-gap){  //k的初始值为j，指针向前移动，缩小gap个位置
                if (array[k+gap]<array[k]) {
                    switchTwo(k+gap, k, array); //交换相邻的两个元素去排序(还有另外一种方式是所有的元素向后移动)
                }else{
                    break;
                }
            }

        }

    }

    /**
     * 交换2个数
     */
    private static void switchTwo(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2]=temp;
    }


}