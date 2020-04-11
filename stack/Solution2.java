package stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * created by mercury on 2020-04-11
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */

public class Solution2 {

    /**
     *
     */

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }

        return result;

    }


    public static void main(String[] args) {
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};

        ArrayList<Integer> result = maxInWindows(array, 3);
        System.out.println(result);
    }

}
