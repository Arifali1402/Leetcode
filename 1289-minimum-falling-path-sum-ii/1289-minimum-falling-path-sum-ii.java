class Solution {
    // Similar to Ninja's Training Problem'
    private int helper(int idx, int prev, int[][] grid, int dp[][]){
        // Base condition
        if(idx == 0){
            int maxi = Integer.MAX_VALUE;
            for(int i=0;i<grid[0].length;i++){
                if(i != prev){
                    maxi = Math.min(maxi, grid[0][i]);
                }
            }
            return maxi;
        }

        if(dp[idx][prev] != -1){
            return dp[idx][prev];
        }
        // Explore all possibilities
        int maxi = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            if(i != prev){
                maxi = Math.min(maxi, grid[idx][i] + helper(idx-1, i, grid, dp));
            }
        }
        return dp[idx][prev] = maxi;
    }

    public int minFallingPathSum(int[][] grid) {
        if(grid.length == 1){
            return grid[0][0];
        }
        int n = grid.length;
        int dp[][] = new int[n][n+1];
        for(int rows[]:dp){
            Arrays.fill(rows, -1);
        }
        return helper(n-1, n, grid, dp);
    }
}