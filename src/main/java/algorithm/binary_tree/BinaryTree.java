/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2019/04/01 14:17
 */
package algorithm.binary_tree;


/**
* @description: 普遍可用迭代和递归解决问题
 * 参考链接： https://www.jianshu.com/p/0190985635eb
* @param:
* @return:
* @author: voyager2511
* @date: 2019/4/1
*/
public class BinaryTree {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    //最大深度
    int getMaxDeath(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = getMaxDeath(node.left);
        int right = getMaxDeath(node.right);
        return Math.max(left, right) + 1;
    }

    //最大深度
    int getMinDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        return getMin(node);
    }

    int getMin(TreeNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }

    // get the count of node's number of the tree
    int numOfTreeNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    // get the leaves count of the tree
    int numOfChildTree(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return numOfChildTree(root.left) + numOfChildTree(root.right);
    }


    //前序遍历合后序遍历构造二叉树
    TreeNode buildTreeNode(int[] preOrder, int[] inOrder){
        if(preOrder.length != inOrder.length){
            return null;
        }



        return null;
    }



}
