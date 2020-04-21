package string;

/**
 * created by mercury on 2020-04-19
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */

public class Solution5 {


    /**
     * 主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
     * 这里其实可以用一个58长度的数组来存储每个字母出现的次数，因为A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
     * 而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，
     * 最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了
     */
    public static int firstNotRepeatChar(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }

        int[] table = new int[128];

        for (int i = 0; i < str.length(); i++) {
            table[str.charAt(i)]++;
        }

        for (int j = 0; j < str.length(); j++) {
            if (table[str.charAt(j)] == 1) {
                return j;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        String str = "abcbbcadeefgkgk";
        System.out.println(firstNotRepeatChar(str));
    }

}
