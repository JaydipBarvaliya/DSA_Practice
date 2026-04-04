package SearchingAndSorting;


/**

 PROBLEM:

 <a href="https://www.geeksforgeeks.org/problems/count-squares3649/0">...</a>

 Given a positive integer n, find the number of perfect squares that are less than n in the sample space of perfect squares.
 The sample space consists of all perfect squares starting from 1 (i.e., 1, 4, 9, 16, 25, …)

 Examples :

 Input: n = 9
 Output: 2


 counter = 2
 1 = 1*1 == 1
 2 =2 *2 == 4
 3 = 3*3 = 9
 Explanation: 1 and 4 are the only Perfect Squares less than 9. So, the Output is 2.
 Input: n = 3
 Output: 1
 Explanation: 1 is the only Perfect Square less than 3. So, the Output is 1.

 ------------------------------------------------------------------------------------------------------------------------
 */



public class _16_NumberOfPerfectSquareLessThenN {

    /**
     Time : O(1)
     Space : O(1)
     */
    public int optimized(int n) {
        return (int)Math.sqrt(n-1);
    }


    /**
     Time : O(√n)
     Space : O(1)
     Approach: starting from 1, count the square of each n which value is less than target and return that counter.
     */
    public int brute(int n) {

        int num = 1;
        int count = 0;
        while (num * num < n) {
            count++;
            num++;
        }
        return count;
    }
}