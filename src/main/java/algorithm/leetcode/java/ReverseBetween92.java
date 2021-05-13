package algorithm.leetcode.java;

/**
 * @ClassName ReverseBetween
 * @Description Todo
 * @Date 11/05/2021 16:21
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class ReverseBetween92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        //walk to range
        for (int i = 1; i < left; i++) {
            pre = curr;
            curr = curr.next;
        }
        ListNode first = pre;
        ListNode last = curr;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        first.next = pre;
        last.next = curr;
        return dummy.next;

    }

}
