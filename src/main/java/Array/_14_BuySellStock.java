package Array;


import java.util.Arrays;

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

 optimized approach -- 3D DP array to memoize

 Approach:
 1) It's all about making choices
 2) Buying
 3) Can buy but still skipping for better buy
 4) Selling
 5) Can Sell but still Skipping for better sell
 6) Memoize the repeated works with 3D DP array -- [index][buy/sell][totalTxns]
 7)

------------------------------------------------------------------------------------------------------------------------


GOLDEN RULE : Never carry accumulated result in DP state. Always return the best future result from current state.

 ❌ With profit carried:
    At i=5, profit=50
    → calls dfs(i=6, profit=50+something)
    → hits memo → returns 10

 Final = 10  ❌
 Missing the 50 that was earned before i=6



  ✅ Without profit carried:
    At i=5
    → calls dfs(i=6)
    → hits memo → returns 10

  Final = 50 + 10 = 60  ✅
  Caller adds its own contribution, memo gives the rest
------------------------------------------------------------------------------------------------------------------------
3D DP Array Visualization

[
  [        [10], [4], [5], [], []      ][        [20], [4], [500], [], [-1]          ]
  [        [], [], [], [], []          ][        [],   [],  [],  [], []          ]
  [        [], [], [], [], []          ][        [],   [],  [],  [], []          ]
  [        [], [], [], [], []          ][        [],   [],  [],  [], []          ]
  [        [], [], [], [], []          ][        [],   [],  [],  [], []          ]
  [        [], [], [], [], []          ][        [],   [],  [],  [], []          ]
]


 [10] denotes that at 0th index, if you can buy, then u can make 10 profit with 0 txns
 [4]  denotes that at 0th index, if you can buy, then u can make 4 profit with  1 txns

 [500] denotes that at 0th index, if you can sell, then u can make 500 profit with 2 txns
 [-1] denotes we have not calculated that yet
 ------------------------------------------------------------------------------------------------------------------------

 Time  : O(n * 2 * 3) = O(n)
 Space : O(n * 2 * 3) + recursion stack = O(n)

*/


class _14_BuySellStock {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++)
            for (int b = 0; b < 2; b++)
                Arrays.fill(dp[i][b], -1);
        return dfs(prices, 0, 1, 0, dp);
    }

    public int dfs(int[] prices, int i, int buy, int txnCounter, int[][][] dp){

        if(txnCounter == 2 || i == prices.length) return 0;

        if(dp[i][buy][txnCounter] != -1) return dp[i][buy][txnCounter];

        if(buy == 1){
            int buying   = 0-prices[i] + dfs(prices, i + 1, 0, txnCounter, dp);
            int skipping = dfs(prices, i + 1, 1, txnCounter, dp);
            dp[i][buy][txnCounter] =  Math.max(buying, skipping);
        }else{
            int selling   = (prices[i]) + dfs(prices, i + 1, 1, txnCounter+1, dp);
            int skipping  = dfs(prices, i + 1, 0, txnCounter, dp);
            dp[i][buy][txnCounter] =  Math.max(selling, skipping);
        }
        return dp[i][buy][txnCounter];
    }
}