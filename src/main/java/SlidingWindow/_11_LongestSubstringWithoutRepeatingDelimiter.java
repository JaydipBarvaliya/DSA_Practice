package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class _11_LongestSubstringWithoutRepeatingDelimiter {

    public int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int longest = 0;

        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            while (set.contains(ch)) {
                set.remove(str.charAt(i));
                i++;
            }
            set.add(ch);
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}
