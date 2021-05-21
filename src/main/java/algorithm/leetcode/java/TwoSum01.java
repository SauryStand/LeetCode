package algorithm.leetcode.java;


import java.util.HashMap;

public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};
        if (nums.length == 2) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target-nums[i]) != null) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                if (result[0] != result[1]) {
                    break;
                }
            }
        }
        return result;

    }

    /**
     * 整数翻转，lc 07
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            //判断是否大于最大32位整数
            if (res > 214748364 || (res == 214748364 && temp > 7)) {
                return 0;
            }
            if (res < -214748364 || (res ==  -214748364 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;

        }
        return res;
    }


}
