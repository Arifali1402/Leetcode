class Solution {
    // str1 is bigger than str2
    private boolean compareString(String str1, String str2){
        if(str1.length() != str2.length() + 1){
            return false;
        }
        int firstIdx = 0;
        int secondIdx = 0;
        while(firstIdx < str1.length()){
            if(secondIdx < str2.length() && str1.charAt(firstIdx) == str2.charAt(secondIdx)){
                firstIdx++;
                secondIdx++;
            }
            else{
                firstIdx++;
            }
        }
        if(firstIdx == str1.length() && secondIdx == str2.length()){
            return true;
        }
        return false;
    }
    public int longestStrChain(String[] words) {
        // Sort the array of words in increasing order of their length
        // Arrays.sort(words, new Comparator<String>(){
        //     @Override
        //     public int compare(String s1, String s2){
        //         return Integer.compare(s1.length(), s2.length());
        //     }
        // });
        
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        for(String w: words){
            System.out.println(w+" ");
        }
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        
        for(int idx = 0;idx<n; idx++){
            for(int prev = 0;prev<idx;prev++){
                if((compareString(words[idx], words[prev]) == true) && (dp[idx] < 1 + dp[prev])){
                    dp[idx] = 1 + dp[prev];
                }
            }
            if(dp[idx] > maxi){
                maxi = dp[idx];
            }
        }
        return maxi;
    }
}