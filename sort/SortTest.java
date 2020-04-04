package sort;

/**
 * created by mercury on 2020-04-04
 */
public class SortTest {

    private static final int COUNT = 10000;

    public static void main(String[] args) {
        int[] arr = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            int random = (int) (Math.random() * COUNT);
            arr[i] = random;
        }

        quickSort(arr);
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

}
