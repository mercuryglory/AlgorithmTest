package sort;

/**
 * created by mercury on 2020-04-04
 */
public class SortTest {

    private static final int COUNT = 100000;

    public static void main(String[] args) {
        int[] arr = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            int random = (int) (Math.random() * COUNT);
            arr[i] = random;
        }

//        quickSort(arr);
        heapSort(arr);
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
     * 整体主要由构建初始堆+交换堆顶元素和末尾元素并重建堆两部分组成
     *
     */
    public static void heapSort(int[] arr) {
        //1 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从右至左调整结构
            adjustMaxHeap(arr, i, arr.length);
        }

        //2 交换堆顶元素与末尾元素+调整堆结构，交换了之后调整时把当面的末尾（j)排除掉就可以了，因为j处已经是最大
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustMaxHeap(arr, 0, j);
        }


    }

    /**
     * 调整大顶堆
     */
    private static void adjustMaxHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        //从i的左子节点开始
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            //如果左子节点小于右子节点，K指向右子节点
            if (j < len - 1 && arr[j] < arr[j + 1]) {
                j++;
            }
            //如果子节点大于父节点，将子节点赋值给父节点
            if (arr[j] > temp) {
                //这一步是因为如果父节点被调整到下面了，下面可能还有比父节点大的值，继续调整
                arr[i] = arr[j];
                i = j;
            } else {
                //左右子节点都比父节点小，结束
                break;
            }
        }
        //父节点最后落位的值
        arr[i] = temp;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
