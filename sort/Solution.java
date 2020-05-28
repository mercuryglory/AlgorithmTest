package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by mercury on 2020-05-28
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {

    public static ArrayList<Integer> getLeastNumbers(int[] input,int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(getLeastNumbers(arr, 4));

    }
}
