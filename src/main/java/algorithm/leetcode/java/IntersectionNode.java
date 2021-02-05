package algorithm.leetcode.java;


public class IntersectionNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                }
                if (p2 == null) {
                    p2 = headA;
                }
            }
        }
        return p1;
    }

    /**
     * (时间复杂度O(m+n+max(m,n))),空间复杂度O(1))
     * 1.遍历l1,l2俩个链表计算出长度。
     * 2.链表长的指针向后移动到俩个链表长度差的位置。
     * 3.一一进行匹配
     * 总结：让长的链表从和短链表一样长度位置开始匹配
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;

        int lenA = 0;
        int lenB = 0;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        //将指针移动到可能出现匹配的位置
        p1 = headA;
        p2 = headB;
        if (lenA >= lenB) {
            for (int val = lenA - lenB; val > 0; val--) {
                p1 = p1.next;
            }
        } else {
            for (int val = lenB - lenA; val > 0; val--) {
                p1 = p1.next;
            }
        }
        int min = Math.min(lenA, lenB);
        while (min-- != 0) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }


}
