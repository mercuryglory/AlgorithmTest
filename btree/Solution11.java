package btree;

/**
 * created by mercury on 2020-05-23
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution11 extends BaseTreeNode {


    private static TreeNode pLast = null;

    /**
     * 使用一个成员变量记录当前链表的末尾节点
     * 递归的过程，相当于中序遍历，分解成小树，将他们分别转化成一小段一小段的双向链表
     * 再利用pLast记录总的链表末尾，然后将这些小段链表一个接一个加到末尾
     */
    public static TreeNode convertBstTo(TreeNode root) {
        if (root == null) {
            return null;
        }

        //如果左子树为空，那么根节点root为双向链表的头节点
        TreeNode head = convertBstTo(root.left);
        if (head == null) {
            head = root;
        }

        //连接当前节点root和当前链表的尾节点pLast
        root.left = pLast;
        if (pLast != null) {
            pLast.right = root;
        }
        pLast = root;

        convertBstTo(root.right);
        return head;

    }

    public static void main(String[] args) {
        TreeNode root = createBST();
        convertBstTo(root);

        System.out.println(123);
    }

}
