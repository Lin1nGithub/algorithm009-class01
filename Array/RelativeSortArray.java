import java.util.*;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 1122
 * 数组的相对排序
 * @author linkuan
 * @version 1.0
 * @since 2020/11/14 21:58
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for(int i = 0 ; i < arr1.length; i++){
            counter[arr1[i]]++;
        }
        int left = 0;// arr2的下标
        int index = -1;// arr1的下标
        while(left < arr2.length){
            while (counter[arr2[left]]-- > 0){
                arr1[++index] = arr2[left];
            }
            left++;
        }
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0){
                arr1[++index] = i;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray solution = new RelativeSortArray();
        solution.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }
}
