package btree;

/**
 * created by mercury on 2020-04-12
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同
 */
public class Solution3 {

    /**
     * 注意是某二叉搜索树，那么该数组的顺序符合要求即可，数组内进行比较，并不需要引入TreeNode计算
     * 后序遍历最后一个是root，如果去掉root后的序列为T，那么T可以分为两段，前一段（左子树）小于x,
     * 后一段（右子树）大于x，且这两段子树都是合法的后序序列
     * 1、确定root
     * 2、
     *
     */
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private static boolean verify(int[] arr, int start, int end) {
        //注意这里是下标而不是数组元素哦，==对应的是叶子节点，>对应的是空树，自己画个图体会下
        if (start >= end) {
            System.out.println("start: " + start + ",end: " + end);
            return true;
        }
        int i = start;
        //从前面开始找
        while (arr[i] < arr[end]) {
            //找到比根大的元素下标i
            i++;
        }
        //从前面开始找 i到end-1应该都要比根大才符合
        for (int j = i; j < end; j++) {
            if (arr[j] < arr[end]) {
                return false;
            }
        }

        //根的左右，后序 左右根。通过上面找i的过程已经能分出左子树和右子树
        return verify(arr, start, i - 1) && verify(arr, i, end - 1);
    }


    public static void main(String[] args) {
//        int[] array = {2, 4, 3, 6, 8, 7, 0};
        int[] array = {1, 3, 5, 7, 6, 0};
        System.out.println(verifySequenceOfBST(array));

    }
}
