class Solution {
    public int evalRPN(String[] tokens) {
        int n =  tokens.length;
        Stack<Integer> stack = new Stack<>();
        int x,y,value = 0;
        
        for(int i=0;i<n;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                switch(tokens[i]){
                    case "+":
                        x = stack.pop();
                        y = stack.pop();
                        value = x+y;
                        stack.push(value);
                        break;
                    case "-":
                        x = stack.pop();
                        y = stack.pop();
                        value = y-x;
                        stack.push(value);
                        break;
                    case "*":
                        x = stack.pop();
                        y = stack.pop();
                        value = x*y;
                        stack.push(value);
                        break;
                    case "/":
                        x = stack.pop();
                        y = stack.pop();
                        value = y/x;
                        stack.push(value);
                        break;
                    default:
                        continue;
                }
            }
        }
        return stack.pop();
    }
}