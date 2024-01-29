// Tabulation
class Solution {
    public int coinChange(int[] arr, int amount) {
        int n = arr.length;
        int dp[][] = new int[n][amount+1];
        for(int T = 0;T<=amount;T++){
            if(T%arr[0] == 0){
                dp[0][T] = T/arr[0];
            }
            else{
                dp[0][T] = (int)(1e7);
            }
        }
        for(int idx = 1;idx<n;idx++){
            for(int target = 0;target<=amount;target++){
                int notPick = 0 + dp[idx-1][target];
                int pick = (int)(1e7);
                if(target>=arr[idx]){
                    pick = 1 + dp[idx][target-arr[idx]];
                }
                dp[idx][target] = Math.min(pick,notPick);
            }
        }
        if(dp[n-1][amount]>=(int)(1e7)){
            return -1;
        }
        return dp[n-1][amount];
    }
}
/*
// Memoization
class Solution {
    private int helper(int idx,int arr[],int target,int dp[][]){
        if(idx == 0){
            if(target%arr[0] == 0){
                return target/arr[0];
            }
            else{
                return (int)(1e7);
            }
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int notPick = 0 + helper(idx-1,arr,target,dp);
        int pick = Integer.MAX_VALUE;
        if(target>=arr[idx]){
            pick = 1 + helper(idx,arr,target-arr[idx],dp);
        }
        return dp[idx][target] = Math.min(pick,notPick);

    }
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0){
            return 0;
        }
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int rows[]: dp){
            Arrays.fill(rows,-1);
        }
        int ans = helper(n-1,coins,amount,dp);
        if(ans >=(1e7)){
            return -1;
        }
        return ans;
    }
}
*/