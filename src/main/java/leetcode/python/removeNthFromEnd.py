#https://leetcode.com/problems/remove-nth-node-from-end-of-list/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''
很简单的一道题，既然只允许遍历一次，且N一直有效，那么可以利用双指针解法（前指针、后指针），
让前指针先走N步，再让两个在指针同时后移，直到前指针到达尾部，此时，后指针的下一个节点就是要被删除的节点了。
'''
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """

        preNode = head
        currentNode = head
        for i in range(0, n):
            currentNode = currentNode.next

        if currentNode is None:
            return preNode.next

        while currentNode.next is not None:
            preNode = preNode.next
            currentNode = currentNode.next

        preNode.next = preNode.next.next
        return head