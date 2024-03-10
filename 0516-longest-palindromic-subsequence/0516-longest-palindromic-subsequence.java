class Solution {
    public int longestPalindromeSubseq(String str) {
        StringBuilder r = new StringBuilder(str);
        r = r.reverse();
        String revStr = r.toString();
        
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        // Base Conditions
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j] = 0;;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str.charAt(i-1) == revStr.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}