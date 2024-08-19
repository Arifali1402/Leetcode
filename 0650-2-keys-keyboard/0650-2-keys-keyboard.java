class Solution {
    private int helper(int n, int copy, int paste){
        if(n == copy){
            return 0;
        }
        if(n<copy){
            return 1001;
        }
        // Paste
        int res1 = 1 + helper(n,copy+paste, paste);
        
        // Copy and Paste
        int res2 = 2 + helper(n, copy*2, copy);
        return Math.min(res1, res2);
    }
    public int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        return 1+helper(n,1,1);
    }
}