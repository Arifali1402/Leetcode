class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        long edgeCount[] = new long[n];
        for(int road[]: roads){
            edgeCount[road[0]]++;
            edgeCount[road[1]]++;
        }
        Arrays.sort(edgeCount);
        for(int i=1;i<=n;i++){
            ans = ans + (i*edgeCount[i-1]);
        }
        return ans;
    }
}