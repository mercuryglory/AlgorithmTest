package linkedlist;

/**
 * created by mercury on 2020-04-05
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseListNode extends BaseNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        int i = 0;
        while (i++ < 10) {
            point.next = new ListNode(i);
            point = point.next;
        }

        printList(head);

        printList(reverseList(head));

    }


    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;

        /**
         * 当前节点是head,pre为当前节点的前一节点，next为当前节点的后一节点
         * 设置这两个节点的意义在于，让当前节点从pre->head->next1->next2变成pre <- head  next1->next2
         * 即pre让节点可以反转，但反转后如果不用next保存next1的话，链表就断开了
         * 1->2->3->4->5
         * 1<-2<-3 4->5
         */
        while (head != null) {
            /**
             * 1、先用next保存head下一个节点的信息，保证不会断裂
             * 2、保存完，让head从指向next变成指向pre
             * 3、让pre、head依次向后移动一个节点
             */
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
