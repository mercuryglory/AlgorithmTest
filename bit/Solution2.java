package bit;

/**
 * created by mercury on 2020-05-12
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class Solution2 {

    /**
     * 1.判断指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     *
     * 这里面用了非递归快速幂的思想: https://zhuanlan.zhihu.com/p/95902286
     * https://www.cnblogs.com/techflow/p/12740595.html
     * 对照着两个链接理解下，用递归也是可以解的
     *
     */
    public static double power(double base, int exponent) {
        double result = 1;
        boolean flag = exponent > 0;
        if (exponent > 0) {
            if (base == 0) {
                return 0;
            }
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            exponent = -exponent;
        } else {
            return 1;
        }


        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;   //翻倍
            exponent >>= 1;     //右移一位
        }
        return  flag? result : 1 / result;
    }


    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
    





}
