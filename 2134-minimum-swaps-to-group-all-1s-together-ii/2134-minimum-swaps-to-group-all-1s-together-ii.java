class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int left = 0;
        int total_ones = 0;
        for(int element: nums){
            if(element == 1){
                total_ones++;
            }
        }
        int win_ones = 0;
        int maxi_ones = 0;
        for(int right=0;right<2*n;right++){
            if(nums[right%n] == 1){
                win_ones++;
            }
            if(right-left+1 > total_ones){
                win_ones -= nums[left%n];
                left++;
            }
            maxi_ones = Math.max(maxi_ones, win_ones);
        }
        return total_ones - maxi_ones;
    }
}