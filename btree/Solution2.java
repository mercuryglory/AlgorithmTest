package btree;

import java.util.ArrayList;

/**
 * created by mercury on 2020-04-12
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution2 {

    /**
     * 用linkedlist模拟一个队列存储treenode
     * @param root
     * @return
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);

        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(printFromTopToBottom(null));

    }

}
