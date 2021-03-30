package algorithm.leetcode.java;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 官方题解有两个代码
 * 一个是`LinkedHashMap`写法
 * 一个是`哈希表 + 双向链表`写法
 * 这里提供一种`哈希表+单向队列+延迟删除`的写法
 *
 * #### 代码相关数据结构:
 * 哈希表`map`：存缓存的`key-value`。
 * 单向队列`Q`：使用`LinkedList`实现的队列，具备先进先出的特点。
 * 哈希表`delay`：记录`key`需要被删除的次数。
 *
 * #### 重点：延迟删除
 * 举个例子：当`capacity`为4时，我们依次put进去4个key-value值：1-1，2-2，3-3，4-4。 此时队列中从队首到队尾排列为：1，2，3，4。现在我们对2执行get或者put方法，队列应该变为：1, 3, 4, 2。
 *
 * **但是**队列无法删除指定元素，只能弹出队首元素；（*温馨提示*：优先队列才有remove(key)方法，可以指定元素删除，但一般也会采用延迟删除，而不选择直接调用该方法。这是因为该方法底层使用的是for循环来寻找key值所在下标，从而进行删除和维护。这效率极低!）
 *
 * **所以**使用delay来记录元素要被删除的次数，例如这里的2需要被删除1次。那么队列为：1，2，3，4，2。当需要取得队首元素时，发现队首元素需要被删除，再对它进行删除即可；例如，我们再put进去5-5，此时1被抛弃；当再put进去6-6时，队首元素为2，但它需要被删除1次，将2从队列弹出，发现3才是最久未被使用的，于是3被抛弃
 *
 * 可能讲的很模糊，手动模拟代码跑一遍应该能更好的理解。
 *
 *
 */
public class LRUCache {

    private int capacity;
    HashMap<Integer, Integer> map;
    Queue<Integer> queue;
    HashMap<Integer, Integer> delay;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new LinkedList<>();
        delay = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.add(key);
            delay.put(key, delay.getOrDefault(key, 0) + 1);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.add(key);
            delay.put(key, delay.getOrDefault(key, 0) + 1);
        } else {
            if (map.size() < capacity) {
                map.put(key, value);
                queue.add(key);
            } else {
                delayDel();
                map.remove(queue.poll());
                map.put(key, value);
                queue.add(key);
            }
        }

    }

    void delayDel() {
        while (delay.containsKey(queue.peek())) {
            delay.put(queue.peek(), delay.get(queue.peek()) - 1);
            if (delay.get(queue.peek()) == 0) {
                delay.remove(queue.peek());
            }
            queue.poll();
        }
    }


}
