import java.util.ArrayList;
import java.util.List;

/**
 * 11
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 盛最多水的容器
 * @author linkuan
 * @version 1.0
 * @since 2020/11/23 14:11
 */
public class MaxArea {

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
     * @param height
     * @return
     *
     * 面积取决于短板。
     * ①因此即使长板往内移动时遇到更长的板，矩形的面积也不会改变；遇到更短的板时，面积会变小。
     * ②因此想要面积变大，只能让短板往内移动(因为移动方向固定了)，当然也有可能让面积变得更小，但只有这样才存在让面积变大的可能性
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right){
            res = height[left] < height[right] ?
                    Math.max(res, (right - left ) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea solution = new MaxArea();
        solution.maxArea(new int[]{4,3,2,1,4});
        solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] counter = new int[nums.length + 1];
        for(int num : nums){
            counter[num]++;
        }
        List<Integer> rs = new ArrayList<>();
        for (int i = 1; i < counter.length; i++){
            if (counter[i] == 0){
                rs.add(i);
            }
        }
        return rs;
    }

}
