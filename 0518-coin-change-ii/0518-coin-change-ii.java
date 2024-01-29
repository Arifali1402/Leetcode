class Solution {
     private int helper(int idx,int arr[],int target,int dp[][]){
        if(idx == 0){
            if(target%arr[0] == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int notPick = 0 + helper(idx-1,arr,target,dp);
        int pick = 0;
        if(target>=arr[idx]){
            pick = helper(idx,arr,target-arr[idx],dp);
        }
        return dp[idx][target] = pick+notPick;
    }
    
    public int change(int amount, int[] coins) {
        if(amount <= 0){
            return 1;
        }
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int rows[]: dp){
            Arrays.fill(rows,-1);
        }
        return helper(n-1,coins,amount,dp);
    }
}
