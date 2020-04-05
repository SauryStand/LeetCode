# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# leetcode 102
# 二叉树层次遍历

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        stack = [root]
        result = []
        self.traversal(1, root, result)
        return result

    def traversal(self, level, root, result) -> List[List[int]]:
        if not root:
            return root
        # one list in each layer
        if level > len(result):
            result.append([])
        result[level - 1].append(root.val)
        self.traversal(level + 1, root.left, result)
        self.traversal(level + 1, root.right, result)