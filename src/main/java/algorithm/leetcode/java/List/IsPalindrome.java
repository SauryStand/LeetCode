package algorithm.leetcode.java.List;


public class IsPalindrome {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 1，采用快慢两个指针去寻找链表的中间节点；
     * 2，根据链表的中间节点反转后一半的链表；
     * 3，迭代比较链表前一半的元素和后一半的元素，判断节点的值是否相等，得出是否为回文。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode minHead = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(minHead.next);

        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;
        boolean flag = true;
        while(flag && curr2 != null){
            if (curr1.val != curr2.val) {
                flag = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return flag;



    }

    private ListNode reverseLinked(ListNode head){
        ListNode prev = head;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }



    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }



}
