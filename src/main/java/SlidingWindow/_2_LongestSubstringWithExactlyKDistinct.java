package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class _2_LongestSubstringWithExactlyKDistinct {

//    Input:  s = "aabacbebebe", k = 3
//    Output: 7
//    Explanation: "cbebebe" has exactly 3 distinct characters c, b, e


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