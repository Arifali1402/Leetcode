class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for(int element : nums){
            if(element == 0){
                zeroes++;
            }
            else if(element == 1){
                ones++;
            }
            else{
                twos++;
            }
        }
        int idx=0;
        for(int i=0;i<zeroes;i++){
            nums[idx] = 0;
            idx++;            
        }
        for(int i=0;i<ones;i++){
            nums[idx] = 1;
            idx++;            
        }
        for(int i=0;i<twos;i++){
            nums[idx] = 2;
            idx++;            
        }
        return;
    }
}