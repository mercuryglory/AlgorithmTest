package linkedlist;

/**
 * created by mercury on 2020-04-11
 * 输入一个链表，输出该链表中倒数第k个结点
 */

public class Solution1 extends BaseNode {

    /**
     * 两个指针都指向头结点，p先跑，跑过K个节点后，q再跑。等到p跑到最后，q就到了倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }

        return i < k ? null : q;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        int i = 0;
        while (i++ < 10) {
            point.next = new ListNode(i);
            point = point.next;
        }

        printList(head);
        printList(findKthToTail(head, 6));
    }


}
