/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2018/09/27 15:55
 */
package algorithm.chain;

public class RevertLink {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }



    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            prev = head;
            head = next;
        }
        return prev;
    }

    /// recursive method
    public ListNode recursiveReverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = recursiveReverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

}
