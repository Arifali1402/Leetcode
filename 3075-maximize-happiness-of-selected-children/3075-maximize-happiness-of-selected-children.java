class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length;
        ans += happiness[n - 1];
        k--;
        if(k == 0){
            return ans;
        }
        
        int inc = 1;
        for(int i = n-2;i>=0 && k>0;i--){
            if((happiness[i] - inc) >= 0){
                ans += happiness[i] - inc;
                inc++;
                k--;
            }
        }
        return ans;
    }
}