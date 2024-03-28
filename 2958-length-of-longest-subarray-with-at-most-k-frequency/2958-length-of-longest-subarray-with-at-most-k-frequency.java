class Solution {
    // Similar to Sliding Window Problem
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0;right<nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}