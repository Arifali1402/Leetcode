class Solution {
    private boolean isPalindrome(int i,int j, String str){
        if(i>=j){
            return true;
        }
        if(str.charAt(i) == str.charAt(j)){
            return isPalindrome(i+1,j-1,str);
        }
        return false;
    }
    public String firstPalindrome(String[] words) {
        for(String str: words){
            int n = str.length();
            if(isPalindrome(0,n-1,str)){
                return str;
            }
        }
        return "";
    }
}