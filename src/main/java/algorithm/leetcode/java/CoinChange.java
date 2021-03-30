package algorithm.leetcode.java;

import java.util.Arrays;


public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // given default value
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //并且不等于最大值
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.max(dp[i], dp[i - coin] + 1); //最少需要硬币总数
                }
            }
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];

    }

}
