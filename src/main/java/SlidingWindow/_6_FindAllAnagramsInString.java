package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

PROBLEM: Find All Anagrams in a String (LeetCode #438)
https://leetcode.com/problems/find-all-anagrams-in-a-string/
Given strings s and p, return a list of all start indices where an anagram of p begins in s.
Example: s = "cbaebabacd", p = "abc" → [0, 6]

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Build a frequency map from p; set requiredChar = p.length()
2) Use a fixed-size window of exactly p.length() sliding across s
3) Expand right: if s[j] in map and count > 0 → decrement requiredChar; always decrement map count
4) When window reaches size p.length(): if requiredChar == 0 → anagram found, record start index i
5) Slide: restore left char to map, if restored count turns > 0 increment requiredChar, advance i

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — n = s.length(); each character is processed exactly once
Space: O(1) — map holds at most 26 distinct characters

------------------------------------------------------------------------------------------------------------------------

*/
public class _6_FindAllAnagramsInString {

    public List<Integer> findAnagrams(String str, String p) {

        int n = str.length();
        int j = 0;
        int i = 0;
        int requiredChar = p.length();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(char ch : p.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(j < n){

            char ch = str.charAt(j);

            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    requiredChar--;
                }
                map.put(ch, map.get(ch) - 1);

            }
            if(j-i+1 == p.length()){

                if(requiredChar == 0) {
                    result.add(i);
                }
                char left = str.charAt(i);

                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);
                    if(map.get(left)>0){
                        requiredChar++;
                    }

                }
                i++;
            }
            j++;
        }
        return result;
    }
}
