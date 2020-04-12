package string;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.isNumeric("3.E+5".toCharArray()));
    }

    private int index = 0;


    //两次有符号，三次无符号运算
    public boolean isNumeric(char[] str) {
        if (str.length < 1) {
            return false;
        }

        boolean flag = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }


    //区分有符号和无符号
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);

    }


    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return start < index;
    }
}