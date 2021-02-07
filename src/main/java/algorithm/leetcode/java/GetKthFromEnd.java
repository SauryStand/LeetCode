package algorithm.leetcode.java;

public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int n) {

        //又是快慢指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
//        while (fast.next.next != null && slow.next != null) {
//
//        }

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

}
