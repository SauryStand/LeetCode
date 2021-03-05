package algorithm.leetcode.java;

public class BalanceTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        calculateDepth(root);

        return res;
    }

    public int calculateDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftdep = calculateDepth(root.left);
        int rightdep = calculateDepth(root.right);
        if (Math.abs(leftdep - rightdep) > 1) {
            res = false;
        }
        return Math.max(leftdep, rightdep) + 1;


    }


}
