package array;

import java.util.Arrays;

/**
 * created by mercury on 2020-05-26
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class Solution7 {


    /**
     * 将数组先排好序的方法很容易想到，先快排，有序数组中符合条件的数一定是数组中间的那个数
     * 但是时间复杂度是O(logN)，如果用桶排序，则空间复杂度和负数无法满足要求
     */
    public static int sortSolution(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int count = 0;
        int len = array.length;
        Arrays.sort(array);
        int num = array[len / 2];
        for (int i = 0; i < len; i++) {
            if (array[i] == num) {
                count++;
            }
        }

        if (count <= len / 2) {
            return 0;
        }
        return num;

    }


    /**
     * 如果有符合条件的数字，它出现的次数比其它所有数字出现的次数和还要多
     * 遍历数组时保存两个值，一个是数组元素，一个是次数
     * 次数初始为1，遍历到下一个数字时，若它与之前保存的数字相同，则+1，否则-1，若次数为0，则保存数字，并将次数置为1
     * 遍历结束后，所保存的数字即为所求，然后再判断它是否符合条件
     *
     */
    public static int moreThanHalfNum(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        int len = array.length;

        //这一步只是为了求出可能符合条件的数字
        for (int i = 1; i < len; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    ++times;
                } else {
                    --times;
                }
            }

        }
        times = 0;

        for (int i = 0; i < len; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times > len / 2) {
            return result;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        System.out.println(moreThanHalfNum(array));
    }
}
