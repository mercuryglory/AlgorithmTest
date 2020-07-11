package stack;

import java.util.Stack;

/**
 * created by mercury on 2020-04-12
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution4 {

    /**
     * 大概是这么个意思..
     * 假设有一串数字要将他们压栈: 1 2 3 4 5
     * 如果这个栈很大很大，那么一次性全部压进去，再出栈：5 4 3 2 1
     * 但是，如果这个栈高度为4，会发生什么？ 1 2 3 4都顺利入栈，但是满了，那么要先出栈一个，才能入栈，就是先出4，
     * 然后压入5，随后再全部出栈：4 5 3 2 1
     *
     * 可能的情况（未包含所有情况）
     * 5 4 3 2 1//栈高度为5
     *
     * 4 5 3 2 1//栈高度为4
     *
     * 3 4 5 2 1//栈高度为3
     *
     * 2 3 4 5 1//栈高度为2
     *
     * 1 2 3 4 5//栈高度为1
     *
     * 借用一个辅助的栈，遍历压栈顺序，先将第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，
     * 很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，
     * 如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序
     */
    public static boolean isPopOrder(int [] pushA,int [] popA) {

        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        //标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                //出栈
                stack.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }

        System.out.println(stack);

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 2, 1};

        System.out.println(isPopOrder(pushA, popA));
    }
}
