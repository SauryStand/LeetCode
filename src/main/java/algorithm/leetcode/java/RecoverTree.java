package algorithm.leetcode.java;

import java.util.ArrayList;
import java.util.List;


public class RecoverTree {


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


    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        //检查是否有错误交换的节点
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }


    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }


}
