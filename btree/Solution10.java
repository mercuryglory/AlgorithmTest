package btree;

import java.util.ArrayList;

/**
 * created by mercury on 2020-05-21
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution10 extends BaseTreeNode {

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();


    /**
     * 深度遍历
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            //叶子节点，路径结束，每段递归的出口
            return res;
        }
        path.add(root.val);
        target -= root.val;

        //已经到叶子节点，并且正好加到了target
        if (target == 0 && root.left == null && root.right == null) {
            //这里必须new一个，做了拷贝的操作，否则add的是引用，最后得到的全是空数组，因为path最后是空
            res.add(new ArrayList<>(path));
        }
        findPath(root.left, target);
        findPath(root.right, target);

        System.out.println(path.size());
        //递归每一层结束后，都必须去掉最后一个。因为不管是否符合，都要回退到父节点，去查找另外一条路径，最后的path肯定为空
        path.remove(path.size() - 1);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 5, 6, 9, 3, 8};
//        int[] arr = {10, 5, 12, 4, 7};
        TreeNode result = createBinaryTreeByArray(arr, 0);
        System.out.println(findPath(result, 15));
    }

}


