
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @description: 最长递增子序列
 * dp[i]=max(dp[i],dp[j]+1)其中j<i,并且array[i]>array[j]
 * @param:
 * @return:
 * @author: voyager2511
 * @date: 2018/9/18
 */

public class ZuichangSubSequence {

    public static List<Integer> init(int n){
        Random random=new Random();
        List<Integer> list = new ArrayList();
        for(int i = 0 ; i < n ; i ++){
            list.add(random.nextInt(100));
        }
        return list;

    }

    public static void main(String[] args){
        List<Integer> list = init(10);
        List<Integer> listLen = new ArrayList<>();
        for(int o : list){
            listLen.add(1);
        }
        int max = 1;
        for(int i = 1 ; i < list.size() ; i++){
            for(int j = 0 ; j < i ; j++){
                if(list.get(j) < list.get(i) && (listLen.get(j)+1) > listLen.get(i)) {
                    listLen.set(i,listLen.get(j)+1);
                }
                //得到当前最长递增序列的长度以及该子序列的最末元素的位置
                if(max < listLen.get(i)){
                    max = listLen.get(i);
                }
            }
        }
        System.out.println(max);
        System.out.println("第i个元素结尾时最长递增子序列："+ listLen.toString());

    }


}