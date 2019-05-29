/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2018/09/25 17:29
 */
package algorithm.binary_tree;


import java.nio.ByteBuffer;

/**
 * @description: reference: https://blog.csdn.net/hacker00011000/article/details/48252131
 * @param:
 * @return:
 * @author: voyager2511
 * @date: 2018/9/25
 */
public class BinarySearch {

    /**
     * the most simplist
     *
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2; // avoid overflow when (end + start)
            if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;

    }

    /**
     * 优化一：插值查找算法
     */
    int BinSearch(int[] arr, int n, int key) {
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            //left ascending
            if (arr[mid] > arr[low]) {
                if (arr[low] > key) {
                    low = mid + 1;
                } else if (arr[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //right ascending
                if (arr[high] < key) {
                    high = mid - 1;
                } else if (arr[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 优化二：斐波那契查找算法 todo
     * 从前面的分析中可以看到，无论划分的关键字太大或者太小都不合适，所以又有人提出了斐波那契查找算法，其利用了黄金分割比原理来实现的。
     */
    public static int max_size = 20;//斐波那契数组的长度

    //构造一个斐波那契数组
    void Fibonacci(int[] f) {
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }

    int FibonacciSearch(ByteBuffer arr, int n, int key) {
        int low = 0;
        int high = n - 1;
        int mid = 0;
        //构造一个斐波那契数组F
        int f[] = new int[max_size];
        Fibonacci(f);
        //计算n位于斐波那契数列的位置
        int k = 0;
        while (n > f[k] - 1) {
            ++k;
        }
        int[] temp;
        temp = new int[f[k] - 1];
        //memcpy(temp, arr, n * sizeofInt());
        return 0;
    }


    public static void memcpy(Integer src, ByteBuffer buffer, Integer size) {
        if (size > 4) {
            size = 4;
        }
        for (int i = 0; i < size; i++) {
            byte temp = (byte) (((src >> (3 - i)) * 8) & 0xff);
            ;
            buffer.put(temp);
        }


    }
    public int sizeofInt(){
        int i = 1, j = 0;
        while (i != 0) {
            i = (i << 1);
            j++;
        }
        return j;
    }

}