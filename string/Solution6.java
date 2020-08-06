package string;


import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * created by mercury on 2020-05-24
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution6 {


    /**
     * 这是一个全排列类型的题目，信息有两点：
     * 1、可能有字符重复，比如aab
     * 2、按字典序列
     *
     * 想到用TreeSet来存储
     */
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        Set<String> temp = new TreeSet<>();
        backtrack(chars, 0, temp);
        result.addAll(temp);
        return result;

    }

    /**
     * 基于回溯法思想
     * 最好从全局递归的思路去理解，把输入的字符串当作根节点就好
     * https://uploadfiles.nowcoder.com/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
     *
     */
    private static void backtrack(char[] chars, int begin, Set<String> temp) {
        if (chars == null || begin > chars.length - 1) {
            return;
        }
        //这里的递归，char数组是不变的，当下标到数组的最后一个位置时就添加到集合中
        if (begin == chars.length - 1) {
            //归并
            temp.add(String.valueOf(chars));
        } else {
            //递进
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);
                backtrack(chars, begin + 1, temp);
                //这里就是回溯法，如果将[a,b,c]看作根节点，那么要保证根节点不变
                swap(chars, begin, i);
            }
        }
    }



    private static void swap(char[] chars, int a, int b) {
        if (a == b) {
            return;
        }
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }


    public static void main(String[] args) {

        System.out.println(permutation("aab"));

    }
}
