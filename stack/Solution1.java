package stack;

import java.util.Stack;

/**
 * created by mercury on 2020-04-09
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution1 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    //队列先进先出，push应该在尾部
    public void push(int node) {
        stack1.push(node);

    }


    //栈A用作入队列，栈B用作出队列，栈B为空时，栈A全部出栈到栈B，栈B再出栈
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return first;

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.test();
    }

    private void test() {

        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
    }

}
