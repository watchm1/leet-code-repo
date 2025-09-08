package leetcode.examples;

import java.util.HashMap;
import java.util.Map;

public class Substring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(last.containsKey(c)) {
                left = Math.max(left, last.get(c) + 1);
            }
            best = Math.max(best, r - left + 1);
            last.put(c, r);
        }
        return best;
    }
}
