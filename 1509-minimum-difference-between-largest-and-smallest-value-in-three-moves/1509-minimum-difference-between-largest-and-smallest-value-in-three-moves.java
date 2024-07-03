// Optimal Solution
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        // Get 4 minimum elments and 4 maximum elements and find the difference between
        // the smallest of each array
        int mini[] = new int[4];
        int maxi[] = new int[4];
        for (int i = 0; i < 4; i++) {
            mini[i] = nums[i];
            maxi[i] = nums[n - i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, maxi[i] - mini[4-i-1]);
        }
        return ans;
    }
}
/*
 * class Solution {
 * public int minDifference(int[] nums) {
 * // if the length of the array is less than or equal to 4, then we can convert
 * // any one of the big three elements to the smallest element and the rest 2
 * // elements to 0. after that we will get the result as 0
 * if (nums.length <= 4) {
 * return 0;
 * }
 * int n = nums.length;
 * // sort the array
 * Arrays.sort(nums);
 * // We have to consider 4 cases and find the minimum between them
 * // Remove the 3 elements from either side and calculate the difference
 * between smallest and // largest
 * int mini = Integer.MAX_VALUE;
 * for(int i=0;i<=3;i++){
 * int temp = nums[n+i-4] - nums[i];
 * mini = Math.min(mini, temp);
 * }
 * return mini;
 * }
 * }
 */