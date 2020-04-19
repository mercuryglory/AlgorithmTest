package array;

/**
 * created by mercury on 2020-04-19
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Solution5 {

//    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//
//        if (array == null || array.length < 2) {
//            return;
//        }
//
//        int len = array.length, index = 0, sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum ^= array[i];
//        }
//        for (index = 0; index < 32; index++) {
//            if ((sum & (1 << index)) != 0) {
//                break;
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            if ((array[i] & (1 << index)) != 0) {
//                num2[0] ^= array[i];
//            } else {
//                num1[0] ^= array[i];
//            }
//        }
//    }


    /**
     * 位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     *
     * 来看两个数（我们假设是AB）出现一次的数组。首先还是先异或，剩下的数字肯定是A、B异或的结果，
     * 这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
     * 分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字
     */
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int length = array.length;
        int bitResults = 0;
        for (int i = 0; i < length; i++) {
            bitResults ^= array[i];
        }
        System.out.println(bitResults);
        int index = findFirst1(bitResults);

        for (int i = 0; i < length; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
                System.out.println(array[i] + "相同的一组");
            } else {
                num2[0] ^= array[i];
                System.out.println(array[i] + "不同的一组");
            }
        }
    }

    private static boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    //找到A、B第一个不同的位，就是找他俩异或的结果，从右到左第一个出现1的index
    private static int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }


    //用例，只有1和5出现了一次
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4, 2, 3, 5, 6, 7, 6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(arr, num1, num2);
        System.out.println(123);
    }

}
