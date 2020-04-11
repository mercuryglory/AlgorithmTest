package btree;

/**
 * created by mercury on 2020-04-11
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(9);

        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        System.out.println(hasSubTree(root1, root2));

    }

    public static boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //tree1和tree2都不为空时才比较，否则直接返回false
        if (root1 != null && root2 != null) {
            //找到了对应tree2的根节点，以这个根节点为起点判断是否包含tree2
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }

            //找不到，再去root的左儿子当作起点，去判断是否包含tree2
            if (!result) {
                result = hasSubTree(root1.left, root2);
            }

            //还找不到，再从右儿子作为起点
            if (!result) {
                result = hasSubTree(root1.right, root2);
            }
        }


        return result;
    }


    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //tree2已经遍历完了，都能对的上
        if (node2 == null) {
            return true;
        }

        //tree2还没遍历完，tree1遍历完了，返回false
        if (node1 == null) {
            return false;
        }

        //如果其中有一个点没对上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //根节点对的上，就分别取子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}
