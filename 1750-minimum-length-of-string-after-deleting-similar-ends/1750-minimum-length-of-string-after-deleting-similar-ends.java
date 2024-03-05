class Solution {
    public int minimumLength(String s) {
        int first = 0,last = s.length()-1;
        int ans = s.length();
        while(first < last && s.charAt(first) == s.charAt(last)){
            char curr = s.charAt(first);
            while(first <= last && s.charAt(first) == curr){
                first++;
            }
            while(last >= first && s.charAt(last) == curr){
                last--;
            }
        }
        return last - first + 1;
    }
}