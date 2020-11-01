import java.util.HashMap;
import java.util.Map;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/10/31 17:40
 */
public class SlidingWindow {

    /**
     * int left = 0, right = 0;
     *
     * while (right < s.size()) {
     *     // 增大窗口
     *     window.add(s[right]);
     *     right++;
     *
     *     while (window needs shrink) {
     *         // 缩小窗口
     *         window.remove(s[left]);
     *         left++;
     *     }
     * }
     * @param S
     * @param T
     */
    private void slidingWindow(String S, String T){
        Map<Character, Integer> need, window;
        // need T中字符出现次数
        // window 「窗口」中的相应字符的出现次数
    }
}
