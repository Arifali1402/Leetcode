class Solution {
    public String reverseParentheses(String s) {
        if(s.length() == 0){
            return "";
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        // ArrayList<Character> list2 = new ArrayList<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || (ch >= 'a' && ch <= 'z')){
                stack.push(ch);
            }
            else{
                list.clear();
                while(stack.peek() != '('){
                    list.add(stack.pop());
                }
                stack.pop();
                for(char c: list){
                    stack.push(c);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.pop();
            if(ch == '(' || ch == ')'){
                continue;
            }
            str.append(ch);
        }
        return str.reverse().toString();
    }
}