package linkedlist;

/**
 * created by mercury on 2020-04-19
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class Solution4 extends BaseNode {

    /**
     * 注意前提条件 排序 因此重复一定是连续重复
     * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * 2. 设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索
     */
    public static ListNode deleteDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        ListNode last = node.next;
        while (last != null) {
            if (last.next != null && last.value == last.next.value) {
                //找到最后一个相同节点
                while (last.next != null && last.value == last.next.value) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;

            }
        }
        return node.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode point = head;
        point.next = new ListNode(2);
        point = point.next;
        point.next = new ListNode(3);
        point = point.next;
        point.next = new ListNode(3);
        point = point.next;
        point.next = new ListNode(4);
        point = point.next;
        point.next = new ListNode(4);
        point = point.next;
        point.next = new ListNode(5);
        printList(head);

        printList(deleteDuplicate(head));
    }

}
