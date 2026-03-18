package Array;//Given an array arr and a number k. One can apply a swap operation on the array any number of times, i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] .
//Find the minimum number of swaps required to bring all the numbers less than or equal to k together,
//i.e. make them a contiguous subarray.

//Examples :
//Input: arr[] = [2, 1, 5, 6, 3, 7, 8, 9], k = 3
//Output: 1
//
//Explanation: To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing),
//i.e. element arr[2] = 5 with arr[4] = 3 such that final array will be- arr[] = [2, 1, 3, 6, 5]


//Approach - (SLIDING WINDOW)
    // 1) find the total good elements in the array which are less or equal to K which are nothing but the size of the window
    // 2) initially calculate the bad elements ( greater than k ) in the same window
    // 3) start sliding the window and calculate bad elements
    // 4) increase or decrease the bad element during each window slide and compare it against the minSwap result variable.


// Time : O(n)
// Space : O(1)

public class _11_MinumumSwaps {

    int minSwap(int[] arr, int k) {

        int lessOrEqualToK = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= k){
                lessOrEqualToK++;
            }
        }

        if(lessOrEqualToK == 0) return 0;

        int windowSize = lessOrEqualToK;
        int greaterThanK = 0;

        for(int i = 0; i < windowSize; i++) { // calculating for the first window
            if(arr[i] > k){
                greaterThanK++;
            }
        }

        int minSwap = greaterThanK;

        //Moving window
        int i = 0;
        int j = windowSize;

        while(j < arr.length){

            if(arr[j] > k) greaterThanK++; // Entering new element from right side
            if(arr[i] > k) greaterThanK--; // Removing the element from the left side

            minSwap = Math.min(minSwap, greaterThanK);
            i++;
            j++;
        }

        return minSwap;
    }

        public static void main(String[] args) {
            int[] nums = {-1, -1, -1, -1, -1, -1};
//        List<List<Integer>> result = findPairs(nums);
//        System.out.println(result);
        }
}
//TODO: rename the variables