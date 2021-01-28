package algorithm.leetcode.java;

/**
 * @ClassName ClimbStairs
 * @Description Todo
 * @Date 27/01/2021 17:18
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
