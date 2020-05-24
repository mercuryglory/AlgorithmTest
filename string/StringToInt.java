package string;

/**
 * created by mercury on 2020-05-24
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */

public class StringToInt {

    /**
     * 要考虑整数溢出的情况，此处是整型，即-2147483648 ~ 2147483647
     * 全部转成负数去考虑，这样判断条件都用<
     */
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int result = 0;
        boolean negative = false;   //是否负数
        int i = 0;

        /**
         * limit 默认初始化为负的最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multi;
        int digit;

        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            i++;
            negative = true;
            limit = Integer.MIN_VALUE;  //负号情况下，判断溢出的值就变成最小负数了
        }

        multi = limit / 10;
        for (; i < str.length(); i++) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            digit = str.charAt(i) - '0';    //char转int
            if (digit < 0 || digit > 9) {
                //不是数字
                return 0;
            }

            /**
             * 这里判断的是10位上的溢出，比如limit=-2147483648,multi=-214748364,result="-2147483652",
             * 那么在将result转为-214748365时就应该比较了，要保证判断发生在溢出前
             */
            if (result < multi) {
                System.out.println("溢出了");
                return 0;
            }
            result *= 10;

            //这里判断的是到个位上的溢出，同样还是先判断再计算
            if (result < limit + digit) {
                return 0;
            }
            result -= digit;
        }

        //result一直是负数
        return negative ? result : -result;

    }



    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(strToInt("-2147483649"));

    }

}
