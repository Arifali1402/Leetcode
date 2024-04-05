class Solution {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder();
        if(s.length() <= 1){
            return s;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(stack.isEmpty() == true){
                stack.push(s.charAt(i));
                continue;
            }
            else if(Math.abs(s.charAt(i) - stack.peek()) == 32){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty() == true){
            return "";
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}