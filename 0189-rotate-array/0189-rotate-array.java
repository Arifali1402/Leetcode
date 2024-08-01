class Solution {
    // Code for reversing the array
    private void reversed(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        // if the length of the array is 1, then just return the array
        if(nums.length == 1){
            return;
        }
        // if the length of the array and the size of k is same, it means that after re
        if(nums.length == k){
            return;
        }
        int n = nums.length;
        reversed(nums, 0, n-1);
        reversed(nums, 0, (k-1)%n);
        reversed(nums, k%n, n-1);
    }
}