/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2018/09/20 20:26
 */
package algorithm.bubbleSort;

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

    public static void UpdateBubble(int[] array) {

    }

    public static void PerfectBubble(int[] array) {

    }


    private static void swap(int left, int right){
        int temp;
        temp = left;
        left = right;
        right =temp;
    }

}
