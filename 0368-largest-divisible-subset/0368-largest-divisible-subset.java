class Solution {
    // Somewhat similar to LIS
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the given array
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int dp[] = new int[n];
        int hash[] = new int[n];
        
        int lastIndex = 0;
        
        Arrays.fill(dp, 1);
        
        int maxi = 1;
        
        for(int idx = 0;idx<n;idx++){
            hash[idx] = idx;
            for(int prev = 0;prev<idx;prev++){
                if((nums[idx] % nums[prev] == 0) && dp[idx] < 1 + dp[prev]){
                    dp[idx] = 1 + dp[idx];
                    hash[idx] = prev;
                }
            }
            if(dp[idx] > maxi){
                maxi = dp[idx];
                lastIndex = idx;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        // Now this will print the LIS in reverse order
        
        return list; // this will print the LIS
    }
}
/*
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
*/