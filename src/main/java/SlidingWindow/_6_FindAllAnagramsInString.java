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

                map.put(ch, map.get(ch) - 1); // here we first adjust the frequency then we check that if it less than 0 means duplicate and
                                            // in that case we don't require that character anymore so that is why we are not reducing its frequency.

                if(map.get(ch) > 0){
                    requiredChar--;
                }
            }
            if(j-i+1 == p.length()){

                if(requiredChar == 0) {
                    result.add(i);
                }
                char left = str.charAt(i);
                if(map.containsKey(left)){

                    map.put(ch, map.get(left) + 1); // here also we do frequency adjustment first and then requireChar count later.

                    if(map.get(left) > 0){
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
