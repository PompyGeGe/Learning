package learning.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

/**
 * @Author: 皮皮
 * @Date: 2024/6/25 19:05
 * @Description: 钱包里有1元、2元、5元的三种硬币
 * 从钱包取出一些硬币买11元的东西， 最少需要 几枚硬币？
 */
public class Coin {
    public static final int MAX_VALUE = 999999;

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int FIVE = 5;

    /**
     * 爆破法
     */
    static class Blasting {
        public List<int[]> execute(int sum) {

            List<int[]> list = new ArrayList<>();

            for (int x = 0; x <= sum; x++) {
                for (int y = 0; y <= sum; y++) {
                    for (int z = 0; z <= sum; z++) {
                        if (ONE * x + TWO * y + FIVE * z == sum) {
                            list.add(new int[]{x, y, z});
                        }
                    }
                }
            }
            return list;
        }
    }

    /**
     * 尽量选择大的硬币
     */
    static class ChooseMaxCoin {
        void execute(int sum) {
            int fiveNum = sum / FIVE;
            int surplus1 = sum % FIVE;

            int twoNum = surplus1 / TWO;
            int surplus2 = surplus1 % TWO;

            int oneNum = surplus2 / ONE;

            System.out.println(oneNum + "," + twoNum + "," + fiveNum);
        }
    }

    /**
     * 动态规划-递归实现（自顶向下）（没有备忘录表，自己加）
     */
    static class DynamicProgramming1 {

        public int execute(int moneyAmount, int[] coins) {
            int num = getMin(moneyAmount, coins);
            if (num == 0) {
                return -1;
            }
            return num;
        }

        /**
         * 拼凑出moneyAmount的金额，至少需要的硬币数
         * 思路：要拼凑的总额为moneyAmount. 硬币数的最小值f(n)
         * 假设有这些数额的硬币：[1, 2, 5]
         * 若第一次拿的是1元的硬币，则至少还需要的硬币数是f(moneyAmount-1);共需1+f(moneyAmount-1)枚硬币 --> 即：总硬币数f(moneyAmount)的最小值 = f(moneyAmount-1)最小值 + 1
         * 若第一次拿的是2元的硬币，则至少还需要的硬币数是f(moneyAmount-2);共需1+f(moneyAmount-2)枚硬币 --> 即：总硬币数f(moneyAmount)的最小值 = f(moneyAmount-2)最小值 + 1
         * 若第一次拿的是5元的硬币，则至少还需要的硬币数是f(moneyAmount-5);共需1+f(moneyAmount-5)枚硬币 --> 即：总硬币数f(moneyAmount)的最小值 = f(moneyAmount-5)最小值 + 1
         * 每种硬币都是一种情况，求这些情况的最小值
         * !!还要考虑前提条件!!
         * 即，如果f(moneyAmount-1)存在解的方案时才能算出1+f(moneyAmount-1)，其他情况也如此！
         * 比如14元用[5,10]是凑不出来的
         *
         * 【难点有一个：f(0)=0, 而其他f(<0的数)=-1 这个要自己推导出来】
         *
         * @param moneyAmount
         * @return
         */
        public int getMin(int moneyAmount, int[] coins) {
            if (moneyAmount == 0) {
                return 0;
            }
            if (moneyAmount < 0) {
                return -1;
            }


            int min = MAX_VALUE;

            for (int i = 0; i < coins.length; i++) {
                int num = getMin(moneyAmount - coins[i], coins);
                if (num >= 0) {
                    min = Math.min(num, min);
                }
            }

            if (min == MAX_VALUE) {
                return -1;
            } else {
                return min + 1;
            }
        }
    }


    /**
     * 动态规划-迭代实现(自底向上)，还加了备忘录表提高性能
     *【难点有两个：
     *  f(0)=0, 而其他f(<0的数)=-1 这个要自己推导出来;
     *  当查询的dp[i]为-1时，是不能参与计算最小值的;
     * 】;
     */
    static class DynamicProgramming2 {
        public int execute(int amount, int[] coins) {
            //备忘录
            int[] dp = new int[amount + 1];
            dp[0] = 0;

            //遍历金额，先从最基础的金额开始算 : 1,2,3....
            for (int i = 1; i <= amount; i++) {
                dp[i]=getMin(i, coins, dp);
            }

            return dp[amount];
        }

        //算金额amount用int[] coins凑出的最小硬币数
        public int getMin(int amount, int[] coins, int[] dp) {
            int min = MAX_VALUE;

            //求出所有coins数额的硬币数最小值(硬币数额是从小到大的，先从数额小的算起)
            //!!当查询的dp[i]为-1时，是不能参与计算最小值的!!
            for (int coin : coins) {
                if (amount-coin >= 0 && dp[amount-coin]>=0 && dp[amount-coin]<min) {
                    min = dp[amount-coin];
                }
            }
            return min == MAX_VALUE ? -1 : min+1;
        }
    }

    public static void main(String[] args) {
        //爆破法
        List<int[]> list = new Blasting().execute(11);
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        //尽量选取最大硬币法
        new ChooseMaxCoin().execute(11);
        //动态规划-递归法(自顶向下)
        System.out.println(new DynamicProgramming1().execute(11, new int[]{1, 2, 5}));
        //动态规划-迭代法(自底向上)
        System.out.println(new DynamicProgramming2().execute(7, new int[]{3, 5}));
    }


}
