package SlidingWindow;

/**

PROBLEM: Minimum Size Subarray Sum (LeetCode #209)
https://leetcode.com/problems/minimum-size-subarray-sum/
Given a positive integer array nums and integer target, return the minimal length of a contiguous
subarray whose sum >= target. Return 0 if no such subarray exists.
Example: target = 7, nums = [2,3,1,2,4,3] → 2 (subarray [4,3])

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Expand right: add nums[j] to windowSum
2) When windowSum >= target → valid window found, enter shrink phase
3) Record current window length j - i + 1 as a candidate minimum
4) Shrink from left: subtract nums[i], move i right; keep shrinking while sum still >= target
5) Return 0 if target was never reached (len stayed at Integer.MAX_VALUE)

------------------------------------------------------------------------------------------------------------------------

Time : O(n) — each element is added once and removed at most once from the window
Space: O(1) — only a few pointers and a running sum variable

------------------------------------------------------------------------------------------------------------------------

*/
public class _9_MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int len = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int windowSum = 0;

        while(j < nums.length) {

            windowSum = windowSum + nums[j];

            if(windowSum >= target) { // we actually don't need this if condition, but we are keeping it here for template purpose.

                while(windowSum >= target) {
                    len = Math.min(len, j - i + 1);
                    windowSum = windowSum - nums[i];
                    i++;
                }
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

}
