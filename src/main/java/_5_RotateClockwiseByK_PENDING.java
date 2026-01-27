import java.util.Arrays;

public class _5_RotateClockwiseByK_PENDING {

    public static int[] rotateClockwiseByKPosition(int[] nums, int shift) {

        if (nums == null || nums.length <= 1) return nums;

        int temp = nums[0];
        for(int idx=0; idx<nums.length; idx++){

            int nextPosition = (idx+1) % nums.length;
            temp = nums[nextPosition];
            nums[nextPosition] = nums[idx];
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60};
        rotateClockwiseByKPosition(nums, 1);

        System.out.println(Arrays.toString(nums));
    }
}
