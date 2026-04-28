package Greedy;

/**

PROBLEM: https://www.geeksforgeeks.org/problems/smallest-number5829/1

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Brute Force: find the range for number of digits = 2 --> [10, 99] and try each of the number one by one
2)
3) instead of trying each number one by one, start constructing number
4) start from right to left, because we want the biggest number, bigger the right most-number, smaller sum will become by the time
5) by the time we reach towards left, sum will become smaller and smaller
6) actual intuition is to make the number as smaller as possible, and to do that, the smaller the left digits are, better it would be
7) edge case: we cannot keep the 1st digit as 0 so we have reserved it for digit '1'
8) so we start constructing number from right to left except 0th index where 1 would be for sure in case we have sum left at the end which is greater than 8
9)
10) if you want the biggest number then start scanning from left to right, and leading 0 at the end of final answer would be fine.

11) every time we identify sum digit we just subtract it from the sum, and we will find the next digit based on the last sum
12)
------------------------------------------------------------------------------------------------------------------------

 Time: O(d) — you iterate through d digits once, each step is O(1)
 Space: O(d) — the char[] array of size d
------------------------------------------------------------------------------------------------------------------------

*/
class _26_Smallest_Number {

    public String smallestNumber(int sum, int digits) {

        //It means the maximum possible sum for a given number of digits.
        //Each digit can be at most 9. So if you have 3 digits, the maximum sum you can ever get is 9+9+9 = 27.
        //So if someone asks for sum=30, digits=3 — it's impossible because even 999 only sums to 27. That's when sum > 9 * digits catches it and returns -1.
        if(sum > 9 * digits || sum < 1) return "-1";

        char[] arr = new char[digits];
        sum = sum-1;
        for(int idx = digits-1; idx>0; idx--){
            int newDigit = Math.min(9, sum);
            arr[idx] = (char)(newDigit + '0');
            sum = sum - newDigit;
        }

        arr[0] = (char)(sum+1 + '0');
        return new String(arr);
    }

    public String biggestNumber(int sum, int digits) {

        if(sum > 9 * digits || sum < 1) return "-1";


        char[] arr = new char[digits];
        for(int idx = 0; idx<digits; idx++){

            int newDigit = Math.min(9, sum);
            arr[idx] = (char)(newDigit + '0');
            sum = sum - newDigit;
        }
        return new String(arr);
    }

}
