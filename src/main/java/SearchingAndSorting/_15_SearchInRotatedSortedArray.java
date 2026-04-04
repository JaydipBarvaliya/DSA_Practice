package SearchingAndSorting;


/**

 PROBLEM:
 https://leetcode.com/problems/search-in-rotated-sorted-array/description/

 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) slice the array in two half

 2) if left half is sorted and target is inside, then explore it further
    otherwise explore the right half

 3)ELSE

 4)if right half is sorted and target is inside, then explore it further
  otherwise explore the left half

 5) compare the mid-element with the target

 ------------------------------------------------------------------------------------------------------------------------

 Time : O(logN)
 Space : O(logN) == recursion goes up to the depth of the tree while searching and depth of the tree is log(n), so space is log(n)
 Without Recursion Stack -- Space Complexity would be O(1) because we are not using any extra data structure to store anything.
 ------------------------------------------------------------------------------------------------------------------------

 */

public class _15_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return find(0, nums.length - 1, nums, target);
    }

    private int find(int i, int j, int[] arr, int target) {

        if (i > j) return -1; // base case FIRST!

        int mid = (j - i) / 2 + i; // we have to include the i to ensure the index order is relative to the main array

        if (arr[mid] == target) return mid;

        if(arr[i] <= arr[mid]) { // left half is sorted
            if (target >= arr[i] && target < arr[mid]) { // if it is inside the left, find it further inside the left part
                return find(i, mid - 1, arr, target);
            } else {
                return find(mid + 1, j, arr, target); // if it not in the left half, then directly search on the right side.
            }
        } else { // right half is sorted
            if (target > arr[mid] && target <= arr[j]) { // if the target is in the right half, search it further
                return find(mid + 1, j, arr, target);
            } else {
                return find(i, mid - 1, arr, target); // even after having right part sorted, if target is not there, then search in the left part.
            }
        }
    }
}
