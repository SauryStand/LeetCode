package algorithm.leetcode.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class MergeSet56 {

    //learn its ways
    //draw a draft
    /**
     * 得出结论：**可以被合并的区间一定是有交集的区间**，前提是区间按照左端点排好序，这里的交集可以是一个点（例如例 2）。
     *
     * 至于为什么按照左端点升序排序，这里要靠一点直觉猜想，我没有办法说清楚是怎么想到的，有些问题的策略是按照右端点升序排序（也有可能是降序排序，具体问题具体分析）。
     *
     * 接着说，直觉上，只需要对所有的区间**按照左端点升序排序**，然后遍历。
     *
     * + 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
     * + 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        //按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);


        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];

            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);

            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        MergeSet56 solution = new MergeSet56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }


}
