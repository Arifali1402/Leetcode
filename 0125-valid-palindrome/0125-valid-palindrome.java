class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        StringBuilder str1 = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str1.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder str2 = new StringBuilder(str1).reverse();
        return str1.toString().equals(str2.toString());
    }
}