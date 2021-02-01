/**
 * 01，02
 */
public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {

        int[] counter = new int[26];

        for (int i = 0; i < s1.length(); i++){

            counter[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++){

            counter[s2.charAt(i) - 'a']--;

            if (counter[s2.charAt(i) - 'a'] < 0){

                return false;
            }
        }

        return true;
    }
}
