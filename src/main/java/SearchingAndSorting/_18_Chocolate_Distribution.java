package SearchingAndSorting;


import java.util.ArrayList;
import java.util.Collections;

/**

 PROBLEM: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 0) The best subset of size m is always m consecutive elements in the sorted array. <-- This is the most important statement

 1) Sort the array so that less gap elements comes together in sequence
 2) use sliding window to traverse through sorted array
 3) i = 0
 4) j = window size which is nothing but totalStudents or m
 5) find the min among all the (j-i) in the entire sorted array



 Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
              [1, 3, 4, 7, 9, 9, 12, 56]
 Output: 6
 Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following m packets :[3, 4, 9, 7, 9].

 Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5

 ------------------------------------------------------------------------------------------------------------------------

 Time : O(n log n) == because of sorting (traversing the entire array takes O(n-m) which we can ignore in front of nlog(n))


 O(n) + O(n log n)
 O(n) ( 1 + log(n) <-- O(n) becomes common
 log(n)
 Space: O(n) == Sorting algo may take space O(n) space internally

 ------------------------------------------------------------------------------------------------------------------------
 */


public class _18_Chocolate_Distribution {
    public int findMinDiff(ArrayList<Integer> arr, int totalStudents) {

        Collections.sort(arr);

        int i = 0;
        int j = totalStudents - 1;

        int minDiff = Integer.MAX_VALUE;

        while(j < arr.size()) {

            minDiff = Math.min(minDiff, arr.get(j) - arr.get(i));
            i++;
            j++;
        }
        return minDiff;
    }
}
