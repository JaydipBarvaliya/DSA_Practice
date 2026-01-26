import java.util.Arrays;

public class ReverseAnArray {

    public static int[] reverseArray(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] result = reverseArray(new int[] {-5, -1, -10, 0});
        System.out.println(Arrays.toString(result));
    }
}