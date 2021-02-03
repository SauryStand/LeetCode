package algorithm.leetcode.java;

/**
 * @ClassName LongestPalindrome
 * @Description Todo
 * @Date 01/02/2021 23:58
 * @Author voyager2511
 * @Email zhoujianfeng@codemao.cn
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int arrs[][] = new int[length][length];
        int maxlen = 0;
        int maxend = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == origin.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arrs[i][j] = 1;
                    } else {
                        arrs[i][j] = arrs[i-1][j-1] + 1;
                    }
                }
                if (arrs[i][j] > maxlen) {
                    maxend = i; // 位置结尾的字符
                }
            }
        }

        return s.substring(maxend - maxlen + 1, maxend + 1);

    }

}
