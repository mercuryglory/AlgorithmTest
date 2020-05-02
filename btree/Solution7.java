package btree;

import java.util.ArrayList;

/**
 * created by mercury on 2020-05-02
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution7 extends BaseTreeNode {


    /**
     * 和{@link Solution2}对比，发现就是在从上往下打印的基础上加了个层次问题，那么在while循环里再加个for循环，记录
     * 每次开始要进入队列前要遍历该层的次数
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> numbers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove(0);
                numbers.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(numbers);
        }

        return list;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        System.out.println(print(root));
    }


}
