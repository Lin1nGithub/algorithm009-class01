import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 381
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 * @author linkuan
 * @version 1.0
 * @since 2020/10/31 16:13
 */
public class RandomizedCollection {

    ArrayList<Integer> list; // 值

    HashMap<Integer, Set<Integer>> map;// key:值,value:值在list中的索引

    Random random;

    int size;// 当前数据的大小

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.random = new Random();
        this.size = 0;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // 获取插入值的索引hash表
        Set<Integer> set = map.get(val);
        // 如果为空则创建 哈希表
        if (null == set) set = new HashSet<>();
        set.add(size);
        list.add(val);// 将值放进数组
        map.put(val, set);
        size++;
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int lastIndex = size - 1;// 得到最后2个值索引
        Set lastSet = map.get(list.get(lastIndex));
        Set<Integer> set = map.get(val);
        int currIndex = (int)set.iterator().next();//得到当前值索引
        //进行删除操作
        swap(list, currIndex, lastIndex);
        list.remove(size - 1);//将其在列表中删除
        set.remove(currIndex);//删除原值
        if(set.size() == 0)   map.remove(val);//在图中删除
        //修改最后一个值的索引
        lastSet.remove(size - 1);
        lastSet.add(currIndex);
        size--;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }

    private void swap(ArrayList<Integer> list, Integer currIndex, Integer lastIndex){
        int temp = list.get(currIndex);
        list.set(currIndex, list.get(lastIndex));
        list.set(lastIndex, temp);
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
