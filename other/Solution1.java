package other;

import java.util.ArrayList;

/**
 * created by mercury on 2020-05-18
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *
 */
public class Solution1 {


    /**
     * 一个不错的思路 https://www.jianshu.com/p/36c697698bd7
     * 先计算打印的圈数，画个图就知道，循环圈数由最短边决定,并且是由两边向中间，折半
     * 每一圈的初始元素都是矩阵第i行的第i列的元素，对应二维数组中[i][i]
     *
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0) {
            return result;
        }

        if (row == 1) {
            for (int i = 0; i < col; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }

        //一圈是一次循环
        for (int i = 0; i < row - i; i++) {
            if (i < col - i) {
                //一圈的上边，行固定，找准边界
                for (int j = i; j < col - i; j++) {
                    result.add(matrix[i][j]);
                }
                //一圈的右边，列固定
                for (int j = i + 1; j < row - i; j++) {
                    result.add(matrix[j][col - 1 - i]);
                }

                int k = row - 1 - i;
                /**
                 * 考虑矩阵行数小于列数，比如{{1,2,3,4,5}}，行的最大索引row-1减去当前循环层数i不应该等于
                 * 当前循环层数，否则最后一轮从左上到右上之后，接下来会再重复这一轮从右下到左下的部分元素，
                 */
                if (k != i) {
                    //一圈的下边，行固定
                    for (int j = col - 1 - i - 1; j >= i; j--) {
                        result.add(matrix[k][j]);
                    }


                }

                //考虑矩阵列数小于行数，同上
                int m = col - 1 - i;
                if (m != i) {
                    /**
                     * 一圈的左边，列固定
                     * 从左下到左上，和上一行的j>=i不同，这里如果=最后会重复打印这一轮左上到右上的第一个元素
                     */
                    for (int j = row - 1 - i - 1; j > i; j--) {
                        result.add(matrix[j][i]);
                    }
                }

            }
        }
        return result;


    }


    /**
     * 还有一个不错的思路 https://www.jianshu.com/p/36c697698bd7
     */
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
//        int[][] matrix = {{1, 2, 3, 4, 5}};
        int[][] matrix = {{}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);

    }

}
