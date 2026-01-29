//class Solution {
//    public void rotate(int[] nums, int k) {
//
//        int n  = nums.length;
//        k = k % n;
//        int count = 0;
//        for(int start = 0 ; count<n; start++){
//
//            int current = start;
//            int temp = nums[start];
//
//            do{
//                int next = (current + k) % n;
//                int saved = nums[next];
//                nums[next] = temp;
//                temp = saved;
//
//                current = next;
//                count++;
//            }while(current!=start);
//        }
//    }
//}


//class Solution {
//    public void rotate(int[] nums, int k) {
//
//        int n = nums.length;
//        k = k % n;
//        reversee(0, n-1, nums);
//        reversee(0, k-1, nums);
//        reversee(k, n-1, nums);
//    }
//
//    private void reversee(int start, int end, int[] nums) {
//
//        while(start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
//}
