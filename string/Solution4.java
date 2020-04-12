package string;

/**
 * created by mercury on 2020-04-12
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution4 {

    //只考虑标准的ascII码，128足够了，如果有汉字，扩大为65536
    int[] hashtable=new int[128];
    StringBuffer str = new StringBuffer();

    //Insert one char from stringstream
    public void insert(char ch) {

        str.append(ch);

        hashtable[ch]++;
    }


    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {

        char[] array = str.toString().toCharArray();
        for (char c : array) {
            if (hashtable[c] == 1){
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        char[] array = "google".toCharArray();
        for (char str : array) {
            solution4.insert(str);
        }

        System.out.println(solution4.firstAppearingOnce());

    }

}
