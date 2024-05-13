class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        double maxi = (double)sum/k;
        for(int right = k;right<nums.length;right++){
            sum += nums[right];
            sum -= nums[left++];
            maxi = Math.max(maxi, (double)sum/k);
        }
        return maxi;
    }
}