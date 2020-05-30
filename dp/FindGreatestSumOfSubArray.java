package dp;

/**
 * created by mercury on 2020-05-30
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {

    /**
     * 动态规划初级题目
     *
     * f(i): 以array[i]为末尾元素的子数组和的最大值，子数组元素的相对位置不变
     * f(i)=max(f(i-1)+array[i],array[i])
     * res: 所有子数组和的最大值
     * res=max(res,f(i))
     *
     * i=0,f(0)=6,res=6
     * i=1,f(1)=max(f(0)-3,-3)=3,res=max(6,3)=6
     * 以此类推
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        int res = array[0];     //记录当前所有子数组和的最大值
        int max = array[0];     //包含arr[i]的连续数组最大值

        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(arr));

    }
}
