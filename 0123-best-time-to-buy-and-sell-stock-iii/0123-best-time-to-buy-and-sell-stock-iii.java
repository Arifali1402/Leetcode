class Solution {
    // SPACE OPTIMIZATION
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int curr[][] = new int[2][3];
        int after[][] = new int[2][3];
        // Base conditions
        // for(int idx = 0;idx<n;idx++){
        //     for(int buy = 0;buy<2;buy++){
        //         curr[buy][0] = 0;
        //     }
        // }
        // for(int buy = 0;buy<2;buy++){
        //     for(int capacity = 0;capacity<3;capacity++){
        //         [buy][capacity] = 0;
        //     }
        // }
        // idx == n  is in base condition
        for(int idx = n-1; idx>=0;idx--){
            for(int buy = 0;buy<2;buy++){
                // capacity == 0 is in base condition
                for(int capacity = 1;capacity<3;capacity++){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[idx] + after[0][capacity];
                        int notTake = 0 + after[1][capacity];
                        profit = Math.max(take, notTake);
                    }
                    else{
                        int sell = prices[idx] + after[1][capacity-1];
                        int notSell = 0 + after[0][capacity];
                        profit = Math.max(sell, notSell);
                    }
                    // Return the profit
                    curr[buy][capacity] = profit;
                }
            }
            after = curr.clone();
        }
        return after[1][2];
    }
}
/*
// TABULATION
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        // Base conditions
        for(int idx = 0;idx<n;idx++){
            for(int buy = 0;buy<2;buy++){
                dp[idx][buy][0] = 0;
            }
        }
        for(int buy = 0;buy<2;buy++){
            for(int capacity = 0;capacity<3;capacity++){
                dp[n][buy][capacity] = 0;
            }
        }
        // idx == n  is in base condition
        for(int idx = n-1; idx>=0;idx--){
            for(int buy = 0;buy<2;buy++){
                // capacity == 0 is in base condition
                for(int capacity = 1;capacity<3;capacity++){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[idx] + dp[idx+1][0][capacity];
                        int notTake = 0 + dp[idx+1][1][capacity];
                        profit = Math.max(take, notTake);
                    }
                    else{
                        int sell = prices[idx] + dp[idx+1][1][capacity-1];
                        int notSell = 0 + dp[idx+1][0][capacity];
                        profit = Math.max(sell, notSell);
                    }
                    // Return the profit
                    dp[idx][buy][capacity] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
}

MEMOIZATION
class Solution {
    private int helper(int idx, int buy, int capacity, int[] prices, int dp[][][]){
        // Base Cases
        if(capacity == 0){
            return 0;
        }
        if(idx == prices.length){
            return 0;
        }
        if(dp[idx][buy][capacity] != -1){
            return dp[idx][buy][capacity];
        }
        // Explore all Possibilities
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx] + helper(idx+1, 0, capacity, prices,dp);
            int notTake = 0 + helper(idx+1, 1, capacity, prices,dp);
            profit = Math.max(take, notTake);
        }
        else{
            int sell = prices[idx] + helper(idx+1, 1, capacity-1, prices,dp);
            int notSell = 0 + helper(idx+1, 0, capacity, prices,dp);
            profit = Math.max(sell, notSell);
        }
        // Return the profit
        return dp[idx][buy][capacity] = profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int t[][] : dp){
            for(int rows[] : t){
                Arrays.fill(rows, -1);
            }
        }
        return helper(0, 1, 2, prices, dp);
    }
}
*/