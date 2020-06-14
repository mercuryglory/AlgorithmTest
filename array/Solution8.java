package array;

import java.util.ArrayList;

/**
 * created by mercury on 2020-06-11
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution8 {

    /**
     * 因为数组是递增的，很容易可以证明遇到的第一组就是乘积最小的
     * 然后左右加逼
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 5, 6, 7};
        System.out.println(findNumbersWithSum(array, 8));
    }


}
