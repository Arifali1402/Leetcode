class Solution {
    private int helper(int i,int j1, int j2, int[][] grid, int[][][] dp){
        // Out of bound conditions
        if(j1<0 || j1 >=grid[0].length || j2<0 || j2 >=grid[0].length){
            return (int) (-1e7);
        }
        // Base conditions
        if(i == grid.length - 1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        // for dp[][][]
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        // All paths
        int ans = 0;
        for(int dj1 = -1; dj1<=1;dj1++){
            for(int dj2 = -1;dj2<=1;dj2++){
                if(j1 == j2){
                    ans = Math.max(ans,grid[i][j1] + helper(i+1,j1+dj1,j2+dj2,grid,dp));
                }
                else{
                    ans = Math.max(ans,grid[i][j1] + grid[i][j2] + helper(i+1,j1+dj1,j2+dj2,grid,dp));
                }
            }
        }
        return dp[i][j1][j2] = ans;
    }


    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] =new int[n][m][m];
        for(int d[][] : dp){
            for(int rows[] : d){
                Arrays.fill(rows,-1);
            }
        }
        return helper(0,0,m-1,grid,dp);
    }
}