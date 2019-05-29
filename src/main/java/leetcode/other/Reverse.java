/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2019/05/29 14:25
 */
package leetcode.other;

public class Reverse {

    public int reverse(int x){
        long reverse = 0;
        while(x != 0){
            reverse = reverse * 10 + x % 10;
            x /= 10;
            if(reverse > Integer.MAX_VALUE){
                return 0;
            } else if (reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)reverse;
    }


}



