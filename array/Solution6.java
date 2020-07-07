package array;

/**
 * created by mercury on 2020-05-17
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution6 {

    /**
     * 首先统计奇数的个数
     * 然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始
     */
    public static void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int oddCount = 0, oddBegin = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[oddBegin++] = array[i];
            } else {
                newArray[oddCount++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }

    }

    //还有一种不需要创建辅助数组的解法，但是时间复杂度稍高

    public static void main(String[] args) {
        int[] array = {6, 8, 3, 1, 2, 4, 5, 10, 7};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
