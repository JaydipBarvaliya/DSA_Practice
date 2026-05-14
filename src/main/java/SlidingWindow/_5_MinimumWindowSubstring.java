package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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