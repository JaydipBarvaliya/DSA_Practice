package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//    Input:  s = "aabacbebebe", k = 3
//    Output: 7
//    Explanation: "cbebebe" has exactly 3 distinct characters c, b, e

/**

PROBLEM: Longest Substring with Exactly K Distinct Characters (GFG)
https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
Given a string s and integer k, find the length of the longest substring with exactly k distinct characters.
Example: s = "aabacbebebe", k = 3 → 7 ("cbebebe")

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Use a HashMap to track character frequencies in the current window
2) Expand right: add s[j] to map (increment count)
3) If distinct count == k → update longest = max(longest, j - i + 1)
4) If distinct count > k → shrink from left: decrement count, remove from map if 0, move i — until exactly k
5) After shrinking back to k, update longest again
6) Return -1 if no valid substring of exactly k distinct characters was found

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each character is added and removed from the map at most once
Space: O(k) — map holds at most k+1 distinct characters at any point

------------------------------------------------------------------------------------------------------------------------

*/
public class _2_LongestSubstringWithExactlyKDistinct {

    public int longestKSubStr(String str, int k) {

        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longest = -1;
        for(int j=0; j<str.length(); j++){

            char ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() == k){
                longest = Math.max(longest, j - i + 1);
            } else if ( map.size() > k) {

                while(map.size() != k){
                    char left = str.charAt(i);
                    map.put(left, map.get(left) - 1 );
                    if(map.get(left) == 0){
                        map.remove(left);
                    }
                    i++;
                }
                longest = Math.max(longest, j - i + 1);
            }

        }
        return  longest;
    }




















//    public int longestKSubstr(String str, int k) {
//
//        int longest = -1;
//        int i = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(int j=0; j<str.length(); j++){
//            char ch = str.charAt(j);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//
//            if(map.size() == k){
//                longest = Math.max(longest, j-i+1);
//            }else if(map.size() > k ){
//
//                while(map.size() != k){
//                    char leftChar = str.charAt(i);
//                    map.put(leftChar, map.get(leftChar) - 1);
//                    if(map.get(leftChar) == 0){
//                        map.remove(leftChar);
//                    }
//                    i++;
//                }
//            }
//        }
//        return longest;
//    }
}