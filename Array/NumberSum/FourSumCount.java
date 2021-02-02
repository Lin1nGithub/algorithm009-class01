package NumberSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 454
 * 四数相加
 * @author linkuan
 * @version 1.0
 * @since 2020/11/27 14:47
 */
public class FourSumCount {

    /*
   给定四个包含整数的数组列表 A , B , C , D
   所有的 A, B, C, D 具有相同的长度 N
   计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
   */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            for(int b : B) {
                map.merge(a + b, 1, (v1,v2) -> 1);
            }
        }
        int res=0;
        for(int c : C) {
            for(int d : D) {
                res += map.getOrDefault(-c - d, 0);
            }
        }
        return res;
    }
}
