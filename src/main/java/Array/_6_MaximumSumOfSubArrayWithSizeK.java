package Array;
//        You are given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].
//        [-4 3 5 -2 -1 ]
//
//        currSum = -4
//        maxSum = -4

//        I am finding all the subarrays, and then I am finding the maximum sum out of all those subarrays.
//
public class _6_MaximumSumOfSubArrayWithSizeK {

    public static int maxSubarraySum(int[] arr, int k) {


                int i = 0;
                int j = 0;
                int windowSum = 0;
                int max = Integer.MIN_VALUE;

                for (j = 0; j < k; j++) {
                    windowSum = windowSum + arr[j];
                }

                max = windowSum;

                while (j < arr.length) {

                    windowSum = windowSum + arr[j];
                    windowSum = windowSum - arr[i];
                    max = Math.max(max, windowSum);
                    i++;
                    j++;
                }
                return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubarraySum(nums, 3));

    }
}
