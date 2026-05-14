package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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