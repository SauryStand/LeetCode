package algorithm.leetcode.java;

public class TraverseTemplate {

    class ListNode {
        int val;
        ListNode next;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode[] children;
    }


    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            //iteration to get val

        }
    }

    void traverse2(ListNode head) {
        traverse2(head.next);
    }

    //二叉树遍历
    void tree(TreeNode root) {
        tree(root.left);
        tree(root.right);
    }

    //n叉树遍历
    void traverseN(TreeNode root) {
        for (TreeNode child : root.children) {
            traverseN(child);
        }
    }

}
