class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1){
            return 1;
        }
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for(char ch: s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
                len = len + 2;
            }
            else{
                set.add(ch);
            }
        }
        if(!set.isEmpty()){
            len += 1;
        }
        return len;
    }
}