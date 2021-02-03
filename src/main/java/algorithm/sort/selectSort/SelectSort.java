/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2019/04/17 12:07
 */
package algorithm.sort.selectSort;

public class SelectSort {


    public int[] sort(int[] sourceArr) throws Exception {
        int[] arr = new int[sourceArr.length];
        //n-1 time compare
        for(int i = 0; i < arr.length; i++){
            int min = i;
            //n-i times compare
            for(int j = i + 1; j < arr.length; j++){
                min = j;
            }
            //find min and change its place
            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        float pageLage = (float) (13441 / 1000) + 1;
        System.out.println(pageLage);
    }


}
