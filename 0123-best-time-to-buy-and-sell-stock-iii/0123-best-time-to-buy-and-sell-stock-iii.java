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