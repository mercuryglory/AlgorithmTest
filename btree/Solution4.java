package btree;

/**
 * created by mercury on 2020-05-01
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution4 {

    /**
     * 图例
     * https://uploadfiles.nowcoder.com/files/20171225/773262_1514198075109_20151104234034251
     */
    public static TreeLinkNode getNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        //如果有右子树，就以当前为根节点，找到右子树的最左叶子结点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        //没有右子树，就找第一个当前节点是其父节点左孩子的节点，父节点就是下一个结点
        while (node.next != null) {
            if (node.next.left == node) {
                return node.next;
            }
            node = node.next;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        node4.next = node2;
        node2.next = root;
        node5.next = node3;
        node6.next = node3;
        node3.next = root;

        TreeLinkNode result = getNext(node5);
        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("null");
        }

    }
}
