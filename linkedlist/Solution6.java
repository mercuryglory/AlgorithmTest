package linkedlist;

import java.util.HashSet;

/**
 * created by mercury on 2020-06-20
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Solution6 {

    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        HashSet<ListNode> set = new HashSet<>();
        while (cur1 != null) {
            set.add(cur1);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            if (!set.add(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }

        return null;
    }


    /**
     * 齐头并进法
     */
    public static ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        if (head1 == null || head2 == null) {
            return null;
        }
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        if (length1 >= length2) {
            int len = length1 - length2;
            while (len > 0) {
                cur1 = cur1.next;
                len--;
            }
        } else {
            int len = length2 - length1;
            while (len > 0) {
                cur2 = cur2.next;
                len--;
            }
        }
        while (cur1 != cur2 && cur1 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }


    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;

    }


    public static void main(String[] args) {
        ListNode head1= new ListNode(0);
        ListNode head2= new ListNode(-1);
        ListNode point1 = head1;
        ListNode point2 = head2;
        int i = 0;
        while (i++ < 5) {
            if (i >= 3) {
                ListNode newNode = new ListNode(i * 4);
                point1.next = point2.next = newNode;
                point1 = point2 = point2.next;

            } else {
                point1.next = new ListNode(i * 2);
                point1 = point1.next;

                point2.next = new ListNode(i * 3);
                point2 = point2.next;
            }

        }

        ListNode res = findFirstCommonNode2(head1, head2);


    }

}
