package learning.algorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: 皮皮
 * @Date: 2024/6/28 9:38
 * @Description:
 */
public class Solution {

    public static int[] coins = {4, 6};
    static int[] dp = new int[6];

    public int coinChange( int amount) {
        int max = 999;

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(5);
        System.out.println(Arrays.toString(dp));
    }



}
