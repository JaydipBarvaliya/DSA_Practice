package Array;

public class _6_MaximumSumOfSubArray {


//TODO: resolve this problem, as u were not able to do it last time when prsoon asked.


// Kadane's Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
// don't drop before calculating the max to consider the edge case = -1, -2, -3
        public static int maxSubArray(int[] arr) {

            int max = Integer.MIN_VALUE;
            int sum  = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
                max = Math.max(max, sum);
                if(sum < 0 ) sum = 0;
            }

            return max;
        }
//{-1,-2,-3};
// sum = -1;
// max = -1;



//        public static int maxSubArray(int[] nums) {
//            return dfs(nums, 0, nums.length - 1);
//        }
//
//        private static int dfs(int[] nums, int i, int j) {
//
//            if (i == j) {
//                return nums[i];
//            }
//
//            int mid = (i + j) / 2;
//            int leftSum = Integer.MIN_VALUE;;
//            int sum = 0;
//            for (int k = mid; k >= i; k--) {
//                sum = sum + nums[k];
//                leftSum = Math.max(leftSum, sum);
//            }
//
//            int rightSum = Integer.MIN_VALUE;;
//            sum = 0;
//
//            for (int k = mid + 1; k <= j; k++) {
//                sum = sum + nums[k];
//                rightSum = Math.max(rightSum, sum);
//            }
//            int bothSides = leftSum + rightSum;
//            int leftSideOnly = dfs(nums, i, mid);
//            int rightSideOnly = dfs(nums, mid + 1, j);
//
//            return Math.max(bothSides, Math.max(leftSideOnly, rightSideOnly));
//
//        }


//Brute Force :   I am finding all the subarrays, and then I am finding the maximum sum out of all those subarrays.
    public static void main(String[] args) {
        int[] nums = {-2,-1,3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
