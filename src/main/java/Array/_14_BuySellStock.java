package Array;


/**

 PROBLEM:

 Given an array prices[], where prices[i] represents the price of a stock on the i-th day, find the maximum profit that can be earned by performing at most two transactions.
 
 Each transaction consists of one buy and one sell operation, and a new transaction can begin only after the previous one is completed
 (i.e., you cannot hold more than one stock at a time).
 
 Examples:
 
 Input: prices[] = [10, 22, 5, 75, 65, 80]
 Output: 87
 Explanation:
 Buy at 10, sell at 22, profit = 22 - 10 = 12
 Buy at 5 and sell at 80, total profit = 12 + (80 - 5) = 87
 
 Input:  prices[] = [100, 30, 15, 10, 8, 25, 80]
 Output: 72
 Explanation: Only one transaction needed here. Buy at price 8 and sell at 80.
 
 Input:  prices[] = [90, 80, 70, 60, 50]
 Output: 0
 Explanation: Not possible to earn.

 ------------------------------------------------------------------------------------------------------------------------

 BRUTE FORCE APPROACH -- using 4 for loop = O(n)^4


 Approach:
 1) It's all about making choices
 2) Buying
 3) Can buy but still skipping for better buy
 4) Selling
 5) Can Sell but still Skipping for better sell
 6) Memoize the repeated buy at index I and at x transaction
 7)
 8)

------------------------------------------------------------------------------------------------------------------------

Time : 2^n
Space : O(n)





GOLDEN RULE : Never carry accumulated result in DP state. Always return the best future result from current state.
------------------------------------------------------------------------------------------------------------------------

*/



//public class _14_BuySellStock {
//
//    public int maxProfit(int[] prices) {
//       return recur(prices, 0, true, 2);
//    }
//
//    public int recur(int[] prices, int index, boolean canBuy, int totalTxnLeft) {
//
//        if(index == prices.length || totalTxnLeft == 0)  return 0;
//
//        if(canBuy){
//
//            int buy = -prices[index] + recur(prices, index+1, false, totalTxnLeft);   // buying
//            int skip = recur(prices, index+1, true, totalTxnLeft);   // skipping
//
//            return Math.max(buy, skip);
//        }else{
//
//            int sell = prices[index] + recur(prices, index+1, true, totalTxnLeft-1);   // selling
//            int skip = recur(prices, index+1, false, totalTxnLeft);   // skipping
//
//            return Math.max(sell, skip);
//        }
//    }
//}


/** PROBLEM WITH THIS SOLUTION:

 I used dp[index], but my state actually depends on (index, canBuy, txnLeft).
 Same index can give different answers under different conditions, so values overwrite each other.
 DP must include all state variables → dp[index][canBuy][txnLeft].

 */

// class _14_BuySellStock {
//
//    public int maxProfit(int[] prices) {
//        int[] dp = new int[prices.length];
//        Arrays.fill(dp, -1);
//        return recur(prices, 0, true, 2, dp);
//    }
//
//    public int recur(int[] prices, int index, boolean canBuy, int totalTxnLeft, int[] dp) {
//
//        if(index == prices.length || totalTxnLeft == 0)  return 0;
//
//        if(dp[index] != -1) return dp[index];
//
//        if(canBuy){
//
//            int buy = -prices[index] + recur(prices, index+1, false, totalTxnLeft, dp);  // buying
//            int skip = recur(prices, index+1, true, totalTxnLeft, dp);  // skipping
//
//            dp[index] = Math.max(buy, skip);
//            return dp[index];
//        }else{
//
//            int sell = prices[index] + recur(prices, index+1, true, totalTxnLeft-1, dp);  // selling
//            int skip = recur(prices, index+1, false, totalTxnLeft, dp);  // skipping
//
//            dp[index] = Math.max(sell, skip);
//            return dp[index];
//        }
//    }
//}


import java.util.Arrays;

/** APPROACH : 3D DP Array
 *
 * Time  : O(n * 2 * 3) = O(n)
 * Space : O(n * 2 * 3) + recursion stack = O(n)
 *
 * */



class _14_BuySellStock {

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];

        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }


        return recur(prices, 0, 1, 2, dp);
    }

    //TODO: Revisit
    public int recur(int[] prices, int index, int canBuy, int totalTxnLeft, int[][][] dp) {

        if(index == prices.length || totalTxnLeft == 0)  return 0;

        if(dp[index][canBuy][totalTxnLeft] != -1) return dp[index][canBuy][totalTxnLeft];

        if(canBuy == 1){

            int buy = -prices[index] + recur(prices, index+1, 0, totalTxnLeft, dp);  // buying
            int skip = recur(prices, index+1, 1, totalTxnLeft, dp);  // skipping

            dp[index][canBuy][totalTxnLeft] = Math.max(buy, skip);
            return dp[index][canBuy][totalTxnLeft];
        }else{

            int sell = prices[index] + recur(prices, index+1, 1, totalTxnLeft-1, dp);  // selling
            int skip = recur(prices, index+1, 0, totalTxnLeft, dp);  // skipping

            dp[index][canBuy][totalTxnLeft] = Math.max(sell, skip);
            return dp[index][canBuy][totalTxnLeft];
        }
    }
}

//TODO: Simple and Efficient --