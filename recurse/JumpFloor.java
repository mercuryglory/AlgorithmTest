package recurse;

/**
 * created by mercury on 2020-04-11
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    /**
     * 找规律,f(1)=1 f(2)=2 f(3)=3..  f(n)=f(n-1)+f(n-2)
     * 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，
     * 另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6，其他的不能从3跳到6什么的啦，
     * 所以最后就是f(6) = f(5) + f(4)
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        int number = 0;
        for (int i = 3; i <= target; i++) {
            number = first + second;
            first = second;
            second = number;
        }

        return number;

    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(6));
    }

}
