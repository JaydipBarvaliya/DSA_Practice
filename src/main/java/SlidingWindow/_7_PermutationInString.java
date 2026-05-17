package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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
