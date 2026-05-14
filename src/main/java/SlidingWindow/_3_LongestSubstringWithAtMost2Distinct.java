package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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