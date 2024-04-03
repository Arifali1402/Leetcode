class Solution {
    // Time Complexity -> O(n*m*(4^n))
    private boolean isPathExist(int i, int j, int idx, char[][] board, String word, boolean[][] visited){
        // If we found the word
        if(idx == word.length()){
            return true;
        }
        
        // Conditions for returning false
        if(i<0 || j<0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        // Revisiting the character in the board
        if(visited[i][j] == true){
            return false;
        }
        // Mark the current position as visited
        visited[i][j] = true;
        // Explore all the paths
        boolean result = isPathExist(i+1, j, idx+1, board, word, visited) || isPathExist(i-1, j, idx+1, board, word, visited) || isPathExist(i, j+1, idx+1, board, word, visited) || isPathExist(i, j-1, idx+1, board, word, visited);
         // Mark the current position as unvisited
        visited[i][j] = false;
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        // Map<Integer, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                // if(isPathExist(i, j, 0, board, word, map) == true){
                //     return true;
                // }
                if(isPathExist(i, j, 0, board, word, visited) == true){
                    return true;
                }
            }
        }
        return false;
    }
}