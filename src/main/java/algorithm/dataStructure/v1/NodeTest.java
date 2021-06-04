package algorithm.dataStructure.v1;

/**
 * author : Dairongpeng
 * /
 * algorithm-note
 */
public class NodeTest {

    public class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    //翻转单向链表
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //翻转双向链表
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            //noticed
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    //判断无环链表（有环不行）
    public static boolean checkLinkedListEqual(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }




}
