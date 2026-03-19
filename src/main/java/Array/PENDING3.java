package Array;


//Given an array prices[], where prices[i] represents the price of a stock on the i-th day, find the maximum profit that can be earned by performing at most two transactions.
//
//Each transaction consists of one buy and one sell operation, and a new transaction can begin only after the previous one is completed
//(i.e., you cannot hold more than one stock at a time).
//
//Examples:
//
//Input: prices[] = [10, 22, 5, 75, 65, 80]
//Output: 87
//Explanation:
//Buy at 10, sell at 22, profit = 22 - 10 = 12
//Buy at 5 and sell at 80, total profit = 12 + (80 - 5) = 87
//
//Input:  prices[] = [100, 30, 15, 10, 8, 25, 80]
//Output: 72
//Explanation: Only one transaction needed here. Buy at price 8 and sell at 80.
//
//Input:  prices[] = [90, 80, 70, 60, 50]
//Output: 0
//Explanation: Not possible to earn.

//GOLDEN RULE : Never carry accumulated result in DP state. Always return the best future result from current state.


import java.util.Arrays;

//time complexity : 2^n
//space complexity : O(n)
public class PENDING3 {

    public int maxProfit(int[] prices) {
       return recur(prices, 0, true, 2);
    }

    public int recur(int[] prices, int index, boolean canBuy, int totalTxnLeft) {

        if(index == prices.length || totalTxnLeft == 0)  return 0;

        if(canBuy){

            int buy = -prices[index] + recur(prices, index+1, false, totalTxnLeft); // buying
            int skip = recur(prices, index+1, true, totalTxnLeft); // skipping

            return Math.max(buy, skip);
        }else{

            int sell = prices[index] + recur(prices, index+1, true, totalTxnLeft-1); // selling
            int skip = recur(prices, index+1, false, totalTxnLeft); // skipping

            return Math.max(sell, skip);
        }
    }
}



class DP {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return recur(prices, 0, true, 2, dp);
    }

    public int recur(int[] prices, int index, boolean canBuy, int totalTxnLeft, int[] dp) {

        if(index == prices.length || totalTxnLeft == 0)  return 0;

        if(dp[index] != -1) return dp[index];

        if(canBuy){

            int buy = -prices[index] + recur(prices, index+1, false, totalTxnLeft, dp); // buying
            int skip = recur(prices, index+1, true, totalTxnLeft, dp); // skipping

            dp[index] = Math.max(buy, skip);
            return dp[index];
        }else{

            int sell = prices[index] + recur(prices, index+1, true, totalTxnLeft-1, dp); // selling
            int skip = recur(prices, index+1, false, totalTxnLeft, dp); // skipping

            dp[index] = Math.max(sell, skip);
            return dp[index];
        }
    }
}