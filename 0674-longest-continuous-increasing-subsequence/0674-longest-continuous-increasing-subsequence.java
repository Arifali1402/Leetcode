class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        if(nums.length == 2){
            if(nums[0]>=nums[1]){
                return 1;
            }
            else{
                return 2;
            }
        }
        int count = 1;
        int ans = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}