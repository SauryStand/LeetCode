class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #求解的存在性，dp
        # 单序列问题
        # if not s:
        #     return False
        # dp = [False] * (len(s) + 1)
        # dp[0] = True
        # for i in range(len(s) + 1):
        #     for j in range(i):
        #         if dp[j] and s[j:i] in wordDict:
        #             dp[i] = True # s[j:i] 是回文字符串
        # return dp[-1]
        n = len(s)
        dp = [False] * n
        for i in range(n):
            for w in wordDict:
                if w == s[i-len(w)+1:i+1] and (dp[i-len(w)] or i-len(w) == -1):
                    print(dp[i-len(w)], i) # d[i-len(w)]要为true才成立子串这个概念
                    dp[i] = True
        return dp[-1]