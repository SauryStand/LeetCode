package algorithm.leetcode.java.Map;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前k个高频词 692
 */
public class TopKFrequent {


    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        //优先队列
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (s1, s2) -> {
                    if (count.get(s1).equals(count.get(s2))) {
                        return s2.compareTo(s1);
                    } else {
                        return count.get(s1) - count.get(s2);
                    }
                }
        );

        for (String s : count.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>(k);
        while(minHeap.size()>0) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;

    }


}
