class Solution {
    // The main idea is to multiply the nodes' priority with the number of edges the node is connected with.
    // The priority is based on the number of edges the node is connected with.
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