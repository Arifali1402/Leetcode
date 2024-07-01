class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);
        //sliding window problem
        int left = 0;
        long total = 0;
        long maxSize = 0;
        for(int right=0;right<nums.length;right++){
            total += nums[right];
            // 1L for long data type
            while((nums[right] * (right-left+1L) > total + k)){
                total = total - nums[left];
                left++;
            }
            // window size = right-left+1;
            maxSize = Math.max(maxSize, (right-left+1L));
        }
        return (int) maxSize;
    }
}