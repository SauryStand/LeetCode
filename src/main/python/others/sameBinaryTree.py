# problem
'''
https://leetcode.com/problems/symmetric-tree/submissions/
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def isSameT(r1, r2):
            if not r1 and not r2:
                return True
            if r1 and r2 and r1.val == r2.val: #value!!
                left = isSameT(r1.left, r2.right)
                right = isSameT(r1.right, r2.left)
                return left and right
            else:
                return False

        if root is None:
            return True
        else:
            return isSameT(root.left, root.right)
