/**
 * @program leetcode
 * @description:
 * @author: voyager2511
 * @create: 2019/05/29 14:20
 */
package algorithm;

import java.util.*;

public class ListUtil {


    /**
     * list1与list2的差集
     */
    public static <T> List<T> subtract(final List<T> list1, final List<T> list2) {
        final ArrayList<T> result = new ArrayList<T>(list1);
        for (T t : list2) {
            result.remove(t);
        }
        return result;
    }


    /**
     * set的差集
     */
    public static <T> Set<T> subtract(final Set<T> list1, final Set<T> list2) {
        final HashSet<T> result = new HashSet<T>(list1);
        for (T t : list2) {
            result.remove(t);
        }
        return result;
    }

    /**
     * list1与list2的交集
     */
    public static <T> List<T> retainAll(Collection<T> collection, Collection<T> retain) {
        List<T> list = new ArrayList<T>(Math.min(collection.size(), retain.size()));
        for (T obj : collection) {
            if (retain.contains(obj)) {
                list.add(obj);
            }
        }
        return list;
    }

    /**
     * 对List进行分页
     * @param list 数据源
     * @param currentPage 当前页
     * @param size 每页显示的记录数
     * @param pageNum 总页数
     * @return
     */
    public static List getPageList(List list, int currentPage, int size, int pageNum) {

        // 从哪里开始截取
        int fromIndex = 0;
        // 截取几个
        int toIndex = 0;
        if(list == null || list.size() == 0){
            return null;
        }
        // 当前页小于或等于总页数时执行
        if (currentPage <= pageNum && currentPage != 0) {
            fromIndex = (currentPage - 1) * size;

            if (currentPage == pageNum) {
                toIndex = list.size();

            } else {
                toIndex = currentPage * size;
            }
        }
        return list.subList(fromIndex, toIndex);
    }


    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list2.add(1);
        list2.add(5);
        list2.add(8);
        System.out.println(subtract(list1, list2));
    }

}
