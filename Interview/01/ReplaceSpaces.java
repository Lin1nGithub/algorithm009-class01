/**
 * 01，03
 */
public class ReplaceSpaces {

    public String replaceSpaces(String S, int length) {

        if (S.length() == 0 || length == 0)return S;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c != ' '){
                sb.append(c);
            }else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        ReplaceSpaces solution = new ReplaceSpaces();
        String str = solution.replaceSpaces("Mr John Smith    "
                , 13);
        System.out.println(str);
    }
}
