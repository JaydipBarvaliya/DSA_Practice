package Greedy;


import java.util.Arrays;

/**
PROBLEM:

You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Return -1 if you can't reach the end of the array.

Examples :

Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
Output: 3
Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last.

Input: arr = [1, 4, 3, 2, 6, 7]
Output: 2
Explanation: First we jump from the 1st to 2nd element and then jump to the last element.

Input: arr = [0, 10, 20]
Output: -1
Explanation: We cannot go anywhere from the 1st element.
------------------------------------------------------------------------------------------------------------------------

 Approach - (Recursion + Memoization)
 1) From each position, try all jumps you can make
 2) For every jump, check how many steps it takes to reach the end
 3) Pick the path with minimum jumps
 4) Store result for each index so we don’t repeat work
 5) If stuck (value = 0) → cannot move
 6) If reached end → 0 jumps needed
 7) If no path works → return -1


 Edge Understanding:
 Bigger window already contains the smaller window. So by always choosing the farthest reach, you automatically cover everything inside it.
 Nothing gets skipped.

 That's exactly why greedy works here and why we don't need DP.
 In DP you'd say "let me explore every possible path and remember results."
 In greedy you say "the biggest window swallows all smaller windows — so just track the biggest one."
------------------------------------------------------------------------------------------------------------------------


BRUTE : Time  : O(n*n) = O(n)^2  →  O(n)
        Space : O(n) memoization + O(n) recursion = O(n)

 DP APPROACH     : Time : O(n)
                 : Space : O(1)

GREEDY APPROACH : Time : O(n)
                : Space : O(1)

*/


public class _13_MinimumJumpToReachEnd {

    static class DP_APPROACH {

        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);
            return dfs(nums, 0, dp);
        }

        public int dfs(int[] nums, int idx, int[] dp) {
            if (idx == nums.length - 1) return 0;
            if (idx >= nums.length) return Integer.MAX_VALUE;

            if (dp[idx] != -1) return dp[idx];

            int minJump = Integer.MAX_VALUE;
            for (int i = 1; i <= nums[idx]; i++) {
                int result = dfs(nums, idx + i, dp); // we could have also do the 1 + dfs() but that will result in Integer overflow because of 1 +.
                if (result != Integer.MAX_VALUE) {
                    minJump = Math.min(minJump, 1 + result); // to handle the integer overflow, we first calculate the answer and check if it not +infinite. If it is not then add +1 into it.
                }
            }
            dp[idx] = minJump;
            return minJump;
        }
    }


    static class GREEDY_APPROACH {

            public int jump(int[] nums) {
                int farthest = 0;
                int minJump = 0;
                int currEnd = 0;

                for (int i = 0; i < nums.length-1; i++) { // we are doing nums.length-1 because we don't want to calculate answer for last element in the array.

                    farthest = Math.max(farthest, i + nums[i]);

                    if (i == currEnd) {
                        currEnd = farthest;
                        minJump++;
                    }
                }
                return minJump;
            }
        }

}