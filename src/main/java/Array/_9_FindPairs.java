package Array;//Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
//Note: The pairs must be returned in sorted order, the solution array should also be sorted,
//and the answer must not contain any duplicate pairs.

//Input: arr = [-1, 0, 1, 2, -1, -4]
//Output: [[-1, 1]]
//Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
//arr[2] + arr[4] = 1 + (-1) = 0.
//The distinct pair are [-1,1].

// 1) sort the array (this is important part)
// 2) use left and right pointer and move them invert
// 3) if sum == 0, record the pair
// 4) if sum > 0, decrease the right pointer
// 5) if sum < 0, increase the left pointer
// 6) skip the duplicates by comparing the next/previous element

// Time Complexity
    // 1) Sorting == nlog(n)
    // 2) while == O(n)
    // total  ==  n log(n)

// Space Complexity
    // 1) o(n) because of result

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_FindPairs {

    public static List<List<Integer>> findPairs(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int left  = 0;
        int right = arr.length - 1;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(sum == 0){

                result.add(Arrays.asList(arr[left], arr[right]));

                while(left < right && arr[left] == arr[left+1]) left++;
                while(left < right && arr[right] == arr[right-1]) right--;

                left++;
                right--;

            }else if(sum > 0){
                right--;

            }else if(sum < 0){
                left++;

            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, -1, -1, -1, -1, -1};
        List<List<Integer>> result = findPairs(nums);
        System.out.println(result);
    }

}
