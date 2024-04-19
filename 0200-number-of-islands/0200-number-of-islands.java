class Solution {
    private void dfs(int i, int j, char grid[][]){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        if(grid[i][j] == '2'){
            return;
        }
        grid[i][j] = '2';
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        return;
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,grid);    
                }
            }
        }
        return count;
    }
}