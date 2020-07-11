package btree;

import java.util.ArrayList;

/**
 * created by mercury on 2020-04-12
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution2 extends BaseTreeNode {

    /**
     * 用ArrayList模拟一个队列存储TreeNode
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
        TreeNode root = generateTreeNode();

        System.out.println(printFromTopToBottom(root));

    }

}
