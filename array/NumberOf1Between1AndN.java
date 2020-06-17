package array;

/**
 * created by mercury on 2020-05-31
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
 * 因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 * （从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {

    //暴力遍历,在千万级的整数表现很差
    public static int solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    count++;
                }

            }

        }

        return count;
    }

    /**
     * 归纳法
     *
     * 1、个位
     * 在个位上，1每隔10出现一次，如1、11、21，以10为阶梯，每一个完整的阶梯中有一个1，如22可以分为三个阶梯，
     * 完整阶梯0-9、10-19中都有一个1，而19之后的阶梯不完整，那么就对10取余，如果这个露出的部分小于1，则不可能
     * 出现1
     * 得出个位上1出现的次数： n/10*1+(n%10!=0?1:0)
     *
     * 2、十位
     * 十位数上出现1的情况是10-19，这组数每隔100出现一次，阶梯是100，比如317，有0-99、100-199、200-299三段
     * 完整阶梯，每个阶梯中都会出现10次1（10-19），考虑不完整阶梯（k=n%100）露出来的部分如果大于19，就是10个1，如果小于
     * 10则不可能出现十位数的1，如果在10-19之间的是k-10+1，比如317最后露出来的是17-10+1=8
     * 得出十位上1出现的次数：n/100*10+(if(k>19) 10 else if(k<10) 0 else k-10+1)   k=n%100
     *
     * 3、百位
     * 得出百位上1出现的次数：n/1000*100+(if(k>199) 100 else if(k<100) 0 else k-100+1) k=n%1000
     *
     * 再次回顾个位 n/10*1+(if(k>1) 1 else if(k<1) 0 else k-1+1)   k=n%10
     *
     * 归纳得出 count(i)=n/(i*10)*i+if((k>2*i+1) i else if(k<i) 0 else k-i+1)     k=n%(i*10)
     * i为计算1所在的位数，i=1表示计算个位数的1的次数，10表示计算十位数的1的次数
     */

    public static int numberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i = i * 10) {
            int divider = i * 10;
            int extra;
            int mod = n % divider;
            if (mod > i * 2 - 1) {
                extra = i;
            } else if (mod < i) {
                extra = 0;
            } else {
                extra = mod - i + 1;
            }
            count += (n / divider) * i + extra;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(13000000));
    }

}
