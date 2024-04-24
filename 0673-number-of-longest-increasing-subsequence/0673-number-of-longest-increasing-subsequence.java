class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];

        int maxi = -1;

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for(int idx = 0;idx<n;idx++){
            for(int prev = 0;prev<idx;prev++){
                if(arr[idx] > arr[prev] && dp[idx] < dp[prev]+1){
                    dp[idx] = dp[prev]+1;
                    // Inherit
                    count[idx] = count[prev];
                }
                else if(arr[idx] > arr[prev] && dp[idx] == dp[prev]+1){
                    // Increase the count
                    count[idx] += count[prev];
                }
            }
            maxi = Math.max(maxi, dp[idx]);
        }
        int nos = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi){
                nos+=count[i];
            }
        }
        return nos;
    }
}