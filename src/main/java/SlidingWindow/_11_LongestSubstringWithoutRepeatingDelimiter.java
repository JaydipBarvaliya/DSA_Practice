package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**

PROBLEM: Longest Substring Without Repeating Characters — Optimized Variant (LeetCode #3)
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.
(Cleaner approach: shrink happens before adding the new character, eliminating the if/else branch.)
Example: s = "pwwkew" → 3 ("wke")

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Use left pointer i and right pointer j for the sliding window
2) Use a HashSet to track characters in the current window
3) Before adding s[j]: while the set already contains s[j] → remove s[i] and advance i (shrink first)
4) Add s[j] to set; update longest = max(longest, j - i + 1)
5) No need for a separate contains-check branch — the while handles it unconditionally

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each character is added and removed from the set at most once
Space: O(min(n, charset)) — set holds only the unique characters in the current window

------------------------------------------------------------------------------------------------------------------------

*/
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
