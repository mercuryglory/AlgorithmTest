package array;

/**
 * created by mercury on 2020-04-11
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];
 */
public class Solution3 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] result = multiply(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /**
     * B[i]的意义是A数组不包括i位置的所有乘积
     * 此题用占位法解较好，对B[i]做计算时所有A[i]都用1代替
     * 先计算下三角 再计算上三角
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int k = 1;
        for (int i = 0; i < len; i++) {
            res[i] = k;
            k *= A[i];
        }
        k = 1;
        for (int i = len - 1; i > 0; i--) {
            k *= A[i];
            res[i - 1] *= k;
        }

        return res;
    }
}
