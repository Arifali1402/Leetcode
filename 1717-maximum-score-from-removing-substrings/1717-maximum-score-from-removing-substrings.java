class Solution {
    // x = "ab" and y = "ba"
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        String top, bottom;
        int topScore, bottomScore;
        if(y>x){
            top = "ba";
            topScore = y;
            bottom = "ab";
            bottomScore = x;
        }
        else{
            top = "ab";
            topScore = x;
            bottom = "ba";
            bottomScore = y;
        }

        // Removing first top substrings from the given strings
        StringBuilder stack = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == top.charAt(1) && stack.length()>0 && stack.charAt(stack.length() - 1) == top.charAt(0)){
                ans += topScore;
                stack.setLength(stack.length()-1);
            }
            else{
                stack.append(ch);
            }
        }

        // Removing bottom substrings from the given strings
        StringBuilder new_stack = new StringBuilder();
        for(char ch: stack.toString().toCharArray()){
            if(ch == bottom.charAt(1) && new_stack.length()>0 && new_stack.charAt(new_stack.length() - 1) == bottom.charAt(0)){
                ans += bottomScore;
                new_stack.setLength(new_stack.length()-1);
            }
            else{
                new_stack.append(ch);
            }
        }
        return ans;
    }
}