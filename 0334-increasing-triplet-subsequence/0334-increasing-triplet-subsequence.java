class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int right = nums[i];
            if(left>right){
                left = right;
            }
            else if(right > left && middle > right){
                middle = right;
            }
            else if(right > left && right > middle){
                return true;
            }
        }
        return false;
    }
}