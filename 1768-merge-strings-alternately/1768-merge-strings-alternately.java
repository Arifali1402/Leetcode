class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < word1.length() && i < word2.length()){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
            i++;
        }
        while(i < word1.length()){
            ans.append(word1.charAt(i));
            i++;
        }
        while(i < word2.length()){
            ans.append(word2.charAt(i));
            i++;
        }
        return ans.toString();
    }
}