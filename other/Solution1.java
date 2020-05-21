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
     * 顺时针打印就是按圈数循环打印，将每一层的四个边角搞清楚就可以了
     * 圈其实是一个方形，只要有两行或者两列就得到一个圈
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        if (column == 0) {
            return result;
        }

        /**
         * 计算出层数
         * 由行和列较小值决定，只能由最短边决定，画个图就知道，比如2*4的矩阵，层数=1
         * 除以2是因为每次循环都会因顶部从左到右，和底部从右到左用掉2行，从上下向中间收缩，所以只取一半
         * 如果较小值是偶数，那么只要/2就可
         * 但如果较小值是奇数，那么结果是/2+1
         * 所以层数应该是 较小值/2+较小值%2
         */
        int layers = Math.min(row, column) / 2 + Math.min(row, column) % 2;
        for (int i = 0; i < layers; i++) {
            for (int j = i; j < column - i; j++) {  //从左至右
                result.add(matrix[i][j]);
            }
            for (int k = i + 1; k < row - i; k++) {     //从右上至右下
                result.add(matrix[k][column - 1 - i]);
            }

            /**
             * 考虑矩阵行数小于列数，比如{{1,2,3,4,5}}，行的最大索引row-1减去当前循环层数i不应该等于
             * 当前循环层数，否则最后一轮从左上到右上之后，接下来会再重复这一轮同样元素的从右下到左下，
             */
            for (int j = column - i - 2; (j >= i) && (row - 1 - i != i); j--) {        //从右下到左下
                result.add(matrix[row - 1 - i][j]);
            }

            /**
             * 从左下到左上，和上一行的j>=i不同，这里如果=最后会重复打印这一轮左上到右上的第一个元素，所以k>i
             * 考虑列数小于行数，比如{{1},{2},{3},{4},{5}}，列的最大索引column-1减去当前循环层数i不应该
             * 等于当前循环层数，否则最后一轮从右上到右下后，接下来会再重复这一轮同样元素从左下到左上
             */
            for (int k = row - i - 2; (k > i) && (column - 1 - i != i); k--) {
                result.add(matrix[k][i]);
            }

        }

        return result;

    }

    /**
     * 还有一个不错的思路 https://www.jianshu.com/p/36c697698bd7
     */
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        int[][] matrix = {{1, 2, 3, 4, 5}};
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list);

    }

}
