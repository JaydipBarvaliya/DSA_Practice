package Array;


/**

 PROBLEM: Given an integer array nums, find the subarray with the largest sum, and return its sum.



 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 Example 2:

 Input: nums = [1]
 Output: 1
 Explanation: The subarray [1] has the largest sum 1.
 Example 3:

 Input: nums = [5,4,-1,7,8]
 Output: 23
 Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) Brute Force :   I am finding all the subarrays, and then I am finding the maximum sum out of all those subarrays.
 2)
 3) Divide & Conquer:
 4)  - Divide the array with mid
 5)  - Traverse left of the mid ( including mid ) to find out the maximum continuous sum
 6)  - Traverse right of the mid to find out the maximum continuous sum
 7)  - sumOfBothContinuousSides  = leftSideContinuousSum + rightSideContinuousSum
 8)  - Check if left side has any subarray which has maximum sum by sending it to the DFS function -> leftSideOnly
 9)  - Check if right side has any subarray which has maximum sum by sending it to the DFS function -> rightSideOnly
 10) -  maximum of leftSideOnly, rightSideOnly and sumOfBothContinuousSides
 11) -
 12) Kadane's Algo
 13) - Start iterating each num from array
 14) - add them into the sum and compare it with the max
 15) - if sum becomes negative then make it 0 because we don't want to carry/consider any negative sum further which hurt/reduce the further calculation/sum
 16) - always update max before resetting sum to 0 otherwise it will Returns 0 for all-negative array
 17) - Check the following edge case = -3, -1, -4, -2

 ------------------------------------------------------------------------------------------------------------------------


 DivideConquer:
    Time : n log(n) --> log(n) because it is divide and conquer
                        * n Because we are scanning left side + right side (total n elements to scan)
    Space : log(n)  --> call stack depth equals the number of levels, which is log n.


 Kadane's:
    Time : O(n)
    Space : O(1)
 ------------------------------------------------------------------------------------------------------------------------

 */

public class _6_MaximumSumOfSubArray {



    public static int maxSubarrayDivideConquer(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private static int dfs(int[] arr, int i, int j) {

        if( i == j) return arr[i];

        int mid = (i + j) / 2;


        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for(int k=mid; k >=i; k--) { // remember that it should traverse on until I, no until 0th index because each subarray has its own i and j
            sum = sum + arr[k];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for(int k=mid+1; k<=j; k++) { // Remember that it should traverse until the j, not until end of the array because each subarray has its own i and j
            sum = sum + arr[k];
            rightSum = Math.max(rightSum, sum);
        }

        int leftSumOnly = dfs(arr, 0, mid);
        int rightSumOnly = dfs(arr, mid+1, j);
        int bothSides = leftSum + rightSum;

        return Math.max(bothSides, Math.max(leftSumOnly, rightSumOnly));
    }


    public static int kadanesAlgo(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            sum = sum + num;
            max = Math.max(sum, max);
            if(sum < 0) sum = 0;
        }

        return max;
    }
}