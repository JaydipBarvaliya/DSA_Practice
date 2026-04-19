package DP;

import java.util.Arrays;

public class _14_Coin_Change_II {

    public int coinChange(int[] coins, int target) {

        int[][] dp = new int[coins.length][target+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = dfs(coins, 0, 0, target, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    int dfs(int[] coins, int i, int currentSum, int target, int[][] dp){

        if( i == coins.length) return Integer.MAX_VALUE;

        if(dp[i][currentSum] !=  -1) return dp[i][currentSum];

        if(currentSum > target) return Integer.MAX_VALUE;

        int consider = 1 + dfs(coins, i, currentSum + coins[i], target, dp);
        int skipping = dfs(coins, i+1, currentSum , target, dp);

        dp[i][currentSum] = Math.min(consider, skipping);
        return dp[i][currentSum];
    }
}
