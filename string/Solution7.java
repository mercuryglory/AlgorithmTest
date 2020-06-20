package string;

/**
 * created by mercury on 2020-06-19
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它
 */
public class Solution7 {

    /**
     * 利用数学规律当然是可以得出结果，时间复杂度为O(1)，但是没有旋转的思想
     */
    public static String leftRotateString1(String str, int n) {
        if (str == null) {
            return null;
        }

        int len = str.length();
        if (len == 0) {
            return "";
        }
        return str.substring(n % len, len).concat(str.substring(0, n % len));

    }


    /**
     * 分段翻转，最后整体翻转
     */
    public static String leftRotateString(String str, int n) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return "";
        }

        int bit = n % len;
        char[] chars = str.toCharArray();
        reverse(chars, 0, bit - 1);
        reverse(chars, bit, len - 1);
        reverse(chars, 0, len - 1);

        return new String(chars);

    }

    /**
     * 左右加逼
     */
    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
    }


    public static void main(String[] args) {
        System.out.println(leftRotateString("abcXYZdef", 24));
    }
}
