package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by mercury on 2020-05-28
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution2 {

    public static ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
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

    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k) {
            return list;
        }
        heapSort(input, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 2, 8};
        System.out.println(getLeastNumbers(arr, 2));

    }


    /**
     * 快排的时间复杂度为nlogn，堆排序则是nlogk
     * 对{@link SortTest#heapSort(int[])}做一个调整
     *
     * 整体思路是开始构建大顶堆，只需要构建前k个数的堆，得到前k个数的最大值在堆顶
     * 然后从第k个元素开始，与当前堆的堆顶做比较，小于就交换并调整，注意这里调整时仍然只需要调整前k个数，因为只要保证了
     * 前k个数的最大值在堆顶，那么k之后的只要有比其小的就一定会将该堆顶数调整到后面，最后堆里面的前k个数就是结果
     *
     * 注意这里的堆中不保证排序效果，因为只是部分构建堆，并不是堆顶与末尾元素交换
     *
     */
    private static void heapSort(int[] arr, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(arr, i, k);
        }

        //从第k个元素开始分别与最大堆的最大值作比较，如果比最大值小，则替换并调整堆
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, 0, i);
                adjustMaxHeap(arr, 0, k);
            }
        }
    }


    public static void adjustMaxHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j < len - 1 && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }



    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
