package linkedlist;

/**
 * created by mercury on 2020-04-19
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
public class Solution3 extends BaseNode {

    /**
     * 设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，一定相遇于环中某点(结论1)
     * 接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，最终相遇于环入口(结论2)
     *
     */
    public static ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                return fast;
            }
        }

        return null;


    }

    //构造一个有环链表
    public static ListNode createLoop() {
        ListNode head = new ListNode(1);
        ListNode point = head;
        ListNode entry = new ListNode(-1);
        int i = 0;
        while (i++ < 5) {
            if (i == 3) {
                point.next = entry;
                point = point.next;
                continue;
            }
            point.next = new ListNode(i);
            point = point.next;
        }
        point.next = entry;
        return head;
    }

    private static ListNode nonCircleLoop() {
        ListNode head = new ListNode(0);
        ListNode point = head;
        int i = 0;
        while (i++ < 6) {
            point.next = new ListNode(i);
            point = point.next;
        }

        return head;
    }

    public static void main(String[] args) {
//        ListNode loop = createLoop();
        ListNode loop = nonCircleLoop();
        System.out.println(entryNodeOfLoop(loop).value);
    }
}
