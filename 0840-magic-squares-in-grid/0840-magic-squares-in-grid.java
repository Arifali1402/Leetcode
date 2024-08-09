class Solution {
    private int helper(int r, int c, int[][] grid){
        Set<Integer> set = new HashSet<>();
        
        // Ensure 1-9
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(set.contains(grid[i][j]) || grid[i][j] <=0 || grid[i][j] >=10){
                    return 0;
                }
                set.add(grid[i][j]);
            }
        }
        // Rows
        for(int i=r;i<r+3;i++){
            int rSum = 0;
            for(int j=c;j<c+3;j++){
                rSum += grid[i][j];
            }
            if(rSum != 15){
                return 0;
            }
        }
        
        // Columns
        for(int j=c;j<c+3;j++){
            int cSum = 0;
            for(int i=r;i<r+3;i++){
                cSum += grid[i][j];
            }
            if(cSum != 15){
                return 0;
            }
        }  
        
        int d1Sum = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        if(d1Sum != 15){
            return 0;
        } 

        int d2Sum = grid[r+2][c] + grid[r+1][c+1] + grid[r][c+2];
        if(d2Sum != 15){
            return 0;
        } 

        return 1;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int i=0;i<rows-2;i++){
            for(int j=0;j<cols-2;j++){
                int count = helper(i,j,grid);
                result = result+count;
            }
        }
        return result;
    }
}