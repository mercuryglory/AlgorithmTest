package btree;

/**
 * created by mercury on 2020-05-02
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示
 * 空节点（#），以 ! 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */

public class Solution8 extends BaseTreeNode {


    /**
     * 前序遍历，递归遍历二叉树节点，空节点用#代替，节点间使用逗号隔开
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }

        String result = root.val + "," +
                serialize(root.left) +
                serialize(root.right);
        return result;

    }


    /**
     * 设置序号index，将字符串根据，分割为数组，根据index的值来设置树节点的val,如果节点的值为#,
     * 则返回空的树节点。index的作用
     */
    public static int index = -1;

    public static TreeNode deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] arr = str.split(",");
        return deserialize(arr);
    }

    public static TreeNode deserialize(String[] array) {
        index++;
        if (index >= array.length) {
            return null;
        }
        TreeNode node = null;
        if (!array[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(array[index]));      //这里没有做对非法输入的校验
            node.left = deserialize(array);
            node.right = deserialize(array);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = generateTreeNode();
        System.out.println(serialize(root));

        TreeNode result = deserialize("1,2,3,#,#,4,#,#,5,6,#,#,7,#,#,");
        System.out.println();
    }


}
