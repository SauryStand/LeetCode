# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        nums = self.dfs(root)
        if root is None: return 0
        return max(nums[0], nums[1])

    def dfs(self, x):
        if x is None: return [None] * 2
        left = self.dfs(x.left)
        right = self.dfs(x.right)
        res = [0] * 2
        # print(left[1], right[1])
        temp = 0
        temp_left_0 = 0
        temp_right_0 = 0
        temp_left_1 = 0
        temp_right_1 = 0
        if left[1] is not None:
            temp += left[1]
            temp_left_1 = left[1]
        if right[1] is not None:
            temp += right[1]
            temp_right_1 = right[1]
        res[0] = temp + x.val
        if left[0] is not None:
            temp_left_0 = left[0]
        if right[0] is not None:
            temp_right_0 = right[0]
        res[1] = max(temp_left_0, temp_left_1) + max(temp_right_0, temp_right_1)
        return res