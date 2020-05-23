/**
 * 加一
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author linkuan
 * @version 1.0
 * @since 2020/5/22 10:39
 */
public class PlusOne {

    public int[] plusOne(int digits[]){
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}


