class Solution {
    // Using Binary Search
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }
            else{
                int idx = Collections.binarySearch(list, nums[i]);
                if(idx < 0){
                    list.set(-idx-1,nums[i]);
                }
                else{
                    list.set(idx,nums[i]);
                }
          }
        }  
        // for (int num : nums) {
        //     int idx = Collections.binarySearch(list, num);
        //     if (idx < 0) {
        //         idx = -idx - 1; // Calculate the correct insertion point
        //     }
        //     if (idx == list.size()) {
        //         list.add(num); // Append to the list if it's the largest element
        //     } else {
        //         list.set(idx, num); // Replace the element at the insertion point
        //     }
        // }
        return list.size();
    }
}
/*
class Solution {
    // Memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int curr[] = new int[n+1];
        int next[] = new int[n+1];

        // Base case
        // We dont have to write the base cases as all the elements are zero
        for(int idx = n-1; idx >= 0; idx--){
            for(int prevIdx = idx-1; prevIdx>=-1; prevIdx--){
                int notTake = 0 + next[prevIdx+1];
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
                    take = 1 + next[idx+1]; // prevIdx is now become idx
                }
                curr[prevIdx+1] = Math.max(take, notTake);    
            }
            next = curr.clone();
        }
        return curr[-1+1];
    }
}
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Tabulation
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        // Base case
        // We dont have to write the base cases as all the elements are zero
        for(int idx = n-1; idx >= 0; idx--){
            for(int prevIdx = idx-1; prevIdx>=-1; prevIdx--){
                int notTake = 0 + dp[idx+1][prevIdx+1];
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
                    take = 1 + dp[idx+1][idx+1]; // prevIdx is now become idx
                }
                dp[idx][prevIdx+1] = Math.max(take, notTake);    
            }
        }
        return dp[0][-1+1];
    }
}
/*
// Memoization

class Solution {
    private int helper(int idx, int prevIdx, int[] nums, int dp[][]){
        // Base Condition
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1]; // prevIdx + 1 because of the coordinate shift
        }
        //Explore all possibilites
        int notTake = 0+ helper(idx+1, prevIdx, nums,dp);
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + helper(idx+1, idx, nums,dp); // prevIdx is now become idx
        }
        return dp[idx][prevIdx+1] = Math.max(take, notTake);        
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // Since prevIdx can be from -1 to n-1. dp cannot store -1. So we are doing a bit shifting.
        int dp[][] = new int[n][n];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return helper(0,-1,nums,dp);
    }
}
*/