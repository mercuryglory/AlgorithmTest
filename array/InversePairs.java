package array;

/**
 * created by mercury on 2020-06-21
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {

    //统计逆序对的个数
    public static int count;

    public static int inversePairs(int[] arr) {
        if (arr != null && arr.length != 0) {
            divide(arr, 0, arr.length - 1);
        }
        return count;
    }

    /**
     * 归并排序- 分
     */
    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        //计算中点的下标
        int mid = start + (end - start) / 2;

        //递归分
        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        //归并排序 - 治
        merge(arr, start, mid, end);

    }


    public static void merge(int[] arr, int start, int mid, int end) {
        //辅助数组
        int[] temp = new int[end - start + 1];

        //存一下变量
        int i = start, j = mid + 1, k = 0;
        //两两比较，若前面数大于后面的，就构成逆序对
        while (i <= mid && j <= end) {
            //若前面小于后面，直接存进去，并且移动前面的数所在数组的指针即可
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                //前面大于后面，那么就是符合条件的逆序对，而且从arr[i]到arr[mid]必定都大于arr[j]，因为此时分治的两边已经是有序的了
                count = (count + mid - i + 1) % 1000000007;
            }

        }

        //如果还有剩余的没比完，直接赋值就可
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        //覆盖原数组，使分治的这一部分有序
        for (k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(inversePairs(arr));

    }
}
