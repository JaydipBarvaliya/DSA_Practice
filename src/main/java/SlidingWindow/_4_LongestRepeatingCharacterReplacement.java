package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**

PROBLEM: Longest Repeating Character Replacement (LeetCode #424)
https://leetcode.com/problems/longest-repeating-character-replacement/
Given string s and integer k, return the length of the longest substring that can be made of a
single letter by replacing at most k characters.
Example: s = "AABABBA", k = 1 → 4

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Track character frequencies in the window using a HashMap (or int[26])
2) Track maxFreq — the highest frequency of any single char currently in the window
3) Window is valid when (windowSize - maxFreq) <= k (characters needing replacement fit within k)
4) If invalid → shrink from left by ONE step only (no inner loop); maxFreq never decreases — key insight
5) Update longest = max(longest, windowSize) after every step

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — betterSolution is a true single pass; each element is visited once
Space: O(1) — frequency array of fixed size 26

------------------------------------------------------------------------------------------------------------------------

*/
public class _4_LongestRepeatingCharacterReplacement {

    public int characterReplacement(String str, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int longest = 0;
        int maxFre = 0;

        for(int j=0; j<str.length(); j++){

            char ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
            maxFre = Math.max(maxFre, map.get(ch));

            if(j-i+1 - maxFre <=k){
                longest = Math.max(longest, j-i+1);
            }else if(j-i+1 - maxFre  > k){

                while(j-i+1 - maxFre > k){

                    char left = str.charAt(i);
                    map.put(left, map.get(left) - 1);
                    if(map.get(left) == 0){
                        map.remove(left);
                    }
                    i++;
                }
                longest = Math.max(longest, j-i+1);
            }
        }
        return longest;
    }

    public int betterSolution(String str, int k) {

        int[] freqMap =  new int[26];
        int i = 0;
        int longest = 0;
        int maxFre = 0;
        for(int j=0; j<str.length(); j++){

            char ch = str.charAt(j);
            freqMap[ch - 'A']++;
            maxFre = Math.max(maxFre, freqMap[ch - 'A']);

             if(j-i+1 - maxFre  > k){
                char left = str.charAt(i);
                freqMap[left -'A']--;
                i++;
            }
            longest = Math.max(longest, j-i+1);
        }
        return longest;
    }
}