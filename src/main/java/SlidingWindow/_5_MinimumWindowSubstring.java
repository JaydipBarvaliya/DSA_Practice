package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**

PROBLEM: Minimum Window Substring (LeetCode #76)
https://leetcode.com/problems/minimum-window-substring/
Given strings s and t, return the minimum window substring of s that contains all characters of t.
Return "" if no such window exists.
Example: s = "ADOBECODEBANC", t = "ABC" → "BANC"

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Build a frequency map from t; set requiredChars = t.length()
2) Expand right: if s[j] is in the map and its count > 0, decrement requiredChars
3) Always decrement map count for a matched char (can go negative — tracks surplus copies)
4) When requiredChars == 0 (all of t is covered), record the min window, then start shrinking
5) Restore left char to map; if restored count turns > 0, increment requiredChars (lost a needed char)

------------------------------------------------------------------------------------------------------------------------

Time : O(|s| + |t|) — s is traversed at most twice (expand + shrink), t is scanned once to build the map
Space: O(|t|) — frequency map built from t

------------------------------------------------------------------------------------------------------------------------

*/
public class _5_MinimumWindowSubstring {

    public String longestSubStr(String str, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int leftIndex = 0;
        int rightIndex = 0;
        int smallestWindow = Integer.MAX_VALUE;
        int requiredChars = t.length();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        int i=0;

        for(int j=0; j<str.length(); j++){

            char ch = str.charAt(j);

            if(map.containsKey(ch)){

                if(map.get(ch) > 0){
                    requiredChars--;
                }
                map.put(ch, map.get(ch)-1);

            }
            while(requiredChars == 0){
                if(j-i+1 < smallestWindow){
                    leftIndex = i;
                    rightIndex = j;
                    smallestWindow = j-i+1;
                }

                char left = str.charAt(i);
                if(map.containsKey(left)){
                    map.put(left, map.get(left)+1);
                    if(map.get(left) > 0){
                        requiredChars++;
                    }
                }
                i++;
            }
        }
        return smallestWindow == Integer.MAX_VALUE? ""  : str.substring(leftIndex, rightIndex+1);
    }

}