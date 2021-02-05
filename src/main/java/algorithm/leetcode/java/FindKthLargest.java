package algorithm.leetcode.java;


import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /*
     * 按从小到大排序时，如果一次排序确定的最终位置是我们要找的位置，直接返回其值；
     * 如果排序确定的最终位置小，则在其右边找
     * 如果排序确定的最终位置大，则在其左边找
     */
    public int quickSelect(int[] nums, int start, int end, int index) {
        int i = randomPartition(nums, start, end);
        if (i == index) {
            return nums[i];
        } else {
            return i < index ? quickSelect(nums, i + 1, end, index) : quickSelect(nums, start, i - 1, index);
        }


    }

    // 随机找出基准位置i，然后交换放到end下标位置处
    public int randomPartition(int[] nums, int start, int end) {
        int i = 0;
        try {
            i = Random.class.newInstance().nextInt(end - start - 1) + start;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        swap(nums, i, end);
        return partition(nums, start, end);

    }


    public int partition(int[] nums, int start, int end) {
        int x = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
