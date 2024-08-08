class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int directions[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int res[][] = new int[rows * cols][2];
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int steps = 1;
        int r = rStart;
        int c = cStart;
        int index = 0;
        while (list.size() < rows * cols) {
            for (int j = 0; j < 2; j++) {
                int dr = directions[i][0];
                int dc = directions[i][1];
                for (int k = 0; k < steps; k++) {
                    if ((r >= 0 && r < rows) && (c >= 0 && c < cols)) {
                        list.add(new int[] { r, c });
                        res[index++] = new int[] { r, c };
                    }
                    r = r + dr;
                    c = c + dc;
                }
                i = (i + 1) % 4;
            }
            steps = steps+1;
        }
        return res;
    }
}