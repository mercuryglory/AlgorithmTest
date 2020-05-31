package array;

import java.util.*;

/**
 * created by mercury on 2020-05-31
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    /**
     * 题目描述的是正整数，不用考虑数组中为0的情况
     *
     * 所有数字可以任意拼接，考虑全排序，自定义比较器，排序规则如下：
     * ab>ba  则a>b
     * ab<ba  则a<b
     * ab=ba  则a=b
     * 还要考虑溢出情况，因为数组里面的每个元素不会溢出，但是拼接后用int接收可能会溢出，还是用string比较
     */
    public static String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] numbers = {3, 1, 2};
        System.out.println(printMinNumber(numbers));
    }

}
