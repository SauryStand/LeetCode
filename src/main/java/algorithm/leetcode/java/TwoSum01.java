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

}
