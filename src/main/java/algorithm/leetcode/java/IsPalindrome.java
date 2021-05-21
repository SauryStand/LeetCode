package algorithm.leetcode.java;


import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class IsPalindrome {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public boolean isPalindrome(ListNode head) {
        //双指针技巧
        //或者用栈
        List<Integer> vals = new ArrayList<Integer>();
        ListNode currNode = head;
        while (currNode != null) {
            vals.add(currNode.val);
            currNode = currNode.next;
        }
        int curr = 0;
        int prev = vals.size();
        while (curr < prev) {
            if (!vals.get(curr).equals(vals.get(prev))){
                return false;
            }
            curr++;
            prev--;
        }
        return true;
    }



}
