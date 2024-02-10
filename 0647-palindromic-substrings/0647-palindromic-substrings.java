class Solution {
    private boolean isPalindrome(String str,int i,int j){
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j = i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }
}