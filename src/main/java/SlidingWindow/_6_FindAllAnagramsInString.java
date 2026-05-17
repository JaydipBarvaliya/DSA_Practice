package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
