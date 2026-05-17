package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**

PROBLEM: Longest Substring with At Most Two Distinct Characters (LeetCode #159)
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
Given a string s, return the length of the longest substring that contains at most 2 distinct characters.
Example: s = "eceba" → 3 ("ece")

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Use a HashMap to track character frequencies in the current window
2) Expand right: add s[j] to map (increment count)
3) If distinct count <= 2 → update longest = max(longest, j - i + 1)
4) If distinct count > 2 → shrink from left: decrement count, remove from map if 0, move i — until 2 remain
5) After shrinking, update longest again

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each character is visited at most twice (once added, once removed)
Space: O(1) — map holds at most 3 entries at any time (2 distinct + 1 incoming)

------------------------------------------------------------------------------------------------------------------------

*/
public class _3_LongestSubstringWithAtMost2Distinct {

    public int longestSubStr(String str, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int longest = 0;
        for(int j=0; j<str.length(); j++) {
            char ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() <= 2){
                longest = Math.max(longest, j - i + 1);
            }else if( map.size() > 2){
                while (map.size() > 2){
                    char left = str.charAt(i);
                    map.put(left, map.get(left) - 1);
                    if(map.get(left) == 0){
                        map.remove(left);
                    }
                    i++;
                }
                longest = Math.max(longest, j - i + 1);
            }
        }
        return longest;
    }
}