package other;

import java.util.ArrayList;

/**
 * created by mercury on 2020-05-25
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    /**
     * 很巧妙的动态规划问题
     * 一个丑数的质因子只有2，3，5，那么丑数=2^x * 3^y * 5^z
     * 也就是说，一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，从1开始乘以2，3，5，就得到2，3，5三个丑数
     * 再从这三个丑数出发乘以2，3，5得到4，6，10，6，9，15，10，15，25九个丑数，里面有重复并且是无序的
     *
     * 1、将前面的丑数记下来，后面的丑数就是前面的丑数*2、*3、*5
     * 2、已知前面k-1个丑数，如何确定第k个
     * 3、定义三个指针，i2指向的下次永远*2，i3指向的下次永远*3，i5指向的下次永远*5
     * 4、从arr[i2]*2，arr[i3]*3，arr[i5]*5中选取最小的一个数字作为第k个丑数
     * 5、如果第K个丑数=2*i2，也就是说前面0-i2个丑数*2不可能产生比第K个丑数更大的了，所以i2++
     * 6、i3和i5同理
     * 7、返回第n个丑数
     *
     * 可以自己画一个矩阵图，把数字代入感受下
     *  1*2    1*3     1*5
     *  2*2    2*3     2*5
     *  3*2    3*3     3*5
     *
     *  开始乘1后结果是2、3、5，2最小，下次排序可以考虑排除2，理解为指针后移，i2+1，也就是下移一行到2*2，
     *  那么下次就是4，3，5比较，3最小，对应就是i3+1,下移一行到2*3，
     *  下次比较就是4，6，5比较，4最小，以此类推
     */

    public static int getUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < n) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;

            //算出最小数
            int min = Math.min(m2, Math.min(m3, m5));
            System.out.println("m2:" + m2 + ",m3:" + m3 + ",m5:" + m5);
            list.add(min);

            if (m2 == min) {
                i2++;
            }
            if (m3 == min) {
                i3++;
            }
            if (m5 == min) {
                i5++;
            }

        }

        return list.get(list.size() - 1);


    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(10));
    }

}
