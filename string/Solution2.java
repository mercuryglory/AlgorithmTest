package string;

/**
 * created by mercury on 2020-04-08
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution2 {


    /**
     * 先看*再看匹配
     * 1.若当前字符存在下一个字符，看下一个字符是否是'*',是的话有2种情况
     * 一 当前匹配
     * 1.1 match(str,i + 1,pattern,j)//跳过str
     * 1.2 match(str,i,pattern,j + 2)//跳过pattern
     *  二：当前不匹配
     * match(str,i,pattern,j + 2)//跳过pattern
     *
     * 2 下一个不是*
     * 当前匹配  match(str,i + 1,pattern,j + 1)
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }


    public boolean match(char[] str, int i, char[] pattern, int j) {
        System.out.println("递归调用");
        //当pattern遍历完，str恰好遍历完才返回true
        if (j == pattern.length) {
            return i == str.length;
        }

        //以下情况保证数组不越界
        //下一个是'*'
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return match(str, i + 1, pattern, j)
                        || match(str, i, pattern, j + 2);       //*前面的字符可以出现0次
            } else {
                return match(str, i, pattern, j + 2);
            }
        }

        //下一个不是'*' 当前匹配
        if (i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }

        return false;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.match("aaa".toCharArray(), "ab*ac*a".toCharArray()));

    }
}
