package btree;

import java.util.Stack;

/**
 * created by mercury on 2020-05-18
 */
public class MirrorOfTree extends BaseTreeNode {

    //用迭代法
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

            System.out.println(123);

        }
    }

    //递归法
    public static void mirror1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);

        }
    }


    public static void main(String[] args) {
        TreeNode root = generateTreeNode();
        mirror1(root);
        System.out.println(123);
    }
}
