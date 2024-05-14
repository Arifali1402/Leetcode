class Solution {

    private int helper(int i, int j, int[][] grid,int vis[][]){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j] == 1 || grid[i][j] == 0){
            return 0;
        }
        int total = grid[i][j];
        vis[i][j] = 1;

        int max = Math.max(Math.max(helper(i+1,j,grid,vis),helper(i-1,j,grid,vis)),Math.max(helper(i,j+1,grid,vis),helper(i,j-1,grid,vis)));

        vis[i][j] = 0;
        return total+max;
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int maxGold = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxGold = Math.max(maxGold, helper(i,j,grid,vis));
            }
        }
        return maxGold;
    }
}