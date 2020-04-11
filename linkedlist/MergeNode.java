package linkedlist;

/**
 * created by mercury on 2020-04-06
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 算法的空间复杂度应为 O(1)，时间复杂度应为 O(ListNodes)，ListNodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class MergeNode extends BaseNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode point = head;
        int i = 1;
        while (i++ < 3) {
            point.next = new ListNode(i);
            point = point.next;
        }

//        printList(head);

//        printList(generateListListListNode(head));
        generateListListListNode(head);
    }

    public static ListNode generateListListListNode(ListNode head) {
        int number = 1;
        ListNode node = head;
        ListNode n1Head = new ListNode(-1);
        ListNode n2Head = new ListNode(-1);
        ListNode n1 = n1Head;
        ListNode n2 = n2Head;
        while (node != null) {
            if (number % 2 == 1) {
                n1.next = node;
                n1 = n1.next;
            } else {
                n2.next = node;
                n2 = n2.next;
            }
            number++;
            node = node.next;

            printList(n1);
        }

        n1.next = n2Head.next;
        n2.next = null;

        return n1Head.next;
    }
}
