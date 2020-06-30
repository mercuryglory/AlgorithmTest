package linkedlist;

import java.util.ArrayList;

/**
 * created by mercury on 2020-06-30
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Solution7 extends BaseNode {

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            list.add(0, listNode.value);
            listNode = listNode.next;
        }

        return list;

    }

    //简洁的递归做法
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            list = printListFromTailToHead(listNode.next);
            list.add(listNode.value);
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        int i = 0;
        while (i++ < 5) {
            point.next = new ListNode(i);
            point = point.next;
        }

        System.out.println(printListFromTailToHead(head));
    }

}
