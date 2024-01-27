class Solution {
    private int MOD = (int)(1e9+7);
    public int kInversePairs(int n, int k) {
        if(k == 0){
            return 1;
        }
        int dp[][] = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                for(int x=0;x<=Math.min(j,i-1);x++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-x]) % MOD;
                }
            }
        }
        return dp[n][k];
    }
}