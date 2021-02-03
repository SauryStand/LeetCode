package algorithm.leetcode.java;


public class DeleteDuplicatedNode {

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

    /**
     * 如果链表为空或只有一个节点，则直接返回head即可。
     * 考虑到可能出现删除头节点的情况，所以创建哑结点yaNode，
     * 然后创建两个指针节点，yaHeadTemp、temp 一个指向哑结点一个指向头结点，
     * 两个指针同时往后移动，比较yaHeadTemp.next.val和temp.next.val的大小，
     * 如果不相等则两个指针都往后移动一位，如果相等，则用while循环找到相等节点的最后一个节点，
     * 然后用yaHeadTemp指向该节点的下一个节点即可，即删除了这些重复的节点。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode yaNode = new ListNode(0);
        yaNode.next = head;
        //哑节点指针
        ListNode yaNodeTemp = yaNode;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (yaNodeTemp.next.val == temp.next.val) {
                while (temp.next != null && yaNodeTemp.next.val == temp.next.val) {
                    // 找到相邻节点val相同的最后一个节点
                    temp = temp.next;
                }
                //移除相同值
                yaNodeTemp.next = temp.next;
                temp = temp.next;
            } else {
                temp = temp.next;
                yaNodeTemp = yaNodeTemp.next;
            }
        }
        return yaNode.next;

    }




}
