package sort;

/**
 * created by mercury on 2020-04-11
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, -1, 1, 2};
//        int[] arr = {1, 1, 1, 0, 1};
        System.out.println(minNumberInRotateArray(arr));
    }

    /**
     * 旋转后的数组可以划分为两个有序子数组，前面子数组的大小都大于后面子数组的元素，最小的元素实际就是两个子数组的分界线
     *
     * 用二分法解答
     * mid=low+(high-low)/2  有三种情况
     * 1、array[mid] > array[high]
     * 类似[3,4,5,6,0,1,2] 最小数字一定在mid右边  low=mid+1
     * 2、array[mid] == array[high]
     * 类似[1,0,1,1,1]、[1,1,1,0,1] 最小数字不好判断在哪一边，一个个试  high=high-1
     * 3、array[mid] < array[high]
     * 类似[2,2,3,4,5,6,6]。最小数字一定是mid或左边     high=mid
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }

        return array[low];
    }
}
