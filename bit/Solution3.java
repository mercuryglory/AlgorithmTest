package bit;

/**
 * created by mercury on 2020-05-18
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution3 {

    /**
     * 按位与是查看两个数哪些二进制位都是1，这些是进位位，结果需左移一位
     * 异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减
     * <p>
     * 二进制相加，eg.  5-101, 7-111
     * 1、各位相加，不算进位，相当于各位做异或操作  101^111=010
     * 2、计算进位值，相当于各位做与操作，再左移一位   (101&111)<<1 = 1010
     * 3、重复上述两步，010^1010=1000   (010&1010)<<1 = 100
     * 4、继续，1000^100=1100，进位值为0，跳出循环，得到结果
     */

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 7));
    }

}
