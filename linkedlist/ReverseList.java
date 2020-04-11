package linkedlist;

/**
 * created by mercury on 2020-04-05
 */
public class ReverseList extends BaseNode {

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
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
