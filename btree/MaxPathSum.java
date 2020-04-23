package btree;

/**
 * created by mercury on 2020-04-22
 *
 * 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束
 * 比如
 *      1
 *   /     \
 *  2       3
 *
 *  return 6
 */
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.right.left = new TreeNode(5);

        System.out.println(maxPathSum(root.left));

    }


    /**
     * 最大路径和有可能是哪些情况
     * 1、左子树的路径加上当前节点
     * 2、右子树的路径加上当前节点
     * 3、左右子树的路径加上当前节点
     * 4、只有自己的路径
     * <p>
     * 如果当前节点上面还有节点，那它的父节点是不能累加第三种情况的。所以要计算两个最大值
     * 一个是当前节点下的最大路径和
     * 一个是如果要连接父节点时的最大路径和
     * 用前者更新全局最大量，用后者返回递归值
     */


    public static int maxValue;

    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxSum(root);

        return maxValue;
    }


    public static int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);

        return Math.max(left, right) + node.val;

    }


    //如果必须是一条连续路径，题目会简单一些，不用计算全局路径数
    public static int maxPathAnother(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathAnother(node.left));
        int right = Math.max(0, maxPathAnother(node.right));
        return Math.max(left, right) + node.val;

    }
}
