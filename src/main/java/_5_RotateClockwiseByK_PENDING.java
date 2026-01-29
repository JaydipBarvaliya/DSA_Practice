import java.util.Arrays;

public class _5_RotateClockwiseByK_PENDING {

    public static void rotateClockwiseByKPosition(int[] nums, int k) {

            int n  = nums.length;
            k = k % n;
            int count = 0;
            for(int start = 0 ; count<n; start++){

                int current = start;
                int temp = nums[start];

                do{
                    int next = (current + k) % n;
                    int saved = nums[next];
                    nums[next] = temp;
                    temp = saved;

                    current = next;
                    count++;
                }while(current!=start);
            }
        }


//        public void rotate(int[] nums, int k) {
//
//            int n = nums.length;
//            k = k % n;
//            reversee(0, n-1, nums);
//            reversee(0, k-1, nums);
//            reversee(k, n-1, nums);
//        }
//
//        private void reversee(int start, int end, int[] nums) {
//
//            while(start < end) {
//                int temp = nums[start];
//                nums[start] = nums[end];
//                nums[end] = temp;
//                start++;
//                end--;
//            }
//        }


    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60};
        rotateClockwiseByKPosition(nums, 1);

        System.out.println(Arrays.toString(nums));
    }
}