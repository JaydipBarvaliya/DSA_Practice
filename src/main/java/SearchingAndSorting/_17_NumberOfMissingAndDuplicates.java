package SearchingAndSorting;


import java.util.ArrayList;
import java.util.HashMap;

/**

 PROBLEM:
 Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing,
 and another number occurs twice in the array, find both the duplicate number and the missing number.

 Examples:

 Input: arr[] = [2, 2]
 Output: [2, 1]

 Explanation: Repeating number is 2 and the missing number is 1.
 Input: arr[] = [1, 3, 3]
 Output: [3, 2]

 Explanation: Repeating number is 3 and the missing number is 2.


 N = 9
 Input: arr[] = [1, 2, 3, 4, 5, 6, 8, 9, 9]





 Input: arr[] = [100, 1, 5, 400]
 Output: [9, 7]

 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) sum all the number starting from 1 to n using the following formula = n * (n+1)/2
 2) subtract each of the number one by one except the duplicate number to find out the missing number.
 3) Use frequency hashmap to find out the duplicate number
 4)
 ------------------------------------------------------------------------------------------------------------------------

 Time : O(n)
 Space : O(n)

 Optimize: we can optimize this by not using the hashmap as it is little overkill
 ------------------------------------------------------------------------------------------------------------------------

 */

public class _17_NumberOfMissingAndDuplicates {

    ArrayList<Integer> findTwoElement(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        long totalSum = (long) n*(n+1)/2; // we have to use long to handle the integer overflow scenario
        int duplicateNum = 0;

        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 1) {
                duplicateNum = arr[i];
            }else{
                totalSum = totalSum - arr[i]; // we kept this in the else condition so that we can skip the duplicate, otherwise in [2,2] case, total can become = -1 at end of all calculation
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(duplicateNum);
        list.add((int)totalSum);

        return list;
    }
}
