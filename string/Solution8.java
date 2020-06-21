package string;

/**
 * created by mercury on 2020-06-21
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

public class Solution8 {

    /**
     * 先翻转整个句子，然后依次翻转每个单词
     * 根据空格确定单词的起始位置
     */
    public static String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        //翻转整个句子
        reverse(chars, 0, chars.length - 1);

        //记录空格的位置
        int blank = -1;

        for (int i = 0; i < chars.length; i++) {
            //碰到空格，记录位置
            if (chars[i] == ' ') {
                int nextBlank = i;
                //翻转上一个单词
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }

        //最后一个单词后面没有空格，单独反转一下
        reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);

    }


    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("student. a am I"));
//        System.out.println(reverseSentence(""));

    }

}
