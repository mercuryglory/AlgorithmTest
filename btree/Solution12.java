package btree;

/**
 * created by mercury on 2020-06-10
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */

public class Solution12 extends BaseTreeNode {



    /**
     * 平衡二叉树又被称为AVL树，具有以下性质：
     * 是一颗空树，或左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是平衡二叉树
     * <p>
     * 最直接的做法，遍历每个节点，借助一个获取树深度的递归函数，根据该节点的左右子树高度差判断是否平衡，
     * 然后递归的对左右子树做判断
     */
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced2(root.left) && isBalanced2(root.right);

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }


    /**
     * 上面的做法有个问题，判断上层节点时，会多次重复遍历下层节点。如果改为从下往上遍历，如果子树是平衡二叉树，
     * 则返回子树的高度，如果发现不是，则直接停止遍历，这样最多只对每个节点访问一次
     */
    public static boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);


    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(isBalanced(root));
        System.out.println(isBalanced(createBST()));
    }






}
