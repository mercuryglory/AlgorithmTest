package btree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * created by mercury on 2020-05-01
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution6 {

    public static ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> s1 = new Stack<>();     //存奇数层节点
        s1.add(root);
        Stack<TreeNode> s2 = new Stack<>();     //存偶数层节点
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> list2 = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    list2.add(node.val);
                    if (node.left != null) {
                        s2.add(node.left);
                    }
                    if (node.right != null) {
                        s2.add(node.right);
                    }

                }
                list.add(list2);
            } else {
                ArrayList<Integer> list2 = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    list2.add(node.val);
                    if (node.right != null) {
                        s1.add(node.right);
                    }
                    if (node.left != null) {
                        s1.add(node.left);
                    }

                }
                list.add(list2);
            }


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
