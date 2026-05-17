package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**

PROBLEM: Permutation in String (LeetCode #567)
https://leetcode.com/problems/permutation-in-string/
Given strings s1 and s2, return true if any permutation of s1 exists as a substring in s2.
Example: s1 = "ab", s2 = "eidbaooo" → true (contains "ba")

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Identical structure to Find All Anagrams — return true on first match instead of collecting indices
2) Build freq map of s1; set requiredChar = s1.length()
3) Fixed window of size s1.length() slides over s2
4) Expand right: decrement requiredChar when a needed char is matched
5) When window is full: if requiredChar == 0 → return true; else slide and restore left char to map

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — n = s2.length(); single pass through s2
Space: O(1) — map holds at most 26 distinct characters

------------------------------------------------------------------------------------------------------------------------

*/
public class _7_PermutationInString {

    public boolean checkInclusion(String p, String str) {

        Map<Character, Integer> map = new HashMap<>();
        int requiredChar = p.length();
        int n = str.length();
        int i = 0;
        int j = 0;

        for(char ch: p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(j<n){

            char ch = str.charAt(j);

            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    requiredChar--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            if(j-i+1 == p.length()){
                if(requiredChar == 0 ){
                    return true;
                }

                char left = str.charAt(i);

                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);
                    if(map.get(left) > 0){
                        requiredChar++;
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
