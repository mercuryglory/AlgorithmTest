package array;

/**
 * created by mercury on 2020-06-12
 * 给定任意数组，找出任意两个下标i,j。满足i<j，且arr[i]<arr[j]
 *
 */
public class Solution10 {

    public static int[] findTwo(int[] arr) {
        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            count++;
            if (arr[i] < arr[i + 1]) {
                result[0] = arr[i];
                result[1] = arr[i + 1];
                break;
            } else if (i == arr.length - 1) {
                break;
            }
        }
        System.out.println(count);
        return result;

    }


    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 1, 2};
        int[] result = findTwo(arr);
        System.out.println(123);
    }



}
