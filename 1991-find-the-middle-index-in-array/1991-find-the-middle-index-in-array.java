class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for(int element: nums){
            total += element;
        }
        int left = 0;
        for(int curr = 0;curr<nums.length;curr++){
            total -= nums[curr];
            
            if(total == left){
                return curr;
            }
            left += nums[curr];
            // total = total - left;
        }
        return -1;
    }
}