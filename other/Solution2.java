package other;

/**
 * created by mercury on 2020-06-21
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 *       a   b   c   e
 *       s   f   c   s
 *       a   d   e   e

 * ​矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Solution2 {

    /**
     * 0、根据给定数组，初始化一个标志位数组，初始化false表示未走过，true表示已走过，不能走第二次
     * 1、根据行数和列数，遍历数组，先找到一个与str第一个元素相匹配的矩阵元素，进入judge
     * 2、根据i和j先确定一维数组的位置，因为要将矩阵转为一维数组
     * 3、确定递归终止条件：索引越界、当前找到的矩阵值不等于数组对应位置的值、已经走过的，这三类情况直接返回false
     * 4、每次递归k(待判断的字符串索引）+1，如果已经到了最后一位，说明匹配成功
     * 5、标注位数组index处标记为true，表示已走过
     * 6、递归不断寻找周围四个格子是否符合条件，只要有一个格子符合，就继续找这个格子四周是否存在符合条件的格子，知道
     * K到达末尾或者不满足递归条件就终止
     * 7、继续向下走，说明本次不符合，还原标志位数组index处的标志位，进入下一轮判断
     */

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的 --- 回溯法
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[index] || matrix[index] != str[k]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;

        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)){
            return true;
        }

        //此路不通，还原，再试试其他的路径
        flag[index] = false;
        return false;


    }


    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = "bcced".toCharArray();
//        char[] str = "abcb".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));

    }

}
