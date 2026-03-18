package Array;//PROBLEM:
//Given an array arr[] of positive integers. Return true if all the array elements are palindrome otherwise, return false.
//
//Examples:
//
//
//
//Input: arr[] = [111, 222, 333, 444, 555]
//Output: true
//Explanation:
//arr[0] = 111, which is a palindrome number.
//        arr[1] = 222, which is a palindrome number.
//        arr[2] = 333, which is a palindrome number.
//        arr[3] = 444, which is a palindrome number.
//        arr[4] = 555, which is a palindrome number.
//As all numbers are palindrome so This will return true.
//
//
//Input: arr[] = [121, 131, 20]
//Output: false
//
//Explanation: 20 is not a palindrome hence the output is false.
//
//Expected Time Complexity: O(nlogn)
//Expected Space Complexity: O(1)
//
//Constraints:
//        1 <=arr.size<= 20
//        1 <=arr[i]<= 105
//------------------------------------------------------------------------------------------------------------------------

//Approach
// 1)
// 2)
// 3)
// 4)
// 5)
// 6)
// 7)
// 8)
// 9)
//------------------------------------------------------------------------------------------------------------------------

// i.e. log[base=10] (100) = 2
// average number of digits in each number = log[base=10] of the value
// Time  : O(average number of digits in each number) * O(n)
// Space : O(1)


public class _11_Palindrome {

    public static boolean isPalinArray(int[] arr) {

        for(int num : arr){
            if(!isPalindrome(num)) return false;
        }
     return true;
    }

    public static boolean isPalindrome(int n) {

        int original = n;
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        return original == rev;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{111, 222, 333, 444, 555, 5656};
        System.out.println(isPalinArray(nums));
    }
}
