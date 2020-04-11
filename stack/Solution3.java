package stack;

import java.util.Stack;

/**
 * created by mercury on 2020-04-11
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法
 *
 * 这个题很奇怪，下面的是可以通过测试用例的写法
 */
public class Solution3 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else if (node <= minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.push(3);
        solution3.pop();
        solution3.push(2);
        solution3.min();
    }
}
