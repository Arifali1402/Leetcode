class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans[][] = new int[n/3][3];
        int i = 0;
        int p = 0;
        while(i<n/3){
            for(int j=0;j<3;j++){
                ans[i][j] = nums[p];
                p++;
            }
            i++;
        }
        for(int[] ele: ans){
            if(ele[2] - ele[0] > k){
                return new int[][]{};
            }
        }
        return ans;
    }
}