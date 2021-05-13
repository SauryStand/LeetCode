

def lengthOfLongestSubstring(s):
    len = len(s)
    if len <= 1:
        return len
    max_len = 1
    temp_len = 1
    i, j = 0, 1
    for i in range(len):
        for j in range(len):
            if s[i] in s[i:j]:
                break
            temp_len += 1
            if max_len < temp_len:
                max_len = temp_len
            #j += 1
        temp_len += 1
        #i += 1
    return max_len


    def lengthOfLongestSubstring(self, s: str) -> int:
        res = tmp = i = 0
        for j in range(len(s)):
            i = j - 1
            while i >= 0 and s[i] != s[j]:
                i -= 1 # 线性查找 i
            if tmp < j - i:
                tmp += 1
            else:
                tmp = j - i
            # tmp = tmp + 1 if tmp < j - i else j - i # dp[j - 1] -> dp[j]
            res = max(res, tmp) # max(dp[j - 1], dp[j])
        return res


