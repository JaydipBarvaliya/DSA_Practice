package Array;

import java.util.HashMap;
import java.util.Map;


/**

PROBLEM: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Input: s = "abcabcbb"

Output: 3
Explanation: The answer is "abc", with the length of 3. Note:: that "bca" and "cab" are also correct answers.

------------------------------------------------------------------------------------------------------------------------

 Approach - (Sliding Window + HashMap)
 1) Expand window using j
 2) Store frequency of characters in map
 3) If duplicate found → shrink window from i until valid
 4) Update max length (j - i + 1)
 5) Continue till end

------------------------------------------------------------------------------------------------------------------------

 Time  : O(n) -- Each character enters window once, leaves once
 Space : O(n) -- Because of HashMap

 */
public class _12_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String str) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int i=0;
        int j=0;

        while(j<str.length()) {

            Character ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 1) {
                Character leftChar = str.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbbabcdefghijklmnapqrstuvwxyz"));
    }

}
