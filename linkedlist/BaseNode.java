package linkedlist;

/**
 * created by mercury on 2020-04-11
 */
public class BaseNode {

    protected static void printList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        while (listNode != null) {
            System.out.print(listNode.value + " -> ");
            listNode = listNode.next;
        }
        System.out.println();

    }
}
