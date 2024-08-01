class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        // Count the total number of drops
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }
        // if the first element is less than the last one, it will also consider as a drop
        if(nums[0]<nums[nums.length-1]){
            count++;
        }
        System.out.println(count);
        return count <= 1? true : false;
    }
}