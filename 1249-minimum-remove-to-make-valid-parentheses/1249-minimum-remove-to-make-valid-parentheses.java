class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // Left Parenthesis
        int parenthesis = 0;
       
        for(char ch: s.toCharArray()){
            if(ch >='a' && ch<='z'){
                str.append(ch);
                continue;
            }
            else if(ch == '('){
                str.append(ch);
                parenthesis++;
            }
            else if(ch == ')'){
                if(parenthesis > 0){
                    str.append(ch);
                    parenthesis--;
                }
            }
        }
        int n = str.length();
        for(int i=n-1;i>=0;i--){
            if(str.charAt(i) == '('){
                if(parenthesis > 0){
                    str.deleteCharAt(i);
                    parenthesis--;
                }
            }
        }
        return str.toString();
    }
}