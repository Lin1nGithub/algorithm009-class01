/**
 * 767
 * 重构字符串
 * @author linkuan
 * @version 1.0
 * @since 2020/11/30 13:51
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] counter = new int[26];
        for (char c : S.toCharArray()) {
            counter[c - 'a']++;
        }

        // 找到存在数量最大的字符
        int maxIndex = 0;
        for(int i=0; i< counter.length; i++){
            if(counter[i] > counter[maxIndex]){
                maxIndex = i;
            }
        }

        int length = S.length();

        //
        if (counter[maxIndex] > (length + 1 ) / 2){
            return "";
        }

        char[] res = new char[length];

        // 偶数上面放上最多的字符
        int idx = 0;
        while (counter[maxIndex] > 0){
            res[idx] = (char)(maxIndex + 'a');
            idx += 2;
            counter[maxIndex]--;
        }

        // 处理剩下的字符
        for (int i = 0; i < counter.length; i++){
            while (counter[i] > 0){
                // 偶数用完了 开始使用奇数
                if (idx >= length) idx = 1;
                res[idx] = (char)('a' + i);
                idx += 2;
                counter[i]--;
            }
        }

        return String.valueOf(res);
    }

    public int largestPerimeter(int[] A) {
        quickSort(A, 0, A.length - 1);
        for(int i = A.length - 1; i >= 2; --i){
            if(A[i - 2] + A[i - 1] > A[i]){
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    private void quickSort(int[] nums, int lo, int hi){
        if(lo > hi) return;
        int v = nums[lo];
        int left = lo, right = hi;
        while(left < right){
            while(left < right && nums[right] >= v){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= v){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = v;
        quickSort(nums, lo, left - 1);
        quickSort(nums, right + 1, hi);
    }

    public static void main(String[] args) {

        ReorganizeString reorganizeString = new ReorganizeString();
        int i = reorganizeString.largestPerimeter(new int[]{3,4,15,2,9,4});
        System.out.println(i);
    }
}
