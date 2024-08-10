class Solution {

    private int dfs(int grid2[][], int i, int j) {
        // edge
        if (i < 0 || j < 0 || i == grid2.length || j == grid2[0].length || grid2[i][j] != 0) {
            return 0;
        }
        grid2[i][j] = 1;
        return (1 + dfs(grid2, i + 1, j) + dfs(grid2, i, j + 1) + dfs(grid2, i - 1, j) + dfs(grid2, i, j - 1));
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int grid2[][] = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    grid2[i * 3][j * 3 + 2] = grid2[i * 3 + 1][j * 3 + 1] = grid2[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    grid2[i * 3][j * 3] = grid2[i * 3 + 1][j * 3 + 1] = grid2[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                ans += dfs(grid2, i, j) > 0 ? 1 : 0;
            }
        }
        return ans;
    }
}