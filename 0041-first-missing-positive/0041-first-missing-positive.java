class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        int j = i-1;
        for(int item : nums){
            if(item <= 0 || j == item){
                continue;
            }
            else if(item != i){
                return i;
            }
            j = i;
            i++;
        }
        return i;
    }
}