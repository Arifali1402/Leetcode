class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int maxSize = 1,  maxIdx = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[i]>maxSize){
                        maxSize = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int num = nums[maxIdx];
        for(int i=maxIdx;i>=0;i--){
            if(num % nums[i] == 0 && dp[i] == maxSize){
                list.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }
        return list;
    }
}