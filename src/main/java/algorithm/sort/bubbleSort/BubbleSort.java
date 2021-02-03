/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2018/09/20 20:26
 */
package algorithm.sort.bubbleSort;

public class BubbleSort {
    /**
     *
     * @param array
     */
    public static void BasicBubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]){
                    swap(array[i], array[i+1]);
                }
            }
        }
    }


    public static void PerfectBubble(int[] array) {

        int low, up, index, i;
        low = 0;
        up = array.length - 1;
        index = low;
        while(up > low){
            for(i = low; i < up ; i++){
                if(array[i] > array[i+1]){
                    swap(array[i],array[i+1]);
                    index = i;
                }
            }
            //记录最后一个交换的位置
            up = index;
            for(i = up; i > low ; i--){
                if(array[i]<array[i+1]){
                    swap(array[i],array[i+1]);
                    index = i;
                }
            }
            //记录最后一个交换的位置
            low = index;
        }


    }


    private static void swap(int left, int right){
        int temp;
        temp = left;
        left = right;
        right =temp;
    }

}
