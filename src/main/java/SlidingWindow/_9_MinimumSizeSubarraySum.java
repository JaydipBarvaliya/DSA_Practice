package SlidingWindow;

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
