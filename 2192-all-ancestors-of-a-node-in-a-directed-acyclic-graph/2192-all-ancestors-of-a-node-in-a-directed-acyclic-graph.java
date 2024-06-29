class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // The Result
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }

        // Creating the Adjacency list
        ArrayList<Integer>[] adjGraph = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjGraph[i] = new ArrayList<>();
        }
        for(int[]edge: edges){
            adjGraph[edge[0]].add(edge[1]);
        }

        // DFS
        for(int i=0;i<n;i++){
            dfs(adjGraph, i, i, ans, new boolean[n]);
        }

        // Sorting
        for(int i = 0;i<n;i++){
            ans.get(i).sort(Integer::compareTo);
        }

        return ans;
    }
    private void dfs(ArrayList<Integer>[] graph, int parent, int current, List<List<Integer>> result, boolean[] visit){
        visit[current] = true;
        for(int dest: graph[current]){
            if(!visit[dest]){
                result.get(dest).add(parent);
                dfs(graph,parent, dest, result, visit);
            }
        }
    }
}