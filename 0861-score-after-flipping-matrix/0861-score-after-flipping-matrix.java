class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        //row wise
        for(int i=0;i<n;i++){
            // if the first element is 0 then toggle thr whole row
            if(grid[i][0] == 0){
                for(int j = 0;j<m;j++){
                    // converting from 1 to 0 and vice versa
                    grid[i][j] ^= 1;
                }
            }
        }
        
        // column wise
        for(int j=1;j<m;j++){
            int count = 0;
            for(int i=0;i<n;i++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
            if(count < (n - count)){
                for(int i=0;i<n;i++){
                    grid[i][j] ^= 1;
                }
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans += grid[i][j] *(1<< (m-j-1));
            }
        }
        return ans;
    }
}