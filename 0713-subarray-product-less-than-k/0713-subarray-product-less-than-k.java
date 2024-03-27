class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int count = 0, product = 1, left = 0;
        for(int right=0;right<nums.length;right++){
            product = product * nums[right];
            while(product >= k && left <= right){
                product = product/nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}