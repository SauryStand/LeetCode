# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if head is None: return False
        slow = head
        fast = head.next
        while head and head.next:
            slow = head.next
            fast = head.next.next
            if slow == fast:
                return True
        return False