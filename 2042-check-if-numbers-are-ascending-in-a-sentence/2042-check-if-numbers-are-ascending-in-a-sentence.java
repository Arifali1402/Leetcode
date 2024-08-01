class Solution {
    public boolean areNumbersAscending(String s) {
        String str[] = s.split(" ");
        int prev = Integer.MIN_VALUE;
        for(String st: str){
            if(st.charAt(0) >= 'a' && st.charAt(0) <= 'z'){
                continue;
            }
            else{
                int num = Integer.parseInt(st);
                if(prev < num){
                    prev = num;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}