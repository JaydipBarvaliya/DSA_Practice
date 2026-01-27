public class _6_MaximumSumOfSubArrayWithSizeK_PENDING {

    public static void maximumSumOfSubArrayWithSizeK(int[] nums, int windowSize) {

//        You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].
//        [-4 3 5 -2 -1 ]
//
//        currSum = -4
//        maxSum = -4

//        I am finding all the subarrays and then I am finding the maximum sum out of all those subarrays.


    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60};
        maximumSumOfSubArrayWithSizeK(nums, 3);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
