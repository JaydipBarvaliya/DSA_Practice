package Array;


import java.util.Arrays;

/**
PROBLEM:

You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.

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

------------------------------------------------------------------------------------------------------------------------

Time :
Space :

*/

public class _13_MinimumJumpToReachEnd {

    public int jump(int[] nums) {

        int[] visited = new int[nums.length];

        Arrays.fill(visited, -1);

        int result = recur(nums,0, visited);

        return result == Integer.MAX_VALUE ? -1 : result;

    }

    int recur(int[] nums, int index, int[] visited) {

        if(index >= nums.length - 1) return 0;

        if(visited[index] != -1) return visited[index];

        if(nums[index] == 0) return Integer.MAX_VALUE;

        int totalAllowedJump = nums[index];
        int minJump = Integer.MAX_VALUE;

        for(int k = 1; k<=totalAllowedJump; k++){
            int result = recur(nums, index+k, visited);

            if(result != Integer.MAX_VALUE){
                minJump = Math.min(minJump, 1 +  result);
            }
        }

        visited[index] = minJump;
        return minJump;
    }
}

// TODO: we can also solve this problem with greedy approach, but have to understand it thoroughly.
