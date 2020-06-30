package string;

/**
 * created by mercury on 2020-04-07
 * 实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class Solution1 {

    public static String replaceSpace1(StringBuffer str) {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    /**
     * 不创建新字符串的做法
     * 从前向后记录空格数目，从后向前替换空格
     *
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int count = 0;
        int length = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + count * 2;   //空格转换成%20之后，str的长度
        int newIndex = newLength - 1;
        str.setLength(newLength);   //防止数组越界异常

        for (; oldIndex >= 0; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }

        return str.toString();


    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));

    }
}
