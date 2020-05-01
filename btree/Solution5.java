package btree;

/**
 * created by mercury on 2020-05-01
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class Solution5 {

    /**
     * 1、只要root.left和root.right是否对称
     * 2、左右节点的值相等，且left.left和right.right对称，left.right和right.left对称
     */

    public static boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);

    }

    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        boolean result = left.val == right.val          //为镜像的条件，左右节点的值相等
                && isSymmetrical(left.left, right.right)    //对称的子树也是镜像
                && isSymmetrical(left.right, right.left);

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
//        root.right.right = new TreeNode(5);

        System.out.println(isSymmetrical(root));
    }

}
