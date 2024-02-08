class Solution {
    // Just Like Minimum Number of Coins to make a sum equal to target
    private int perfSum(int idx,int target, int arr[],int dp[][]){
        // Base Condition
        if(idx == 0){
            if(target%arr[0] == 0){
                return target/arr[0];
            }
            else{
                return (int)(1e9);
            }
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        // Explore all possibilities
        int notPick = perfSum(idx-1,target,arr,dp);
        int pick = (int)(1e9);
        if(target>= arr[idx]){
            pick = 1 + perfSum(idx,target-arr[idx],arr,dp);
        }
        return dp[idx][target] = Math.min(notPick,pick);
    }
    public int numSquares(int n) {
        List<Integer> list = new LinkedList<>();
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        int arr[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        int size = arr.length;
        int dp[][] = new int[size][n+1];
        for(int rows[]: dp){
            Arrays.fill(rows,-1);
        }
        return perfSum(size-1,n,arr,dp);
    }
}