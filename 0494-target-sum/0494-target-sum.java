class Solution {
    private int helper(int idx, int target, int arr[]){
        if(idx == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            if(target == 0 || arr[0] == target){
                return 1;
            }
            return 0;
        }
        int notPick = helper(idx-1,target,arr);
        int pick = 0;
        if(target>=arr[idx]){
            pick = helper(idx-1,target-arr[idx],arr);
        }
        return pick+notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;
        for(int num: nums){
            total += num;
        }
        if((total - target < 0) || (total - target)%2 != 0){
            return 0;
        }
        return helper(n-1,(total - target)/2,nums);
    }
}