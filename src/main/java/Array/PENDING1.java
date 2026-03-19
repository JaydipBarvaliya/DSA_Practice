package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class PENDING1 {

    public int lengthOfLongestSubstring(String str) {

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
}
