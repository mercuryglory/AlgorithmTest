package other;

/**
 * created by mercury on 2020-06-08
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。  2<=n<=60
 */
public class CutRope {

    /**
     * 划分型动态规划
     * 考虑必然有一个点，把绳子分成两段，两段分别构成最小子问题
     * 两段的最大值的乘积，就是target所求的最大值
     *
     * 设划分点为i，f[i]表示长度为i的绳子的乘积最大值
     * f[i]=max{f[i],f[j]*f[i-j]}  0<j<=i/2
     *
     * j<=i/2是因为，1*3和3*1是一样的，没必要计算在内
     */
    public static int cutRope1(int n) {
        //n<=3，m>1必须要分段，n=3最大分段乘积为2
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];

        /**
         * n >=4的情况，比如4分成1、3，这里的3就不用再分了，不分就是3，分段最大才2。所以大于4的情况下3是可以不分的
         * 因此这里用数组存储字段的最大值，2和3直接存进去作为2和3长度的子段最大值
         */
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        //记录最大值
        int res = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }

        return dp[n];
    }


//    /**
//     *
//     * @return
//     */
//    public static int cutRope(int n) {
//
//    }


    public static void main(String[] args) {
        System.out.println(cutRope1(13));

    }


}
