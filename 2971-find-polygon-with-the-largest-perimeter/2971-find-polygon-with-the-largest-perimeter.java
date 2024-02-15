class Solution {
    public long largestPerimeter(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        for(int element: nums){
            ans += element;
        }
        for(int i = nums.length-1;i>=2;i--){
            ans = ans - nums[i];
            if(ans> nums[i]){
                return ans + nums[i];
            }
        }
        return -1;
    }
}