package recurse;

/**
 * created by mercury on 2020-05-17
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumSolution {

    /**
     * 不用if判断，递归+短路
     * 输入0的时候输出0来结束递归
     */
    public static int sumSolution(int n){
        int sum = n;
        boolean flag = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(sumSolution(5));
    }


}
