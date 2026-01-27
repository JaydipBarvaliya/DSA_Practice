import java.util.Arrays;

public class _5_RotateClockwiseByOne {

    public static int[] rotateClockwiseByOne(int[] nums, int shift) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int last = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = last;

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60};
        rotateClockwiseByOne(nums, 1);

        System.out.println(Arrays.toString(nums));
    }
}
