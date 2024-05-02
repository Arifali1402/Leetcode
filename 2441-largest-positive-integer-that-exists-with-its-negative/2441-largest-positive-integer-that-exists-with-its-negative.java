class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int neg = nums[left];
            int pos = nums[right];
            if(pos == -(neg)){
                return pos;
            }
            else if(pos > -(neg)){
                right--;
            }
            else{
                left++;
            }
        }
        return -1;
    }
}