package linkedlist;

/**
 * created by mercury on 2020-04-11
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Solution2 extends BaseNode {

    //递归版本
    public static ListNode merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.value <= list2.value) {
            list1.next = merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = merge1(list1, list2.next);
            return list2;
        }
    }

    //迭代版本
    public static ListNode merge(ListNode list1, ListNode list2) {
        //新建一个头结点，用来存合并的链表
        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }

        //把未结束的链表连接到合并后的链表尾部
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(1);
        ListNode point1 = list1;
        ListNode point2 = list2;
        int i = 0;
        while (i++ < 5) {
            point1.next = new ListNode(i * 2);
            point1 = point1.next;

            point2.next = new ListNode(i * 2 + 1);
            point2 = point2.next;

        }

        printList(list1);
        printList(list2);
        printList(merge(list1, list2));

    }

}
