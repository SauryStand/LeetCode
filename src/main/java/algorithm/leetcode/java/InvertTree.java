package algorithm.leetcode.java;

import java.util.Stack;
import org.slf4j.Logger;

/**
 * @ClassName InvertTree
 * @Description Todo
 * @Date 15/01/2021 17:59
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
  public TreeNode invertTreeByDFS(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.add(root);
      while (!stack.empty()) {
          TreeNode node = stack.pop();
          System.out.println(node.val);
          if (node.left != null) {
              stack.push(node.right);
          }
          if (node.right != null) {
              stack.push(node.left);
          }
      }

      return null;
  }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                node = node.left;
            }
        }

        return root;
    }

}
