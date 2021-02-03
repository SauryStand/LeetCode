package algorithm.leetcode.java;

public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseByRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
