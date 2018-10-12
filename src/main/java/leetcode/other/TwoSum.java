package leetcode.other;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
     
     public static void main(String[] args){
         int[] array = {5,6,1,4,7,9,8};
         System.out.println(twoSum(array,10));
     }
     
     
    
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int temp;
        Integer index;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        //���hashMap
        for(int i = 0 ; i < nums.length ; i ++){
            map.put(nums[i],i);
        }
        //���ֲ���
        for(int i = 0 ; i < nums.length - 1 ; i ++){
            temp = target - nums[i];
            index = map.get(temp);
            if(index != null && index > i){
                result[0] = i;
                result[1] = index;
                break;
            
            }
        }
        
        return result;
        
    }
}