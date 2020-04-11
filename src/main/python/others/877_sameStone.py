
# https://leetcode.com/problems/stone-game/solution/

class Solution(object):
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool

        n = len(piles)
        dp = [[0] * n for i in range(n)]
        for i in range(n):
            dp[i][i] = piles[i]
        for i in range(n-2,-1,-1):
            for j in range(i+1,n):
                dp[i][j] = max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1])
        return dp[0][-1] > 0




        """
        N = len(piles)
        dp = [[0 for m in range(0, N)] for n in range(0, N)]
        for size in range(1, N+1, ++1):
            if size > N: break;
            for i in range(0, N+1\, ++1):
                if i + size > N: break;
                j = size + i - 1
                parity = (i + j + N) % 2
                if parity == 1:
                    dp[i + 1][j + 1] = max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i+1][j])
                else:
                    dp[i + 1][j + 1] = min(-piles[i] + dp[i + 2][j + 1] , -piles[j] + dp[i + 1][j])

        return dp[1][N] > 0







