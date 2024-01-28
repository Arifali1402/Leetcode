class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        // prefix sum
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j] += matrix[i][j-1]; 
            }
        }
        
        int count = 0;
        
        for(int c1 = 0;c1<m;c1++){
            for(int c2 = c1;c2<m;c2++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum = 0;
                for(int row = 0;row<n;row++){
                    sum += matrix[row][c2] -(c1>0 ? matrix[row][c1-1]:0);
                    count += map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        
        return count;
    }
}