/**
 * 字符串转换整数 (atoi)
 * 8
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author linkuan
 * @version 1.0
 * @since 2020/11/19 18:28
 */
public class MyAtoi {

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        // 去掉前导0
        while (left < chars.length){
            if (chars[left] != ' '){
                break;
            }
            left++;
        }
        if (left == chars.length){
            return 0;
        }

        int sign = 1; // 正负号
        char c = chars[left];
        if (c == '-'){
            sign = -1;
            left++;
        }else if (c == '+'){
            left++;
        }

        int res = 0;
        while (left < chars.length){
            char d = chars[left];
            if (d - '0' > 9 || d - '0' < 0){
                break;
            }
            // 2147483647 8 > 7
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (d - '0') > Integer.MAX_VALUE % 10)){

                return Integer.MAX_VALUE;
            }
            // -2147483649 9 > 8
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (d - '0') > -(Integer.MIN_VALUE % 10))){

                return Integer.MIN_VALUE;
            }
            res = res * 10 +  sign * (d - '0');
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        MyAtoi solution = new MyAtoi();
        System.out.println(solution.myAtoi("-2147483649"));
    }
}
