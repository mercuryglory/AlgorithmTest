package recurse;

/**
 * created by mercury on 2020-04-11
 *  斐波那契数列：从第三项开始，每一项都等于前两项之和
 *  f(1)=1 f(2)=1 f(3)=2 .. f(n)=f(n-1)+f(n-2)
 *  现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {

    //递归法，注意方法出口
    public static int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n >= 2) {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
        return 1;
    }

    /**
     * 迭代法，推荐
     * 用两个变量记录f(n-1) 和 f(n-2)
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fnum1 = 0;
        int fnum2 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = fnum1 + fnum2;
            fnum1 = fnum2;
            fnum2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(38));
    }
}
