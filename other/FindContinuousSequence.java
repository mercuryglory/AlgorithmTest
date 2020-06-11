package other;

import java.util.ArrayList;

/**
 * created by mercury on 2020-06-11
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {

    /**
     * 首先把准，是连续序列
     * 一个很好的思路，双指针技术，相当于一个窗口，窗口的左右两边是两个指针，根据窗口内值的和来确定窗口的位置和宽度
     */
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int low = 1, high = 2;
        while (high > low) {
            //因为是连续的，差为1的等差序列，求和公式(a0+an)*n/2
            int cur = (low + high) * (high - low + 1) / 2;
            //相等的话，就将窗口范围内的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;

            } else if (cur < sum) {
                //当前窗口内值的和小于sum，右边窗口右移一位
                high++;
            } else {
                //当前窗口内的值之和大于sum，左边窗口右移动一位
                low++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(100));
    }
}
