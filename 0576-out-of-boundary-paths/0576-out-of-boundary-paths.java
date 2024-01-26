class Solution {
    private int MOD = 1000000007;
    private int helper(int m,int n,int maxMove,int row,int col,int dp[][][]){
        if(row<0 || row>=m || col<0 || col>=n){
            return 1;
        }
        if(maxMove <= 0){
            // if(row>=0 && row<m && col >=0 && col<n){
            //     return 0;
            // }
            // else{
            //     return 1;
            // }
            return 0;
        }
        if(dp[row][col][maxMove] != -1){
            return dp[row][col][maxMove]%MOD;
        }
        int up = (helper(m,n,maxMove-1,row-1,col,dp))%MOD;
        int down = (helper(m,n,maxMove-1,row+1,col,dp))%MOD;
        int left = (helper(m,n,maxMove-1,row,col-1,dp))%MOD;
        int right = (helper(m,n,maxMove-1,row,col+1,dp))%MOD;
        dp[row][col][maxMove] = ((up+down)%MOD+(left+right)%MOD)%MOD;
        return dp[row][col][maxMove] % MOD;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][] = new int[m][n][maxMove+1];
        for(int[][] twoD: dp){
            for(int row[]: twoD){
                Arrays.fill(row,-1);
            }
        }
        return helper(m,n,maxMove,startRow,startColumn,dp);
    }
}