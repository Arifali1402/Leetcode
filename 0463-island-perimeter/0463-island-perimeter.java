class Solution {
    private int dfs(int i, int j, int[][]grid){
        // Base Conditions
        //if we encounter water then return 1
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return 1;
        }
        // If the grid was previously visited then return 0
        if(grid[i][j] == -1){
            return 0;
        }
        // mark the grid as visited by storing -1
        grid[i][j] = -1;
        // calculate the perimeter
        int perimeter = 0;
        perimeter += dfs(i,j+1,grid);
        perimeter += dfs(i+1, j,grid);
        perimeter += dfs(i, j-1,grid);
        perimeter += dfs(i-1, j,grid);
        return perimeter;
    }

    public int islandPerimeter(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid);
                }
            }
        }
        return -1;
    }
}