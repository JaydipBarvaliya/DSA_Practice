package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**

PROBLEM: Maximum Erasure Value (LeetCode #1695)
https://leetcode.com/problems/maximum-erasure-value/
Given an array nums, find the maximum sum of a subarray where all elements are unique.
(Erase exactly one subarray; score = sum of erased elements.)
Example: nums = [4,2,4,5,6] → 17 (subarray [2,4,5,6])

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Use a HashSet to enforce uniqueness of elements in the current window
2) Expand right: add nums[j] to windowSum
3) If nums[j] is already in the set (duplicate) → shrink from left:
   subtract arr[i] from windowSum and remove arr[i] from set, advance i — until the duplicate is gone
4) Add nums[j] to set; update maxSum = max(maxSum, windowSum)
5) Return maxSum after the full traversal

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each element is added and removed from the set at most once
Space: O(n) — in the worst case all elements are unique and the set holds the entire array

------------------------------------------------------------------------------------------------------------------------

*/
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
