class Solution {
    public int minDifference(int[] nums) {
        // if the length of the array is less than or equal to 4, then we can convert
        // any one of the big three elements to the smallest element and the rest 2
        // elements to 0. after that we will get the result as 0
        if (nums.length <= 4) {
            return 0;
        }
        int n = nums.length;
        // sort the array
        Arrays.sort(nums);
        // We have to consider 4 cases and find the minimum between them
        // Remove the 3 elements from either side and calculate the difference between smallest and               // largest
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=3;i++){
            int temp = nums[n+i-4] - nums[i];
            mini = Math.min(mini, temp);
        }
        return mini;
    }
}