package Array;

import java.util.Arrays;

public class _5_RotateClockwiseByK {

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
// Another approach is to 3-step
    // 1) reverse the entire array  O(N) == Time complexity would be O(N) and space is O(1)
    // 2) reverse the first k elements 0(k)
    // 3) reverse the rest n-k elements O(n-k)


    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60};
        rotateClockwiseByKPosition(nums, 1);


        System.out.println(Arrays.toString(nums));
    }
}