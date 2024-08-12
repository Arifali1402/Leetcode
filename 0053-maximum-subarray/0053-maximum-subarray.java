class Solution {
    public int maxSubArray(int[] nums) {
        // A variable to store the maximum sum so far
        int max_so_far = Integer.MIN_VALUE;
        // A variable that will display the maximum sum till the current index
        int max_here = 0;
        for(int i=0;i<nums.length;i++){
            // Add the element in the current index i
            max_here += nums[i];
            // Update the max_so_far if necessary
            if(max_here > max_so_far){
                max_so_far = max_here;
            }
            // If max_here is negative, then do max_here = 0
            if(max_here < 0){
                max_here = 0;
            }
        }
        return max_so_far;
    }
}