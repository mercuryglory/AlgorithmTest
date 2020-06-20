package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by mercury on 2020-06-20
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution3 {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆,实现大顶堆需要翻转排序器
            return o2 - o1;
        }
    });

    private static int count = 0;

    /**
     * 思想是：大顶堆用来存较小的数，保证小顶堆中的元素都大于等于大顶堆中的元素
     * 设置一个计数count，开始count=0
     * count为偶数时，插入大顶堆，再移除大顶堆堆顶（最大值）添加到小顶堆中，count++
     * count为奇数时，插入小顶堆，再移除小顶堆堆顶（最小值）添加到大顶堆中，count++
     *
     * 最后判断count，如果为奇数，显然只要取小顶堆堆顶的值即可（小堆尺寸-大堆尺寸=1）
     * 如果为偶数，取小顶堆和大顶堆堆顶的平均值
     */
    public static void insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        count++;

    }

    public static Double getMedian() {
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        }
        return new Double(minHeap.peek());
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0};

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println(getMedian());
    }

}
