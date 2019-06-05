#https://leetcode.com/problems/remove-nth-node-from-end-of-list/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

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