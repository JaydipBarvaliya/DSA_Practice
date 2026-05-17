package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class _10_MaximumErasureValue {

    public int maximumUniqueSubarray(int[] arr) {

        int i = 0;
        int j = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        while (j < arr.length) {

            windowSum = windowSum + arr[j];

            if (set.contains(arr[j])) { //duplicate

                while (arr[i] != arr[j]) {
                    windowSum = windowSum - arr[i];
                    set.remove(arr[i]);
                    i++;
                }
                windowSum = windowSum - arr[i];
                i++;
            } else {
                set.add(arr[j]);
            }
            j++;
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

}
