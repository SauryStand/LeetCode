'''
https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
'''
class Solution:
    def lengthOfLIS(self, nums:List[int]): -> int:
        tail = [0] * len(nums)
        size = 0
        for x in nums:
            i, j = 0, size
            while i != j:
                m = int((i+j)/2)
                if tail[m] < x:
                    i = m + 1
                else:
                    j = m
            tail[i] = x
            size = max(i+1, size)
        return size

    #perferance
    def solution2(nums):
        if not nums: return 0
        dp = [0] * (len(nums) + 1)
        n = len(nums)
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)