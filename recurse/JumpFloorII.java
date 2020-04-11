package recurse;

/**
 * created by mercury on 2020-04-11
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    /**
     * 变态跳台阶，可以看做是一种简单的贪心算法
     * 每个台阶都有跳与不跳两种情况（除最后一个是必跳），因此共有2^(n-1)。当然也可以求解
     */
    public static int jumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 2; i <= target; i++) {
            second = 2 * first;
            first = second;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(5));
    }
}
