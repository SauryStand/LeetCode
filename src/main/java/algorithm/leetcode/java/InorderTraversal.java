package algorithm.leetcode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归遍历太简单了
 * - 前序遍历：打印 - 左 - 右
 * - 中序遍历：左 - 打印 - 右
 * - 后序遍历：左 - 右 - 打印
 * <p>
 * 题目要求的是中序遍历，那就按照 左-打印-右这种顺序遍历树就可以了，递归函数实现
 * - 终止条件：当前节点为空时
 * - 函数内：递归的调用左节点，打印当前节点，再递归调用右节点
 * <p>
 * 时间复杂度：*O(n)*
 * 空间复杂度：*O(h)*，*h* 是树的高度
 */
public class InorderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }

    void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(stack.size()>0 || root!=null) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if(root!=null) {
                stack.add(root);
                root = root.left;
                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

}
