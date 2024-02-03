class Solution {
    private int helper(int idx,int arr[], int k,int dp[]){
        int n = arr.length;
        if(idx == n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int length = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int j = idx;j<Math.min(idx+k,n);j++){
            length++;
            maxi = Math.max(maxi,arr[j]);
            int sum = length * maxi + helper(j+1,arr,k,dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[idx] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return helper(0, arr, k, dp);        
    }
}