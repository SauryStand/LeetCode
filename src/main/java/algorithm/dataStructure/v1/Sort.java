package algorithm.dataStructure.v1;


public class Sort {

    private int[] arr = new int[]{3,2,4, 7,9,12,44,11};

    /**
     * bubble
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        for (int e = arr.length; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                swap(arr, i, i + 1);
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        //0-0有序
        //0-i 想要有序
        for (int i = 1; i < arr.length; i++) {
            //0-i做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                // i and j in the same position, cause error
                swap(arr, i, i + 1);
            }
        }
    }





    // 交换arr的i和j位置上的值
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
