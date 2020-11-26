package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 * 146
 * @author linkuan
 * @version 1.0
 * @since 2020/11/4 16:30
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {

        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {

        map.put(key, value);
    }

//    private int capacity;
//
//    private Map<Integer, Integer> cache = new LinkedHashMap<>();
//
//    public LRUCache(int capacity) {
//
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        // 如果不存在则返回-1
//        if (!cache.containsKey(key)){
//
//            return -1;
//        }
//        // 将 key 变为最近使用
//        makeRecently(key);
//
//        return cache.get(key);
//    }
//
//    public void put(int key, int val) {
//        // 判断值是否存在
//        if (cache.containsKey(key)){
//            // 修改key的值
//            cache.put(key, val);
//            // 将 key 变为最近使用
//            makeRecently(key);
//        }else {
//            // 如果容量满 删除队首的数据
//            if (cache.size() >= this.capacity){
//                Integer first = cache.keySet().iterator().next();
//                cache.remove(first);
//            }
//            // 插入值
//            cache.put(key, val);
//        }
//    }
//
//    private int makeRecently(int key){
//        // 从队列中获取值
//        int val = cache.get(key);
//        // 从队列中把值删除
//        cache.remove(key);
//        // 把值放置到队尾
//        cache.put(key, val);
//        return val;
//    }


}