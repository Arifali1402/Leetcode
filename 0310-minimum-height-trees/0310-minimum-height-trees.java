class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        int deg[] = new int[n];
        if(n <= 0){
            return ans;
        }
        if(n == 1){
            ans.add(0);
            return ans;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int e[] : edges){
            deg[e[0]]++;
            deg[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(deg[i] == 1){
                queue.add(i);
            }
        }
        while(n > 2){
            int size = queue.size();
            n = n - size;
            while(size-- > 0){
                int v = queue.poll();
                for(int i: adj.get(v)){
                    deg[i]--;
                    if(deg[i] == 1){
                        queue.add(i);
                    }
                }
            }
        }
        ans.addAll(queue);
        return ans;
    }
}