import java.util.Queue;

/**
 * 单调递增的数字
 * 738
 * @author linkuan
 * @version 1.0
 * @since 2020/12/26 15:15
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        char[] arr = (N + "").toCharArray();
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            if (arr[i] > arr[i + 1]) {
                arr[idx] -= 1;
                for(int j = idx + 1;j < arr.length;j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public boolean verifyPostorder(int[] postorder) {
        return traverse(postorder, postorder.length - 1);
    }

    private boolean traverse(int[] postorder, int index){
        if(index < 2){
            return true;
        }
        int root = postorder[index];
        int left = postorder[index - 2];
        int right = postorder[index - 1];
        return left < root && right > root && traverse(postorder, index - 2);
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits solution = new MonotoneIncreasingDigits();
        System.out.println(solution.verifyPostorder(new int[]{1,3,2,6,5}));
    }
}
