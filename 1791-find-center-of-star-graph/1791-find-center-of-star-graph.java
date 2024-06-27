class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int count[] = new int[n+2];
        for(int[] edge: edges){
            count[edge[0]]++;
            count[edge[1]]++;
        }
        for(int i=1;i<n+2;i++){
            if(count[i]>1){
                return i;
            }
        }
        return -1;
    }
}