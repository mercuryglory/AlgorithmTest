package btree;

/**
 * created by mercury on 2020-04-16
 */
public class BaseTreeNode {

    protected static TreeNode generateTreeNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    /**
     * 根据输入的数组，层次遍历构造二叉树
     * @param array
     * @param index
     * @return
     */
    protected static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode node = null;
        if (index < array.length) {
            int value = array[index];
            node = new TreeNode(value);
            node.left = createBinaryTreeByArray(array, 2 * index + 1);
            node.right = createBinaryTreeByArray(array, 2 * index + 2);
            return node;
        }
        return null;
    }

    /**
     * 构造一颗二叉搜索树
     */
    protected static TreeNode createBST() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode result = createBinaryTreeByArray(arr, 0);
        System.out.println();
    }
}
