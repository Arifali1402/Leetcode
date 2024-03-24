class Solution {
    // Similar to Turtle-Hare problem
    public int findDuplicate(int[] nums) {
        int turtle = nums[0];
        int hare = nums[0];
        do{
            turtle = nums[turtle];
            hare = nums[nums[hare]];
        }while(turtle != hare);
        
        turtle = nums[0];
        while(turtle != hare){
            turtle = nums[turtle];
            hare = nums[hare];
        }
        return turtle;
    }
}