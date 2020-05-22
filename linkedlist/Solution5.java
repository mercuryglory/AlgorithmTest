package linkedlist;

/**
 * created by mercury on 2020-05-22
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution5 extends BaseNode {

    /**
     * 直接创建一个新节点指向原先的头结点，然后循环遍历赋值肯定是不行的，因为会返回原先的节点引用
     * 因此每一个原先的节点 都要复制
     *
     * 1、遍历链表，复制每个节点，比如复制A得到A1节点，插入到A节点后面
     * 2、重新遍历链表，复制老节点的随机指针给新节点，如A1.random=A.random.next，因为新节点的随机指针肯定是在老节点随机指针的后面
     * 3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public static RandomListNode clone(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode currentNode = head;
        //复制每个节点
        while (currentNode != null) {

            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;

        }

        //到这里head已经是插入好了的链表，重新赋值给curr，开始遍历
        currentNode = head;
        //复制老节点的随机指针给新节点
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }


        currentNode = head;
        //拆分链表，head又恢复成原先了。新建一个节点指向新链表的头节点，也就是合并链表的第二个
        RandomListNode cloneHead = head.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;

        }


        return cloneHead;
    }


    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);

        RandomListNode val2 = new RandomListNode(2);
        RandomListNode val3 = new RandomListNode(3);
        RandomListNode val5 = new RandomListNode(5);

        head.next = val2;
        head.next.next = val3;
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = val5;

        head.random = val3;
        head.next.random = val5;
        head.next.next.next.random = val2;

        RandomListNode clone = clone(head);
        System.out.println(123);

    }
}
