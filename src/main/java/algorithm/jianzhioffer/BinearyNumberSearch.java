package algorithm.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二维数组中的查找
 * @author: voyager2511
 * @create: 2019-11-14 00:02
 **/
public class BinearyNumberSearch {

    public boolean findNumber(int target, int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // start from right top corner
        while (r <= cols && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }


}
