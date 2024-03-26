class Solution {
    private int helper(int index, int buy, int prices[], int dp[][]){
        // Base Case
        if(index == prices.length){
            return 0;
        }
        
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit = 0;
        // When I can buy the stocks
        if(buy == 1){
            int take = -prices[index] + helper(index+1, 0, prices,dp);
            int notTake = 0 + helper(index+1, 1, prices,dp);
            profit = Math.max(take, notTake);
        }
        // When I have to sell the stocks
        else{
            int sell = prices[index] + helper(index+1, 1, prices,dp);
            int notSell = 0 + helper(index+1, 0, prices,dp);
            profit = Math.max(sell, notSell);
        }
        return dp[index][buy] = profit;
    }    
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return helper(0, 1, prices, dp);
    }
}