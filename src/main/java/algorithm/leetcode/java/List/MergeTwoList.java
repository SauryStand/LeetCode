package algorithm.leetcode.java.List;


public class MergeTwoList {

    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            //谁大就插入到后面
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }

        }
        while (j >= 0) {
            A[k--] = B[j--];
        }


    }


}
