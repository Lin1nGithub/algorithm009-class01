package LRU;

import NTree.Node;

import java.util.*;
import java.util.stream.Collectors;

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


    class Node{
        public int key;
        public int val;
        public Node prev;
        public Node next;

        //加了void就变成了普通方法，构造方法不带任何返回值
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {

        Node head;
        Node tail;
        int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public void addFirst(Node x){
            x.prev = head;
            x.next = head.next;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public Node removeFirst(){
            Node first = head.next;
            if(first == tail)
                return null;
            remove(first);
            return first;
        }

        public void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        //本题目不需要
        public Node removeLast(){
            Node last = tail.prev;
            if(last == head)
                return null;
            remove(last);
            return last;
        }

        //本题目不需要
        public int size(){
            return size;
        }
    }

    class LRUCacheCode {
        DoubleList cache;
        HashMap<Integer, Node> map;
        int cap;//cache的最大容量

        public LRUCacheCode(int capacity) {
            cap = capacity;
            cache = new DoubleList();//双向链表cache，末尾为最新使用的，链首为最久不用的
            map = new HashMap<>();
        }


        //get和put两个原则：
        //1.只要修改过key对应的值，就要重新放进map
        //2.只要查看过或修改过key对应的值,就要把key对应的node从原位置拿出来放到双向链表cache尾部代表刚刚用过
        public int get(int key) {
            if(!map.containsKey(key))   return -1;

            Node target = map.get(key);
            //2.只要查看过或修改过key对应的值就要把key对应的node从原位置拿出来放到双向链表cache尾部代表刚刚用过
            cache.remove(target);
            cache.addLast(target);

            return target.val;
        }

        public void put(int key, int value) {
            //如果关键字已经存在map里,修改键值对
            if(map.containsKey(key)){
                Node target = map.get(key);

                //1.只要修改过key对应的值，就要重新放进map
                target.val = value;
                map.put(key,target);
                cache.remove(target);
                cache.addLast(target);
            }else{//如果关键字不存在map,新增键值对

                //如果超过了双向链表cache的最大容量，要在map删除链首对应的key和cache删除链首节点
                if(cache.size == cap){
                    Node removeNode = cache.removeFirst();
                    map.remove(removeNode.key);
                }
                Node target = new Node(key,value);
                map.put(key,target);
                cache.addLast(target);
            }

        }


    }


    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = Arrays.stream(A).sum();

        int sumB = Arrays.stream(B).sum();

        int delta = (sumA - sumB) / 2;

        Set<Integer> rec = new HashSet<>();

        for (int num : A){

            rec.add(num);
        }

        for (int i = 0; i < B.length; i++){

            if (rec.contains(B[i] + delta)){

                return new int[]{B[i] + delta,  B[i]};
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        LRUCache solution = new LRUCache(1);
        int[] ints = solution.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
    }


}
