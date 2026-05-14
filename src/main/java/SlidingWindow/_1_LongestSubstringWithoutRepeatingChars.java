package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class _1_LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String str) {

        int i = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();

        for( int j=0; j<str.length(); j++){

            char ch = str.charAt(j); // A

            if(!set.contains(ch)){ // doesn't exist
                set.add(ch);
            }else{ // does exist
                while(set.contains(ch)){
                    set.remove(str.charAt(i));
                    i++;
                }
                set.add(ch);
            }
            longest = Math.max(longest, j-i+1);
        }
        return longest;
    }


}