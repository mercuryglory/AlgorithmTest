package btree;

import java.util.Stack;

/**
 * created by mercury on 2020-05-02
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树
 */
public class Solution9 {

    /**
     * 二叉搜索树按照中序遍历的顺序打印出来正好就是排好序的顺序。
     * 所以，按照中序遍历顺序找到第k个结点就是结果。
     */

    public static TreeNode kThNode(TreeNode root, int k) {
        //非递归中序遍历
        if (root == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }


    public static int count = 0;


    public static TreeNode kThNode2(TreeNode root, int k) {
        //递归中序遍历
        if (root != null) {
            TreeNode node = kThNode2(root.left, k);
            if (node != null) {
                return node;
            }
            count++;
            if (count == k) {
                return root;
            }
            node = kThNode2(root.right, k);
            if (node != null) {
                return node;
            }

        }

        return null;


    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode result = kThNode(root, 5);
        System.out.println();
    }

}
