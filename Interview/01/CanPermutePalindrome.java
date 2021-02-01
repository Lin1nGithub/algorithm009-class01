import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 01，03
 */
public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {

        int[] counter = new int[128];

        Arrays.fill(counter, 0);

        for (char c : s.toCharArray()){

            counter[c]++;
        }

        int odd = 0;

        for (int count : counter) {

            if (odd > 1){

                return false;
            }

            if (count % 2 == 1){

                odd++;
            }

        }

        return true;
    }

//    public boolean canPermutePalindrome(String s) {
//        if (s.length() == 0)return false;
//        int odd = 0;
//        int[] marked = new int[128];
//        for(char c : s.toCharArray()){
//            ++marked[c];
//        }
//        for (int i : marked) {
//            if (odd > 1) {
//                return false;
//            }
//            if (i != 0 && i % 2 == 1) {
//                ++odd;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        CanPermutePalindrome solution = new CanPermutePalindrome();
        System.out.println(solution.canPermutePalindrome("as"));
    }
}
