class Solution {

    private void findMinis(int[][] matrix, int m, int i, List<Integer> list, List<Integer> idx) {
        int q = -1;
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            if (mini > matrix[i][j]) {
                mini = matrix[i][j];
                q = j;
            }
        }
        list.add(mini);
        idx.add(q);
        return;
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> minis = new ArrayList<>();
        List<Integer> idx = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            findMinis(matrix, m, i, minis, idx);
        }
        int t = 0; // for index in idx
        int y = 0; // for index in minis
        for(int j=0;j<idx.size();j++){
            int curr = idx.get(j);
            int mi = minis.get(j);
            int temp = mi;
            for(int k=0;k<n;k++){
                if(mi < matrix[k][curr]){
                    mi = matrix[k][curr];
                }
            }
            if(mi == temp){
                ans.add(mi);
            }
        }
        return ans;
    }
}

// if(j != idx.get(t)){
//                 continue;
//             }
//             int mi = minis.get(y);
//             int tmp = mi;
//             y++;
//             for(int k=0;k<n;k++){
//                 if(mi < matrix[k][j]){
//                     mi = matrix[k][j];
//                 }
//             }
//             if(mi == tmp){
//                 ans.add(mi);
//             }
//             t++;