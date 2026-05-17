package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**

PROBLEM: Longest Substring Without Repeating Characters (LeetCode #3)
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.
Example: s = "abcabcbb" → 3 ("abc")

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Use left pointer i and right pointer j as the sliding window boundary
2) Use a HashSet to track which characters are in the current window
3) Expand right: try to add s[j]
4) If s[j] already in set → shrink from left: remove s[i] from set, move i right, repeat until gone
5) Add s[j] to set; update longest = max(longest, j - i + 1)

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each character is added and removed from the set at most once
Space: O(min(n, charset)) — set holds at most charset-size distinct characters (26 for lowercase alpha)

------------------------------------------------------------------------------------------------------------------------

*/
public class _1_LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String str) {

        int i = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();

        for( int j=0; j<str.length(); j++){

            char ch = str.charAt(j); // A

            if(!set.contains(ch)){ // doesn't exist
                set.add(ch);
            }else{ // does exist
                while(set.contains(ch)){
                    set.remove(str.charAt(i));
                    i++;
                }
                set.add(ch);
            }
            longest = Math.max(longest, j-i+1);
        }
        return longest;
    }


}