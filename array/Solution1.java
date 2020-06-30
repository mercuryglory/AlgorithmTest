package array;

/**
 * created by mercury on 2020-04-11
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {

    /**
     * 暴力遍历当然是可以的，但没有利用有序这个条件
     * @param target
     * @param array
     * @return
     */
    public static boolean find1(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * 从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时右移，小时上移
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;

        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (array[i][j] < target) {
                j++;
            } else if (array[i][j] > target) {
                i--;
            } else {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {9, 10, 11}};
        System.out.println(find(2,arr));

    }
}
