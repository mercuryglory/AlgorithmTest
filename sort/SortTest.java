package sort;

/**
 * created by mercury on 2020-04-04
 */
public class SortTest {

    private static final int COUNT = 10000000;

    public static void main(String[] args) {
        int[] arr = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            int random = (int) (Math.random() * COUNT);
            arr[i] = random;
        }

        quickSort(arr);
//        heapSort(arr);
        printArr(arr);

    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    private static int getMiddle(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= key) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    private static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }


    /**
     * 堆是具有以下性质的二叉树：每个节点的值都大于等于左右孩子，称为大顶堆
     * 每个节点的值都小于等于左右孩子，称为小顶堆
     *
     * 堆排序是利用堆这种数据结构设计的排序算法
     * 大顶堆用于升序排列，平均时间复杂度O(nlogn)
     *
     * 1、构造一个堆 H[0...n-1]
     * 2、把堆首（最大值）和堆尾互换
     * 3、堆的尺寸缩小1，并把新的数组顶端数据调整到相应位置
     * 4、重复步骤，直到堆的尺寸为1
     *
     */
    private static void heapSort(int[] arr) {
        int len = arr.length - 1;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustMaxHeap(arr, i, len);
        }

        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            adjustMaxHeap(arr, 0, i - 1);
        }
    }


    private static void adjustMaxHeap(int[] arr, int index, int len) {
        int left = index * 2 + 1;
        int right = left + 1;
        //记录最大值下标
        int maxIndex = left;
        if (left > len) {
            return;
        }
        if (right <= len && arr[left] < arr[right]) {
            maxIndex = right;
        }
        if (arr[maxIndex] > arr[index]) {
            swap(arr, index, maxIndex);
            adjustMaxHeap(arr, maxIndex, len);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
