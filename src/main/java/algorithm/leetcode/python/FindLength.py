class Solution:

    '''
    - 双层循环找出所有的 i, j 组合，时间复杂度 *O(m * n)*，其中 m 和 n 分别为 A 和 B 的 长度。
      - 如果 A[i] == B[j]，dp[i][j] = dp[i - 1][j - 1] + 1
      - 否则，dp[i][j] = 0
    - 循环过程记录最大值即可。
    '''
    def findLength(A, B):
        m, n = len(A), len(B)
        ans = 0
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                if A[i - 1] == B[j - 1]:
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Max(ans, dp[i][j])

        return ans