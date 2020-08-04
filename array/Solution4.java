package array;

/**
 * created by mercury on 2020-04-19
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution4 {

    //遍历肯定是可以得到的，但没有利用排序数组的条件
    public static int getNumberOfK1(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k){
                count++;
            }
        }
        return count;
    }

    //既然是有序，又是查找，就能想到二分法，定位k的第一次出现位置和最后一次出现位置
    public static int getLower(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            System.out.println("getLower");
        }
        return start;

    }

    /**
     * 这个方法是为了找出k在数组中最右边的位置
     * 只要mid值<=k，start就右移，否则end左移，最后返回end刚好是第一个大于k的位置的左边
     */
    public static int getHigher(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            System.out.println("getHigher");
        }
        return end;
    }

    public static int getNumberOfK(int[] array, int k) {
        int lower = getLower(array, k);
        int higher = getHigher(array, k);
        return higher - lower + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 5, 5, 6, 9, 10, 12, 12, 15, 18};

        System.out.println(getNumberOfK(arr, 5));
    }


}
