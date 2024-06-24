package learning.algorithm.slidingWindow;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 皮皮
 * @Date: 2024/6/19 16:32
 * @Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组
 */
public class SelfTest {
    //输入s = 7, nums = [2,3,1,2,4,3] 输出：2  ，子数组 [4,3] 是该条件下的长度最小的子数组。
    static final int[] nums={2,3,1,2,4,3};

    public static void main(String[] args) {
        //new BlastingMethod().execute();
    }

    //爆破法
    static class BlastingMethod{

        void execute(){
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    List<Integer> list = addToList(i, j);
                    if (getSum(list)==7) {
                        //等于7的才加进来
                        lists.add(list);
                    }
                }
            }

            if (CollectionUtils.isEmpty(lists)) {
                return ;
            }

            //初始化
            List<Integer> minLengthList = lists.get(0);

            for (List<Integer> list : lists) {
                if (list.size() < minLengthList.size()) {
                    minLengthList = list;
                }
            }

            for (Integer i : minLengthList) {
                System.out.print(i+" ");
            }
        }

    }


    /**把i到j的所有元素加到list里
     *
     * @param i
     * @param j
     * @return
     */
    private static List<Integer> addToList(int i, int j) {
        List<Integer> list = new ArrayList<>();

        for (int k = i; k <= j; k++) {
            list.add(nums[k]);
        }

        return list;
    }


    private static int getSum(List<Integer> list) {
        int sum=0;

        for (Integer i : list) {
            sum+=i;
        }
        return sum;
    }


}
