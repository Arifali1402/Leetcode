class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int count = 0;
        int left = 0;
        int maxi = Integer.MIN_VALUE;
        for(int item:nums){
            maxi = Math.max(maxi, item);
        }
        for(int right = 0;right<nums.length;right++){
            if(nums[right] == maxi) count++;
            while((count > k) || (left <= right && count == k && nums[left] != maxi)){
                if(nums[left] == maxi) count--;
                left++;              
            }
            if(count == k){
                ans += left + 1;
            }
        }
        return ans;
    }
}