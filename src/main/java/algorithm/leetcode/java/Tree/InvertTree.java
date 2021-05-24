package algorithm.leetcode.java.Tree;

import java.util.Stack;

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

    /**
     * 先序遍历用stack就可以了
     * @param head
     * @return
     */
    public Stack<TreeNode> PreTree(TreeNode head) {
        if (head == null) {
            return new Stack<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        return stack;
    }


    public Stack<TreeNode> InTree(TreeNode head) {
        if (head == null) {
            return new Stack<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
        return stack;
    }

    /**
     * lru缓存
     */

}
